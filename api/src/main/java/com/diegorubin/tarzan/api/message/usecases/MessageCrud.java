package com.diegorubin.tarzan.api.message.usecases;

import com.diegorubin.tarzan.api.message.domain.Message;
import com.diegorubin.tarzan.api.message.gateways.MessageGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
      return messageGateway.findByWorkers(worker);
    }
    return messageGateway.findAll();
  }

  public Message create(Message message) {
    return messageGateway.create(message);
  }

}
