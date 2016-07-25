package com.diegorubin.tarzan.worker.nlp.usecases;

import com.diegorubin.tarzan.worker.nlp.domain.Message;
import com.diegorubin.tarzan.worker.nlp.gateways.client.MessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Save message
 *
 * @author diegorubin
 */
@Component
public class SaveMessage {

  @Autowired
  private Environment environment;

  @Autowired
  private MessageClient messageClient;

  public void execute(Message message) {
    message.setWorker(environment.getProperty("spring.application.name"));
    messageClient.create(message);
  }
}
