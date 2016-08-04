package com.diegorubin.extractor.worker.monitor.domain;

/**
 * Worker Status
 * @author diegorubin
 */
public class WorkerStatus {

  private String currentStatus;
  private String message;

  public String getCurrentStatus() {
    return currentStatus;
  }

  public void setCurrentStatus(String currentStatus) {
    this.currentStatus = currentStatus;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
