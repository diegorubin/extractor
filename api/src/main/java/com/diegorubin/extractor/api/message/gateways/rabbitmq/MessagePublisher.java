package com.diegorubin.extractor.api.message.gateways.rabbitmq;

import com.diegorubin.extractor.api.message.domain.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Message Publisher
 *
 * @author diegorubin
 */
@Component
public class MessagePublisher {

  @Autowired
  RabbitTemplate rabbitTemplate;

  public void publishMessage(Message message) {
    rabbitTemplate.convertAndSend(message);
  }

}
