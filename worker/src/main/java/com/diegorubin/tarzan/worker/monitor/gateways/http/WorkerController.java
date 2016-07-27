package com.diegorubin.tarzan.worker.monitor.gateways.http;


import com.diegorubin.tarzan.worker.monitor.domain.Worker;
import com.diegorubin.tarzan.worker.monitor.domain.WorkerStatus;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private WorkerStatus workerStatus;

  @RequestMapping(method = RequestMethod.GET)
  public Worker getStatus() {
    Worker worker = new Worker();
    worker.setStatus(workerStatus);
    return worker;
  }

}
