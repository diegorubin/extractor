package com.diegorubin.tarzan.api.workers.gateways.client.commands;

import com.diegorubin.tarzan.api.message.gateways.MessageGateway;
import com.diegorubin.tarzan.api.workers.domain.Worker;
import com.diegorubin.tarzan.api.workers.gateways.client.WorkerClient;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

/**
 * Worker Command
 *
 * @author diegorubin
 */
public class WorkerCommand extends HystrixCommand<Worker> {

  private String address;
  private String name;
  private WorkerClient workerClient;
  private MessageGateway messageGateway;

  /**
   * Creates a new Worker Command
   *
   * @param address the store address
   */
  public WorkerCommand(final String name, final String address, final MessageGateway messageGateway) {
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(name))
        .andCommandKey(HystrixCommandKey.Factory.asKey(address)));

    this.address = address;
    this.name = name;
    this.messageGateway = messageGateway;
    this.workerClient = buildClient();
  }

  @Override
  protected Worker run() throws Exception {
    Worker worker = workerClient.get();
    worker.setName(name);
    worker.setAddress(address);
    worker.setMessages(messageGateway.countByWorker(name.toLowerCase()));

    return worker;
  }

  @Override
  public Worker getFallback() {
    return null;
  }

  private WorkerClient buildClient() {
    return Feign.builder().contract(new SpringMvcContract())
        .decoder(new JacksonDecoder())
        .target(WorkerClient.class, address);
  }
}
