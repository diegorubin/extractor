package com.diegorubin.tarzan.api.configurations.usecases;

import com.diegorubin.tarzan.api.configurations.domain.Configuration;
import com.diegorubin.tarzan.api.configurations.gateways.ConfigurationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * Configuration Properties
 *
 * @author diegorubin
 */
@Component
public class ConfigurationProperties {

  @Autowired
  private Environment environment;

  @Autowired
  private ConfigurationGateway configurationGateway;

  private Map<String, Map<String, String>> properties = new HashMap<>();

  public void update(Configuration configuration) {
    properties.put(configuration.getWorkerName(), configuration.getConfigs());
  }

  public void forEach(String worker, BiConsumer<String, String> consumer) {
    normalize(worker);
    properties.get(worker).forEach(consumer);
  }

  private void normalize(String worker) {
    if (!properties.containsKey(worker)) {
      Configuration configuration = configurationGateway.findByWorkerName(worker);
      if (configuration != null) {
        properties.put(worker, configuration.getConfigs());
      }
      properties.put(worker, initDefaultWorker());
    }
  }

  private Map<String, String> initDefaultWorker() {
    Map<String,String> configs = new HashMap<>();
    configs.put("monitor.type", environment.getProperty("monitor.default.type"));
    configs.put("monitor.filter", environment.getProperty("monitor.default.filter"));
    return configs;
  }

}
