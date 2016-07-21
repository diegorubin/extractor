package com.diegorubin.tarzan.api.workers.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"versionsDelta", "appsHashcode", "applications"})
@XmlRootElement(name = "applications")
public class Applications {

  @XmlElement(name = "versions__delta")
  protected byte versionsDelta;
  @XmlElement(name = "apps__hashcode", required = true)
  protected String appsHashcode;
  @XmlElement(name = "application")
  protected List<Application> applications;

  public byte getVersionsDelta() {
    return versionsDelta;
  }
  public void setVersionsDelta(byte value) {
    this.versionsDelta = value;
  }

  public String getAppsHashcode() {
    return appsHashcode;
  }
  public void setAppsHashcode(String value) {
    this.appsHashcode = value;
  }

  public List<Application> getApplications() {
    if (applications == null) {
      applications = new ArrayList<>();
    }
    return applications;
  }
}
