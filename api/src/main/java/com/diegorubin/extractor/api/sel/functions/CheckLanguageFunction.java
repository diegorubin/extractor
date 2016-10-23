package com.diegorubin.extractor.api.sel.functions;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.sel.ExtractorExecutionData;
import com.diegorubin.extractor.api.train.gateways.client.TrainClient;
import com.diegorubin.extractor.api.train.gateways.client.LanguageResponse;
import lang.sel.annotations.Function;
import lang.sel.commons.results.StringResult;
import lang.sel.interfaces.AbstractFunction;
import lang.sel.interfaces.OperationResult;
import lang.sel.interfaces.OperatorArgument;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Check Language Function
 */
@Function(value = "checkLanguage", numberOfArguments = "0")
public class CheckLanguageFunction extends AbstractFunction {

  public OperationResult execute(OperatorArgument... args) {
    Message message = ((ExtractorExecutionData) executionData).getMessage();
    message.addAction("checkLanguage");

    LanguageResponse response = new LanguageResponse();
    response.setContent(message.getContent());
    TrainClient trainClient = ((ExtractorExecutionData) executionData).getTrainClient();
    response = trainClient.lang(response);

    message.addCategory("lang", response.getLang());

    return new StringResult(response.getLang());
  }
}
