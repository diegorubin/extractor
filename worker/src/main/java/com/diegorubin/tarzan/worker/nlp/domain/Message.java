package com.diegorubin.tarzan.worker.nlp.domain;

/**
 * Message
 *
 * @author diegorubin
 */
public class Message {

  private String content;
  private String author;

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

  @Override
  public String toString() {
    return "'" + content + "' from " + author;
  }
}
