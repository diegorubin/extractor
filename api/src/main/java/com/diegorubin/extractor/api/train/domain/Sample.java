package com.diegorubin.extractor.api.train.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Sample entity
 *
 * @author diegorubin
 */
@Document
public class Sample {

  private String id;

  @JsonProperty("training_name")
  private String trainingName;

  @JsonProperty("message")
  private String message;

  @JsonProperty("category")
  private String category;

  private String getTrainingName() {
    return trainingName;
  }

  private String getMessage() {
    return message;
  }

  private String getCategory() {
    return category;
  }

  private void setTrainingName(String trainingName) {
    this.trainingName = trainingName;
  }

  private void setMessage(String message) {
    this.message = message;
  }

  private void setCategory(String category) {
    this.category = category;
  }
}
