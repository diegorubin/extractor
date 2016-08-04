package com.diegorubin.extractor.api.workers.gateways.client;

import com.diegorubin.extractor.api.workers.domain.Applications;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Eureka Apps Client
 *
 * @author diegorubin
 */
@FeignClient("eureka")
public interface EurekaAppsClient {

  @RequestMapping(method = GET, value = "/eureka/apps", consumes = APPLICATION_XML_VALUE)
  Applications get();
}
