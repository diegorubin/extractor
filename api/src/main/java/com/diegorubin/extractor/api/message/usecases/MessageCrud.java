package com.diegorubin.extractor.api.message.usecases;

import com.diegorubin.extractor.api.configurations.domain.Configuration;
import com.diegorubin.extractor.api.configurations.gateways.ConfigurationGateway;
import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.gateways.MessageGateway;
import com.diegorubin.extractor.api.sel.ExtractorExecutionData;
import com.diegorubin.extractor.api.train.gateways.client.TrainClient;
import com.diegorubin.extractor.api.train.usecases.MessageIsSampleTrain;
import lang.sel.core.SelContext;
import lang.sel.core.SelParser;
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
  private ConfigurationGateway configurationGateway;

  @Autowired
  private MessageIsSampleTrain messageIsSampleTrain;

  @Autowired
  private SelContext selContext;

  @Autowired
  private TrainClient trainClient;

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
    Configuration configuration = configurationGateway.findByWorkerName(message.getWorker());
    String code = configuration.getConfigs().getOrDefault("treatmentCode", "").replace("\r", " ");

    ExtractorExecutionData executionData = new ExtractorExecutionData(message);
    executionData.setTrainClient(trainClient);
    SelParser parser = new SelParser(code, selContext, executionData);
    parser.evaluate();

    return messageGateway.create(message);
  }

  private List<Message> checkExistsInTrain(List<Message> messages) {
    messages.forEach(m -> m.setInTrain(messageIsSampleTrain.execute(m.getContent())));
    return messages;
  }

}
