package com.diegorubin.tarzan.api.workers.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "renewalIntervalInSecs",
    "durationInSecs",
    "registrationTimestamp",
    "lastRenewalTimestamp",
    "evictionTimestamp",
    "serviceUpTimestamp"
})
public class LeaseInfo {

  protected byte renewalIntervalInSecs;
  protected byte durationInSecs;
  protected long registrationTimestamp;
  protected long lastRenewalTimestamp;
  protected byte evictionTimestamp;
  protected long serviceUpTimestamp;

  public byte getRenewalIntervalInSecs() {
    return renewalIntervalInSecs;
  }

  public void setRenewalIntervalInSecs(byte value) {
    this.renewalIntervalInSecs = value;
  }

  public byte getDurationInSecs() {
    return durationInSecs;
  }

  public void setDurationInSecs(byte value) {
    this.durationInSecs = value;
  }

  public long getRegistrationTimestamp() {
    return registrationTimestamp;
  }

  public void setRegistrationTimestamp(long value) {
    this.registrationTimestamp = value;
  }

  public long getLastRenewalTimestamp() {
    return lastRenewalTimestamp;
  }

  public void setLastRenewalTimestamp(long value) {
    this.lastRenewalTimestamp = value;
  }

  public byte getEvictionTimestamp() {
    return evictionTimestamp;
  }

  public void setEvictionTimestamp(byte value) {
    this.evictionTimestamp = value;
  }

  public long getServiceUpTimestamp() {
    return serviceUpTimestamp;
  }

  public void setServiceUpTimestamp(long value) {
    this.serviceUpTimestamp = value;
  }

}
