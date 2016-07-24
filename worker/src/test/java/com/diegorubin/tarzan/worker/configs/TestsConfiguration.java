package com.diegorubin.tarzan.worker.configs;

import com.diegorubin.tarzan.worker.WorkerApplication;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Tests Configuration
 *
 * @author diegorubin
 */
@Configuration
@SpringApplicationConfiguration(classes = WorkerApplication.class)
public class TestsConfiguration implements InitializingBean {

  @Override
  public void afterPropertiesSet() throws Exception {

  }

}
