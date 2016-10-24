package com.diegorubin.extractor.api.message.usecases;

import com.diegorubin.extractor.api.configurations.domain.Configuration;
import com.diegorubin.extractor.api.configurations.gateways.ConfigurationGateway;
import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.gateways.MessageGateway;
import com.diegorubin.extractor.api.sel.ExtractorExecutionData;
import com.diegorubin.extractor.api.train.gateways.client.ClassifyClient;
import com.diegorubin.extractor.api.train.usecases.MessageIsSampleTrain;
import lang.sel.commons.results.BooleanResult;
import lang.sel.core.SelContext;
import lang.sel.core.SelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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
  private ConfigurationGateway configurationGateway;

  @Autowired
  private MessageIsSampleTrain messageIsSampleTrain;

  @Autowired
  private SelContext selContext;

  @Autowired
  private ClassifyClient classifyClient;

  public List<Message> findAll(String worker) {
    List<Message> messages;
    if (Optional.ofNullable(worker).isPresent()) {
      messages = messageGateway.findByWorker(worker);
    }
    messages = messageGateway.findAll();

    return checkExistsInTrain(messages);
  }

  public List<Message> findAllUntrained() {
    List<Message> messages = messageGateway.findAll();
    checkExistsInTrain(messages);
    return messages.stream().filter(m -> !m.getInTrain()).collect(Collectors.toList());
  }

  public Message create(Message message) {
    message.setReceivedIn(LocalDateTime.now());
    Configuration configuration = configurationGateway.findByWorkerName(message.getWorker());
    String code = configuration.getConfigs().getOrDefault("treatmentCode", "TRUE").replace("\r", " ");

    ExtractorExecutionData executionData = new ExtractorExecutionData(message);
    executionData.setClassifyClient(classifyClient);
    SelParser parser = new SelParser(code, selContext, executionData);
    BooleanResult result = (BooleanResult) parser.evaluate();

    if (result.getResult()) {
      return messageGateway.create(message);
    }
    return null;
  }

  private List<Message> checkExistsInTrain(List<Message> messages) {
    messages.forEach(m -> m.setInTrain(messageIsSampleTrain.execute(m.getContent())));
    return messages;
  }

}
