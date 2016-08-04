package com.diegorubin.extractor.worker.nlp.usecases;

import com.diegorubin.extractor.worker.nlp.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

/**
 * Process Message
 *
 * @author diegorubin
 */
@Component
public class ProcessMessage {

  @Autowired
  private CounterService counterService;

  @Autowired
  private SaveMessage saveMessage;

  public void execute(final Message message) {
    counterService.increment("worker.processed_messages.count");
    saveMessage.execute(message);
  }

}

