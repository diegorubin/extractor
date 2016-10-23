package com.diegorubin.extractor.api.sel.functions;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.sel.ExtractorExecutionData;
import lang.sel.annotations.Function;
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

    CrawlerResponse response = new LanguageResponse();
    response.setContent(message.getContent());
    TrainClient trainClient = ((ExtractorExecutionData) executionData).getClassifyClient();
    response = trainClient.lang(response);

    message.addCategory("lang", response.getLang());
    return new BooleanResult();
  }

}
