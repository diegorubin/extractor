package com.diegorubin.extractor.api.configurations.gateways;

import com.diegorubin.extractor.api.configurations.domain.Configuration;

/**
 * Configuration Gateway
 *
 * @author diegorubin
 */
public interface ConfigurationGateway {

  Configuration findByWorkerName(String workerName);

  Configuration save(Configuration configuration);

}
