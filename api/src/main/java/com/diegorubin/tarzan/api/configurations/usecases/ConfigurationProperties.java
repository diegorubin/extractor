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

  public Map<String, String> get(String worker) {
    normalize(worker);
    return properties.get(worker);
  }

  public void update(Configuration configuration) {
    Configuration oldConfiguration = configurationGateway.findByWorkerName(configuration.getWorkerName());
    Optional.ofNullable(oldConfiguration).ifPresent(c -> configuration.setId(c.getId()));
    properties.put(configuration.getWorkerName(), configuration.getConfigs());
    configurationGateway.save(configuration);
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
      } else {
        configuration = initDefaultWorker(worker);
        properties.put(worker, configuration.getConfigs());
      }
    }
  }

  private Configuration initDefaultWorker(String worker) {
    Configuration configuration = new Configuration();
    configuration.setWorkerName(worker);

    Map<String, String> configs = new HashMap<>();
    configs.put("type", environment.getProperty("monitor.default.type"));
    configs.put("filter", environment.getProperty("monitor.default.filter"));
    configuration.setConfigs(configs);

    return configuration;
  }

}
