package com.diegorubin.extractor.api.message.usecases;

import com.diegorubin.extractor.api.configurations.domain.Configuration;
import com.diegorubin.extractor.api.configurations.gateways.ConfigurationGateway;
import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.gateways.MessageGateway;
import com.diegorubin.extractor.api.sel.ExtractorExecutionData;
import com.diegorubin.extractor.api.train.gateways.client.ClassifyClient;
import lang.sel.commons.results.BooleanResult;
import lang.sel.core.SelContext;
import lang.sel.core.SelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * Classify Message
 *
 * @author diegorubin
 */
@Component
public class ClassifyMessage {

  private static final Logger LOGGER = Logger.getLogger(MessageCrud.class.getName());

  @Autowired
  ConfigurationGateway configurationGateway;

  @Autowired
  ClassifyClient classifyClient;

  @Autowired
  SelContext selContext;

  @Autowired
  MessageGateway messageGateway;

  public void classify(Message message) {

    message.setReceivedIn(LocalDateTime.now());
    Configuration configuration = configurationGateway.findByWorkerName(message.getWorker());
    LOGGER.info("[Message Configuration] " + configuration.toString());
    String code = configuration.getConfigs().getOrDefault("treatmentCode", "TRUE").replace("\r", " ");

    ExtractorExecutionData executionData = new ExtractorExecutionData(message);
    executionData.setClassifyClient(classifyClient);
    SelParser parser = new SelParser(code, selContext, executionData);
    BooleanResult result = (BooleanResult) parser.evaluate();

    if (result.getResult()) {
      messageGateway.create(message);
    }

  }

}
