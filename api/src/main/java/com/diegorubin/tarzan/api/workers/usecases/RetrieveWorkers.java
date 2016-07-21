package com.diegorubin.tarzan.api.workers.usecases;

import com.diegorubin.tarzan.api.workers.domain.Application;
import com.diegorubin.tarzan.api.workers.gateways.client.EurekaAppsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Retrieve Workers
 *
 * @author diegorubin
 */
@Component
public class RetrieveWorkers {

  @Autowired
  private EurekaAppsClient client;

  public List<Application> retrieve() {
    return client.get().getApplications();
  }

}
