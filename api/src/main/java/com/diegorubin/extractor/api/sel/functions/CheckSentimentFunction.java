package com.diegorubin.extractor.api.sel.functions;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.sel.ExtractorExecutionData;
import com.diegorubin.extractor.api.train.gateways.client.ClassifyClient;
import com.diegorubin.extractor.api.train.gateways.client.ClassifyResponse;
import lang.sel.annotations.Function;
import lang.sel.commons.results.StringResult;
import lang.sel.interfaces.AbstractFunction;
import lang.sel.interfaces.OperationResult;
import lang.sel.interfaces.OperatorArgument;

/**
 * Check Sentiment Function
 *
 * @author diegorubin
 */
@Function(value = "checkSentiment", numberOfArguments = "0")
public class CheckSentimentFunction extends AbstractFunction {

  @Override
  public OperationResult execute(OperatorArgument... operatorArguments) {
    Message message = ((ExtractorExecutionData) executionData).getMessage();
    message.addAction("sentimentCheck");

    ClassifyResponse response = new ClassifyResponse();
    response.setContent(message.getContent());
    ClassifyClient trainClient = ((ExtractorExecutionData) executionData).getClassifyClient();
    response = trainClient.classify("sentiment", response);

    message.addCategory("sentiment", response.getClassification());
    return new StringResult(response.getClassification());
  }

}
