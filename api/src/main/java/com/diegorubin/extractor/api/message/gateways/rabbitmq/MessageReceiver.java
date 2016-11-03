package com.diegorubin.extractor.api.message.gateways.rabbitmq;

import com.diegorubin.extractor.api.message.domain.Message;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Message Receiver
 *
 * @author diegorubin
 */
@Component
public class MessageReceiver {

  private static final Logger LOGGER = Logger.getLogger(MessageReceiver.class.getName());

  public void receiveMessage(Message message) {
    LOGGER.log(Level.INFO, "received message {0}", message);
  }

}
