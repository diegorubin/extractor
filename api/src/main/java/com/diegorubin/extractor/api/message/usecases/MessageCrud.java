package com.diegorubin.extractor.api.message.usecases;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.gateways.MessageGateway;
import com.diegorubin.extractor.api.train.usecases.MessageIsSampleTrain;
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

  @Autowired
  private MessageIsSampleTrain messageIsSampleTrain;

  public List<Message> findAll(String worker) {
    List<Message> messages;
    if (Optional.ofNullable(worker).isPresent()) {
      messages = messageGateway.findByWorker(worker);
    }
    messages = messageGateway.findAll();

    return checkExistsInTrain(messages);
  }

  public Message create(Message message) {
    message.setReceivedIn(LocalDateTime.now());
    return messageGateway.create(message);
  }

  private List<Message> checkExistsInTrain(List<Message> messages) {
    messages.forEach(m -> m.setInTrain(messageIsSampleTrain.execute(m.getContent())));
    return messages;
  }

}
