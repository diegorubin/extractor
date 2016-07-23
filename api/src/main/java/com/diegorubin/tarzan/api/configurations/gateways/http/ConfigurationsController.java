package com.diegorubin.tarzan.api.configurations.gateways.http;


import com.diegorubin.tarzan.api.configurations.domain.Configuration;
import com.diegorubin.tarzan.api.configurations.usecases.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @RequestMapping(value = "/{workerName}", method = RequestMethod.GET, produces = "text/plain")
  public String getProperties(@PathVariable("workerName") String workerName) {
    return renderProperties(workerName);
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

