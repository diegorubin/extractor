package com.diegorubin.extractor.api.message.usecases;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.gateways.MessageGateway;
import com.diegorubin.extractor.api.message.gateways.rabbitmq.MessagePublisher;
import com.diegorubin.extractor.api.train.usecases.MessageIsSampleTrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

  @Autowired
  private MessagePublisher messagePublisher;

  public List<Message> findAll(String worker, LocalDate date) {
    List<Message> messages;
    if (Optional.ofNullable(worker).isPresent()) {
      messages = messageGateway.findByWorker(worker);
    }
    messages = messageGateway.findAll(date);

    return checkExistsInTrain(messages);
  }

  public List<Message> findAllUntrained() {
    List<Message> messages = messageGateway.findAll(null);
    checkExistsInTrain(messages);
    return messages.stream().filter(m -> !m.getInTrain()).collect(Collectors.toList());
  }

  public Message create(Message message) {
    messagePublisher.publishMessage(message);
    return message;
  }

  private List<Message> checkExistsInTrain(List<Message> messages) {
    messages.forEach(m -> m.setInTrain(messageIsSampleTrain.execute(m.getContent())));
    return messages;
  }

}
