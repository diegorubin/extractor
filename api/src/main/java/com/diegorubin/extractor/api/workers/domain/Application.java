package com.diegorubin.extractor.api.workers.domain;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"name", "instance"})
public class Application {

  @XmlElement(required = true)
  protected String name;
  @XmlElement(required = true)
  protected Instance instance;

  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public Instance getInstance() {
    return instance;
  }

  public void setInstance(Instance value) {
    this.instance = value;
  }

}
