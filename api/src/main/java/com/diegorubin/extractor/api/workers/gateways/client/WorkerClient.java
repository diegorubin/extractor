package com.diegorubin.extractor.api.workers.gateways.client;

import com.diegorubin.extractor.api.workers.domain.Worker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Worker Client
 *
 * @author diegorubin
 */
@FeignClient("worker")
public interface WorkerClient {

  @RequestMapping(method = GET, value = "/worker", consumes = APPLICATION_JSON_VALUE)
  Worker get();

}
