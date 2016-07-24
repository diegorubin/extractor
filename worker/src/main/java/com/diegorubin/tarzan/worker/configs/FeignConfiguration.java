package com.diegorubin.tarzan.worker.configs;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Feign Configuration
 */
@Configuration
@EnableFeignClients(basePackages = "com.diegorubin")
public class FeignConfiguration {
}
