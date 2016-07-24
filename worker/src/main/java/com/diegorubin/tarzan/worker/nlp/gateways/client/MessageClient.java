package com.diegorubin.tarzan.worker.nlp.gateways.client;

import com.diegorubin.tarzan.worker.nlp.domain.Message;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Message Client
 *
 * @author diegorubin
 */
@FeignClient("api")
public interface MessageClient {

  @RequestMapping(method = POST, value = "/messages", consumes = APPLICATION_JSON_VALUE,
      produces = APPLICATION_JSON_VALUE)
  Message create(@RequestBody Message message);

}
