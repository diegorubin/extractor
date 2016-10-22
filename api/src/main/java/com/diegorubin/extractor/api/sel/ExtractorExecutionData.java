package com.diegorubin.extractor.api.sel;

import com.diegorubin.extractor.api.message.domain.Message;
import lang.sel.interfaces.ExecutionData;

/**
 * Extractor Execution Data
 *
 * @author diegorubin
 */
public class ExtractorExecutionData extends ExecutionData {

  private Message message;

  public void setMessage(Message message) {
    this.message = message;
  }

  public Message getMessage() {
    return message;
  }

}
