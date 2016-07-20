package com.diegorubin.tarzan.worker.monitor.domain;

import com.diegorubin.tarzan.worker.monitor.domain.enums.WorkerType;
import com.netflix.config.DynamicPropertyFactory;

/**
 * Worker
 *
 * @author diegorubin
 */
public class Worker {


  private String filter = DynamicPropertyFactory.getInstance().getStringProperty("monitor.filter", "netshoes").get();
  private WorkerType type = WorkerType.valueOf(DynamicPropertyFactory.getInstance()
      .getStringProperty("monitor.type", "TWITTER").get());

  public String getFilter() {
    return filter;
  }

  public WorkerType getType() {
    return type;
  }

}
