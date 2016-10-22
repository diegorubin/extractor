package com.diegorubin.extractor.api.sel.functions;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.sel.ExtractorExecutionData;
import com.diegorubin.extractor.api.train.gateways.client.LanguageClient;
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
@Function("checkLanguage")
public class CheckLanguageFunction extends AbstractFunction {

  @Autowired
  private LanguageClient languageClient;

  public OperationResult execute(OperatorArgument... args) {
    Message message = ((ExtractorExecutionData) executionData).getMessage();
    message.addAction("checkLanguage");

    LanguageResponse response = new LanguageResponse();
    response.setContent(message.getContent());
    response = languageClient.post(response);

    return new StringResult(response.getLang());
  }
}
