package com.diegorubin.tarzan.api.workers.domain;

/**
 * Worker entity
 *
 * @author diegorubin
 */
public class Worker {

  private String name;
  private String type;
  private String filter;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }
}
