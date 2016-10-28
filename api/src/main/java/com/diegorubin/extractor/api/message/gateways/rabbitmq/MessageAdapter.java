package com.diegorubin.extractor.api.message.gateways.rabbitmq;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Message Adapter
 *
 * @author diegorubin
 */
@Component
public class MessageAdapter {

  @Bean
  MessageReceiver receiver() {
    return new MessageReceiver();
  }

  @Bean
  MessageListenerAdapter listenerAdapter(MessageReceiver messageReceiver) {
    return new MessageListenerAdapter(messageReceiver, "receiveMessage");
  }

}
