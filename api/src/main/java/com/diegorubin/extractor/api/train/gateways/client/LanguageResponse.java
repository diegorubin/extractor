package com.diegorubin.extractor.api.train.gateways.client;

/**
 * Language Response
 *
 * @author diegorubin
 */
public class LanguageResponse {

  private String content;
  private String lang;

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String getLang() {
    return lang;
  }
}
