package com.diegorubin.extractor.api.sel;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.train.gateways.client.TrainClient;
import lang.sel.interfaces.ExecutionData;

/**
 * Extractor Execution Data
 *
 * @author diegorubin
 */
public class ExtractorExecutionData extends ExecutionData {

  private Message message;
  private TrainClient trainClient;

  public ExtractorExecutionData(Message message) {
    this.message = message;
  }

  public Message getMessage() {
    return message;
  }

  public TrainClient getTrainClient() {
    return trainClient;
  }

  public void setTrainClient(TrainClient trainClient) {
    this.trainClient = trainClient;
  }

}
