package com.diegorubin.extractor.api.workers.domain;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"name"})
public class DataCenterInfo {

  @XmlElement(required = true)
  protected String name;
  @XmlAttribute(name = "class")
  protected String clazz;

  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String value) {
    this.clazz = value;
  }

}
