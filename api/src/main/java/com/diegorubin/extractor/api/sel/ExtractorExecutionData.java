package com.diegorubin.extractor.api.sel;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.train.gateways.client.ClassifyClient;
import lang.sel.interfaces.ExecutionData;

/**
 * Extractor Execution Data
 *
 * @author diegorubin
 */
public class ExtractorExecutionData extends ExecutionData {

  private Message message;
  private ClassifyClient classifyClient;

  public ExtractorExecutionData(Message message) {
    this.message = message;
  }

  public Message getMessage() {
    return message;
  }

  public ClassifyClient getClassifyClient() {
    return classifyClient;
  }

  public void setClassifyClient(ClassifyClient classifyClient) {
    this.classifyClient = classifyClient;
  }

}
