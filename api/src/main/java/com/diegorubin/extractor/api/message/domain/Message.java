package com.diegorubin.extractor.api.message.domain;

import com.diegorubin.extractor.api.message.domain.enums.Source;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Message entity
 *
 * @author diegorubin
 */
@Document
public class Message {

  private String id;

  private Source source;
  private String content;
  private String author;
  private String worker;
  private LocalDateTime receivedIn;

  private Boolean inTrain;

  private List<String> actions;
  private Map<String, String> categories;

  public Source getSource() {
    return source;
  }

  public void setSource(Source source) {
    this.source = source;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setCategories(Map<String, String> categories) {
    this.categories = categories;
  }

  public Map<String, String> getCategories() {
    return categories;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getWorker() {
    return worker;
  }

  public void setWorker(String worker) {
    this.worker = worker;
  }

  public List<String> getActions() {
    return actions;
  }

  public void setActions(List<String> actions) {
    this.actions = actions;
  }

  public LocalDateTime getReceivedIn() {
    return receivedIn;
  }

  public void setReceivedIn(LocalDateTime receivedIn) {
    this.receivedIn = receivedIn;
  }

  public void setInTrain(Boolean inTrain) {
    this.inTrain = inTrain;
  }

  public Boolean getInTrain() {
    return inTrain;
  }
}
