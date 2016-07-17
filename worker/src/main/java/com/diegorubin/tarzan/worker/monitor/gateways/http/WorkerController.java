package com.diegorubin.tarzan.worker.monitor.gateways.http;


import com.diegorubin.tarzan.worker.monitor.domain.Worker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Worker Controller
 *
 * @author diegorubin
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {

  @RequestMapping(method = RequestMethod.GET)
  public Worker getStatus() {
    return new Worker();
  }

}
