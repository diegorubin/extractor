package com.diegorubin.extractor.api.workers.usecases;

import com.diegorubin.extractor.api.workers.domain.Worker;
import com.diegorubin.extractor.api.workers.gateways.client.EurekaAppsClient;
import com.diegorubin.extractor.api.message.gateways.MessageGateway;
import com.diegorubin.extractor.api.workers.domain.Application;
import com.diegorubin.extractor.api.workers.gateways.client.commands.WorkerCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * Retrieve Workers
 *
 * @author diegorubin
 */
@Component
public class RetrieveWorkers {

  @Autowired
  private EurekaAppsClient client;

  @Autowired
  private MessageGateway messageGateway;

  public List<Worker> retrieve() {
    final List<Future<Worker>> commands = new ArrayList<>();
    List<Application> applications = client.get().getApplications();

    applications.forEach(application -> commands.add(getFuture(application)));

    List<Worker> workers = commands
        .stream()
        .map(this::waitForWorker)
        .collect(Collectors.toList());
    return workers.stream().filter(w -> w != null).collect(Collectors.toList());
  }

  private Future<Worker> getFuture(Application application) {
    StringBuilder target = new StringBuilder();
    if (application.getInstance().getSecurePort().getEnabled().equals("true")) {
      target.append("https://");
    } else {
      target.append("http://");
    }

    target.append(application.getInstance().getIpAddr());

    if (application.getInstance().getPort().getEnabled().equals("true")) {
      target.append(":").append(application.getInstance().getPort().getValue());
    }

    WorkerCommand workerCommand = new WorkerCommand(application.getName(), target.toString(), messageGateway);
    return workerCommand.queue();
  }

  private Worker waitForWorker(Future<Worker> future) {
    try {
      return future.get(10, TimeUnit.SECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      e.printStackTrace();
    }

    return null;
  }

}
