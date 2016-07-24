package com.diegorubin.tarzan.api.configurations.gateways.http;


import com.diegorubin.tarzan.api.configurations.domain.Configuration;
import com.diegorubin.tarzan.api.configurations.usecases.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

/**
 * Worker Controller
 *
 * @author diegorubin
 */
@RestController
@RequestMapping("/configurations")
public class ConfigurationsController {

  @Autowired
  private ConfigurationProperties configurations;

  @RequestMapping(method = RequestMethod.POST)
  public String setProperties(@RequestBody Configuration configuration) {
    configurations.update(configuration);
    return renderProperties(configuration.getWorkerName());
  }

  @RequestMapping(value = "/{workerName}", method = RequestMethod.GET, produces = TEXT_PLAIN_VALUE)
  public String getProperties(@PathVariable("workerName") String workerName) {
    return renderProperties(workerName);
  }

  @RequestMapping(value = "/{workerName}.json", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
  public Map<String, String> getPropertiesAsJSON(@PathVariable("workerName") String workerName) {
    return configurations.get(workerName);
  }

  private String renderProperties(String workerName) {
    final StringBuilder stringBuilder = new StringBuilder();
    configurations
        .forEach(workerName,
            (name, value) -> stringBuilder.append("monitor.").append(name).append(":").append(" ").append(value)
                .append("\n"));
    return stringBuilder.toString();
  }
}

