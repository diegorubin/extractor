package com.diegorubin.monitor.gateways.listeners;

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

  public void onStatus(Status status) {
    System.out.println(status.getUser().getName() + " : " + status.getText());
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
