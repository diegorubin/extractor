package com.diegorubin.extractor.api.message.gateways.rabbitmq;

import com.diegorubin.extractor.api.message.domain.Message;

/**
 * Message Receiver
 *
 * @author diegorubin
 */
public class MessageReceiver {

  public void receiveMessage(Message message) {
    System.out.println("Received <" + message + ">");
  }

}
