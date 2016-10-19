package com.diegorubin.extractor.api.train.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Sample entity
 *
 * @author diegorubin
 */
@Document
public class Sample {

  private String id;

  private String trainingName;
  private String message;
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

  private void getMessage(String message) {
    this.message = message;
  }

  private void getCategory(String category) {
    this.category = category;
  }
}
