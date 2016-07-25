package com.diegorubin.tarzan.api.message.domain;

import com.diegorubin.tarzan.api.message.domain.enums.Source;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

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

  private List<String> actions;

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
}
