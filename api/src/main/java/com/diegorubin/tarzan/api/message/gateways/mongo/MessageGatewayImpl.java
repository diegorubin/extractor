package com.diegorubin.tarzan.api.message.gateways.mongo;

import com.diegorubin.tarzan.api.message.domain.Message;
import com.diegorubin.tarzan.api.message.gateways.MessageGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Message gateway implementation
 *
 * @author diegorubin
 */
@Component
public class MessageGatewayImpl implements MessageGateway {

  @Autowired
  private MessageRepository messageRepository;

  @Override
  public List<Message> findAll() {
    return messageRepository.findAll();
  }

  @Override
  public List<Message> findByWorkers(final String worker) {
    return messageRepository.findByWorker(worker);
  }

  @Override
  public Message create(Message message) {
    return messageRepository.save(message);
  }
}
