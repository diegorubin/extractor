package com.diegorubin.tarzan.worker.nlp.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Message
 *
 * @author diegorubin
 */
public class Message {

  private String source;
  private String content;
  private String author;

  private String worker;
  private List<String> actions = new ArrayList<>();

  public String getSource() {
    return source;
  }

  public String getWorker() {
    return worker;
  }

  public List<String> getActions() {
    return actions;
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

  public void setWorker(String worker) {
    this.worker = worker;
  }

  public void setSource(String source) {
    this.source = source;
  }

  @Override
  public String toString() {
    return "'" + content + "' by " + author + " from " + source;
  }
}
