package com.diegorubin.extractor.api.train.usecases;

import com.diegorubin.extractor.api.train.gateways.SampleGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Message Is Sample Train
 *
 * @author diegorubin
 */
@Component
public class MessageIsSampleTrain {

  @Autowired
  private SampleGateway sampleGateway;

  public Boolean execute(String message) {
    return sampleGateway.countByMessage(message) > 0;
  }

}
