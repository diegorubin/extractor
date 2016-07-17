package com.diegorubin.tarzan.worker.monitor.gateways.listeners;

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

  public SimpleListener(final ProcessMessage processMessage, final TwitterAssembler twitterAssembler) {
    this.processMessage = processMessage;
    this.twitterAssembler = twitterAssembler;
  }

  public void onStatus(Status status) {
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
    ex.printStackTrace();
  }
}
