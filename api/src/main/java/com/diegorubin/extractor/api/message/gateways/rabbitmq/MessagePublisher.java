package com.diegorubin.extractor.api.message.gateways.rabbitmq;

import com.diegorubin.extractor.api.message.domain.Message;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Message Publisher
 *
 * @author diegorubin
 */
@Component
public class MessagePublisher {

  private static final Logger LOGGER = Logger.getLogger(MessagePublisher.class.getName());

  @Autowired
  TopicExchange topicExchange;

  @Autowired
  RabbitTemplate rabbitTemplate;

  public void publishMessage(Message message) {
    LOGGER.log(Level.INFO, "publishing message {0}", message);
    rabbitTemplate.convertAndSend(topicExchange.getName(), message);
  }

}
