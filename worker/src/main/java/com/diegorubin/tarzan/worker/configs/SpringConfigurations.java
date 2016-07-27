package com.diegorubin.tarzan.worker.configs;

import com.diegorubin.tarzan.worker.monitor.domain.WorkerStatus;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.URLConfigurationSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Spring Configurations
 *
 * @author diegorubin
 */
@Configuration
public class SpringConfigurations implements InitializingBean {

  @Autowired
  private Environment env;

  @Bean
  public WorkerStatus workerStatus() {
    WorkerStatus workerStatus = new WorkerStatus();
    workerStatus.setCurrentStatus("NOT STARTED");
    return workerStatus;
  }

  @Override
  public void afterPropertiesSet() {
    try {
      if (!ConfigurationManager.isConfigurationInstalled()) {
        PolledConfigurationSource source = new URLConfigurationSource(env.getProperty("archaius.config"));
        DynamicConfiguration configuration =
            new DynamicConfiguration(source, new FixedDelayPollingScheduler(100, 1000, true));
        ConfigurationManager.install(configuration);
      }

    } catch (SecurityException | IllegalArgumentException | NullPointerException e) {
      throw new RuntimeException(e);
    }
  }
}
