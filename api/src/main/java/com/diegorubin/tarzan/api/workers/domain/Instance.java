package com.diegorubin.tarzan.api.workers.domain;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "instanceId",
    "hostName",
    "app",
    "ipAddr",
    "status",
    "overriddenstatus",
    "port",
    "securePort",
    "countryId",
    "dataCenterInfo",
    "leaseInfo",
    "metadata",
    "homePageUrl",
    "statusPageUrl",
    "healthCheckUrl",
    "vipAddress",
    "secureVipAddress",
    "isCoordinatingDiscoveryServer",
    "lastUpdatedTimestamp",
    "lastDirtyTimestamp",
    "actionType"
})
public class Instance {

  @XmlElement(required = true)
  protected String instanceId;
  @XmlElement(required = true)
  protected String hostName;
  @XmlElement(required = true)
  protected String app;
  @XmlElement(required = true)
  protected String ipAddr;
  @XmlElement(required = true)
  protected String status;
  @XmlElement(required = true)
  protected String overriddenstatus;
  @XmlElement(required = true)
  protected Port port;
  @XmlElement(required = true)
  protected SecurePort securePort;
  protected byte countryId;
  @XmlElement(required = true)
  protected DataCenterInfo dataCenterInfo;
  @XmlElement(required = true)
  protected LeaseInfo leaseInfo;
  @XmlElement(required = true)
  protected Metadata metadata;
  @XmlElement(required = true)
  @XmlSchemaType(name = "anyURI")
  protected String homePageUrl;
  @XmlElement(required = true)
  @XmlSchemaType(name = "anyURI")
  protected String statusPageUrl;
  @XmlElement(required = true)
  @XmlSchemaType(name = "anyURI")
  protected String healthCheckUrl;
  @XmlElement(required = true)
  protected String vipAddress;
  @XmlElement(required = true)
  protected String secureVipAddress;
  @XmlElement(required = true)
  protected String isCoordinatingDiscoveryServer;
  protected long lastUpdatedTimestamp;
  protected long lastDirtyTimestamp;
  @XmlElement(required = true)
  protected String actionType;

  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String value) {
    this.instanceId = value;
  }

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String value) {
    this.hostName = value;
  }

  public String getApp() {
    return app;
  }

  public void setApp(String value) {
    this.app = value;
  }

  public String getIpAddr() {
    return ipAddr;
  }

  public void setIpAddr(String value) {
    this.ipAddr = value;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String value) {
    this.status = value;
  }

  public String getOverriddenstatus() {
    return overriddenstatus;
  }

  public void setOverriddenstatus(String value) {
    this.overriddenstatus = value;
  }

  public Port getPort() {
    return port;
  }

  public void setPort(Port value) {
    this.port = value;
  }

  public SecurePort getSecurePort() {
    return securePort;
  }

  public void setSecurePort(SecurePort value) {
    this.securePort = value;
  }

  public byte getCountryId() {
    return countryId;
  }

  public void setCountryId(byte value) {
    this.countryId = value;
  }

  public DataCenterInfo getDataCenterInfo() {
    return dataCenterInfo;
  }

  public void setDataCenterInfo(DataCenterInfo value) {
    this.dataCenterInfo = value;
  }

  public LeaseInfo getLeaseInfo() {
    return leaseInfo;
  }

  public void setLeaseInfo(LeaseInfo value) {
    this.leaseInfo = value;
  }

  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata value) {
    this.metadata = value;
  }

  public String getHomePageUrl() {
    return homePageUrl;
  }

  public void setHomePageUrl(String value) {
    this.homePageUrl = value;
  }

  public String getStatusPageUrl() {
    return statusPageUrl;
  }

  public void setStatusPageUrl(String value) {
    this.statusPageUrl = value;
  }

  public String getHealthCheckUrl() {
    return healthCheckUrl;
  }

  public void setHealthCheckUrl(String value) {
    this.healthCheckUrl = value;
  }

  public String getVipAddress() {
    return vipAddress;
  }

  public void setVipAddress(String value) {
    this.vipAddress = value;
  }

  public String getSecureVipAddress() {
    return secureVipAddress;
  }

  public void setSecureVipAddress(String value) {
    this.secureVipAddress = value;
  }

  public String getIsCoordinatingDiscoveryServer() {
    return isCoordinatingDiscoveryServer;
  }

  public void setIsCoordinatingDiscoveryServer(String value) {
    this.isCoordinatingDiscoveryServer = value;
  }

  public long getLastUpdatedTimestamp() {
    return lastUpdatedTimestamp;
  }

  public void setLastUpdatedTimestamp(long value) {
    this.lastUpdatedTimestamp = value;
  }

  public long getLastDirtyTimestamp() {
    return lastDirtyTimestamp;
  }

  public void setLastDirtyTimestamp(long value) {
    this.lastDirtyTimestamp = value;
  }

  public String getActionType() {
    return actionType;
  }

  public void setActionType(String value) {
    this.actionType = value;
  }

}
