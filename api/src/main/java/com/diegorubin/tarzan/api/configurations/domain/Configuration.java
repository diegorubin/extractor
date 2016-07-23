package com.diegorubin.tarzan.api.configurations.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * Configuration Entity
 *
 * @author diegorubin
 */
@Document
public class Configuration {

  @Id
  private String id;

  private String workerName;
  private Map<String, String> configs;
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getWorkerName() {
    return workerName;
  }

  public void setWorkerName(String workerName) {
    this.workerName = workerName;
  }

  public Map<String, String> getConfigs() {
    return configs;
  }

  public void setConfigs(Map<String, String> configs) {
    this.configs = configs;
  }


}
