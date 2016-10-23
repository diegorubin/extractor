package com.diegorubin.extractor.api.train.gateways.client;

/**
 * Train Response
 *
 * @author diegorubin
 */
public class ClassifyResponse {

  private String classification;
  private String content;

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public String getClassification() {
    return classification;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }
}
