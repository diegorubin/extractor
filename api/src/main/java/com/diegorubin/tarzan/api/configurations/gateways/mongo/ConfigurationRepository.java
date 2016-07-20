package com.diegorubin.tarzan.api.configurations.gateways.mongo;

import com.diegorubin.tarzan.api.configurations.domain.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Configuration Repository
 *
 * @author diegorubin
 */
public interface ConfigurationRepository extends MongoRepository<Configuration, String> {

  Configuration findByWorkerName(String workerName);

}
