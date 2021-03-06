package com.diegorubin.extractor.api.train.gateways.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Language Client
 *
 * @author diegorubin
 */
@FeignClient("train")
public interface ClassifyClient {

  @RequestMapping(method = POST, value = "/lang", consumes = APPLICATION_JSON_VALUE)
  LanguageResponse lang(@RequestBody LanguageResponse languageResponse);

  @RequestMapping(method = POST, value = "/classify/{train}", consumes = APPLICATION_JSON_VALUE)
  ClassifyResponse classify(@PathVariable("train") String train, @RequestBody ClassifyResponse classifyResponse);

}
