package com.diegorubin.tarzan.api.workers.gateways.client;

import com.diegorubin.tarzan.api.workers.domain.Applications;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Eureka Apps Client
 *
 * @author diegorubin
 */
public interface EurekaAppsClient {

    @RequestMapping(method = GET, value = "/eureka/apps", consumes = APPLICATION_XML_VALUE)
    Applications get();
}
