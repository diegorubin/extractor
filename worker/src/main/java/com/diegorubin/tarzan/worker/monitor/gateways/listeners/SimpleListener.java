package com.diegorubin.tarzan.worker.monitor.gateways.listeners;

import com.diegorubin.tarzan.worker.monitor.domain.WorkerStatus;
import com.diegorubin.tarzan.worker.monitor.gateways.listeners.assembler.TwitterAssembler;
import com.diegorubin.tarzan.worker.nlp.usecases.ProcessMessage;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * Simple Listener
 *
 * @author diegorubin
 */
public class SimpleListener implements StatusListener {

  private ProcessMessage processMessage;
  private TwitterAssembler twitterAssembler;
  private WorkerStatus workerStatus;

  public SimpleListener(final ProcessMessage processMessage, final TwitterAssembler twitterAssembler,
      final WorkerStatus workerStatus) {
    this.processMessage = processMessage;
    this.twitterAssembler = twitterAssembler;
    this.workerStatus = workerStatus;
  }

  public void onStatus(Status status) {
    workerStatus.setCurrentStatus("LISTENING");
    workerStatus.setMessage("NORMAL");
    processMessage.execute(twitterAssembler.toMessage(status));
  }

  public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
  }

  public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
  }

  @Override
  public void onScrubGeo(long l, long l1) {

  }

  @Override
  public void onStallWarning(StallWarning stallWarning) {

  }

  @Override
  public void onException(Exception ex) {
    workerStatus.setCurrentStatus("ERROR");
    workerStatus.setMessage(ex.getMessage());
    ex.printStackTrace();
  }
}
