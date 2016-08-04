package com.diegorubin.extractor.api.configurations.gateways.mongo;

import com.diegorubin.extractor.api.configurations.domain.Configuration;
import com.diegorubin.extractor.api.configurations.gateways.ConfigurationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Configuration Gateway Implementation
 *
 * @author diegorubin
 */
@Component
public class ConfigurationGatewayImpl implements ConfigurationGateway {

  @Autowired
  private ConfigurationRepository configurationRepository;


  @Override
  public Configuration findByWorkerName(String workerName) {
    return configurationRepository.findByWorkerName(workerName);
  }

  @Override
  public Configuration save(Configuration configuration) {
    return configurationRepository.save(configuration);
  }

}

