package com.diegorubin.monitor.gateways;

import com.diegorubin.monitor.gateways.listeners.SimpleListener;
import org.springframework.stereotype.Component;
import twitter4j.*;

/**
 * Twitter Gateway
 *
 * @author diegorubin
 */
@Component
public class TwitterGateway {

  private String filter;

  public void listen() {
    StatusListener listener = new SimpleListener();
    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
    twitterStream.addListener(listener);

    FilterQuery filterQuery = new FilterQuery();
    filterQuery.track(getFilter());

    twitterStream.filter(filterQuery);
  }

  private String getFilter() {
    return "netshoes";
  }

}
