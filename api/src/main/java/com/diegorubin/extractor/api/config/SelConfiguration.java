package com.diegorubin.extractor.api.config;

import lang.sel.core.EngineContext;
import lang.sel.springboot.EngineLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sel Configuration
 *
 * @author diegorubin
 */
@Configuration
public class SelConfiguration {

  @Bean
  public EngineContext engineContext() {
    EngineLoader engineLoader = new EngineLoader();
    EngineContext engineContext = new EngineContext();
    engineLoader.load(engineContext, "com.diegorubin.extractor");
    return engineContext;
  }

}
