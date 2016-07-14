package com.diegorubin.tarzan.worker.monitor.gateways;

import com.diegorubin.tarzan.worker.monitor.gateways.listeners.SimpleListener;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.springframework.stereotype.Component;
import twitter4j.*;

import java.util.Optional;

/**
 * Twitter Gateway
 *
 * @author diegorubin
 */
@Component
public class TwitterGateway {

  private TwitterStream twitterStream;
  private StatusListener listener;
  private DynamicStringProperty filter = DynamicPropertyFactory
      .getInstance().getStringProperty("monitor.twitter.filter", "netshoes", new Runnable() {
        @Override
        public void run() {
          Optional.ofNullable(twitterStream).ifPresent(t -> track(filter.get()));
        }
      });

  public void listen() {
    track(filter.get());
  }


  private void track(String filter) {
    Optional.ofNullable(twitterStream).ifPresent(stream -> stream.removeListener(listener));

    listener = new SimpleListener();
    twitterStream = new TwitterStreamFactory().getInstance();

    twitterStream.addListener(listener);

    FilterQuery filterQuery = new FilterQuery();
    filterQuery.track(filter);

    twitterStream.filter(filterQuery);
  }

}
