package com.diegorubin.extractor.api.message.gateways.mongo;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.gateways.MessageGateway;
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
  public List<Message> findByWorker(final String worker) {
    return messageRepository.findByWorkerOrderByReceivedInDesc(worker);
  }

  @Override
  public Message create(Message message) {
    return messageRepository.save(message);
  }

  @Override
  public Long countByWorker(String worker) {
    return messageRepository.countByWorker(worker);
  }
}
