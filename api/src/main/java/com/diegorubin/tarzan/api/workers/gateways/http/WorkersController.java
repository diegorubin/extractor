package com.diegorubin.tarzan.api.workers.gateways.http;

import com.diegorubin.tarzan.api.workers.domain.Worker;
import com.diegorubin.tarzan.api.workers.usecases.RetrieveWorkers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Workers Controller
 *
 * @author diegorubin
 */
@RestController
@RequestMapping("/workers")
public class WorkersController {

  @Autowired
  private RetrieveWorkers retrieveWorkers;

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Worker> getWorkers() {
    return retrieveWorkers.retrieve();
  }

}
