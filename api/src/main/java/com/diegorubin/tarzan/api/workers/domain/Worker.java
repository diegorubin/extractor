package com.diegorubin.tarzan.api.workers.domain;

/**
 * Worker entity
 *
 * @author diegorubin
 */
public class Worker {

  private String name;
  private String type;
  private String filter;
  private String address;
  private Long messages;
  private WorkerStatus workerStatus;

  public WorkerStatus getStatus() {
    return workerStatus;
  }

  public void setStatus(WorkerStatus workerStatus) {
    this.workerStatus = workerStatus;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  public void setMessages(Long messages) {
    this.messages = messages;
  }

  public Long getMessages() {
    return messages;
  }

}
