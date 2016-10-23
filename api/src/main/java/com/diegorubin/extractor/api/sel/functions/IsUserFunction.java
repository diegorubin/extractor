package com.diegorubin.extractor.api.sel.functions;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.sel.ExtractorExecutionData;
import com.diegorubin.extractor.api.train.gateways.client.ClassifyClient;
import com.diegorubin.extractor.api.train.gateways.client.ClassifyResponse;
import lang.sel.annotations.Function;
import lang.sel.commons.results.BooleanResult;
import lang.sel.interfaces.AbstractFunction;
import lang.sel.interfaces.OperationResult;
import lang.sel.interfaces.OperatorArgument;

/**
 * Is User Function
 *
 * @author diegorubin
 */
@Function(value = "isUser", numberOfArguments = "0")
public class IsUserFunction extends AbstractFunction {

  public OperationResult execute(OperatorArgument... args) {
    Message message = ((ExtractorExecutionData) executionData).getMessage();
    message.addAction("userCheck");

    ClassifyResponse response = new ClassifyResponse();
    response.setContent(message.getContent());
    ClassifyClient trainClient = ((ExtractorExecutionData) executionData).getClassifyClient();
    response = trainClient.classify("crawler", response);

    message.addCategory("origin", response.getClassification());
    return new BooleanResult(response.getClassification().equals("user"));
  }

}
