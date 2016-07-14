package com.diegorubin.tarzan.worker.monitor.gateways;

import com.diegorubin.tarzan.worker.monitor.gateways.listeners.SimpleListener;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.springframework.stereotype.Component;
import twitter4j.*;

/**
 * Twitter Gateway
 *
 * @author diegorubin
 */
@Component
public class TwitterGateway {
  DynamicStringProperty filter = DynamicPropertyFactory
      .getInstance().getStringProperty("monitor.twitter.filter", "netshoes", new Runnable() {
        @Override
        public void run() {
          track(filter.get());
        }
      });

  public void listen() {
    track(filter.get());
  }


  private void track(String filter) {
    System.out.println("\nnew filter");

    StatusListener listener = new SimpleListener();
    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
    twitterStream.addListener(listener);

    FilterQuery filterQuery = new FilterQuery();
    filterQuery.track(filter);

    twitterStream.filter(filterQuery);
  }

}
