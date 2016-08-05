package com.diegorubin.extractor.api.message.usecases;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.gateways.MessageGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Message Crud Use Case
 *
 * @author diegorubin
 */
@Component
public class MessageCrud {

  @Autowired
  private MessageGateway messageGateway;

  public List<Message> findAll(String worker) {
    if (Optional.ofNullable(worker).isPresent()) {
      return messageGateway.findByWorker(worker);
    }
    return messageGateway.findAll();
  }

  public Message create(Message message) {
    message.setReceivedIn(LocalDateTime.now());
    return messageGateway.create(message);
  }

}