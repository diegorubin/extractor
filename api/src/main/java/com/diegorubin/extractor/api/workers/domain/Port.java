package com.diegorubin.extractor.api.workers.domain;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"value"})
public class Port {

  @XmlValue
  protected short value;
  @XmlAttribute(name = "enabled")
  protected String enabled;

  public short getValue() {
    return value;
  }

  public void setValue(short value) {
    this.value = value;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String value) {
    this.enabled = value;
  }

}
