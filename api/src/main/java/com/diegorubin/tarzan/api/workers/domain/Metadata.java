package com.diegorubin.tarzan.api.workers.domain;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"value"})
public class Metadata {

  @XmlValue
  protected String value;
  @XmlAttribute(name = "class")
  protected String clazz;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String value) {
    this.clazz = value;
  }

}

