package com.diegorubin.extractor.api.train.gateways.http;

import com.diegorubin.extractor.api.train.domain.Sample;
import com.diegorubin.extractor.api.train.usecases.SampleCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Train Controller
 *
 * @author diegorubin
 */
@RestController
@RequestMapping("/train")
public class TrainController {

  @Autowired
  private SampleCrud sampleCrud;

  @RequestMapping(value = "{trainingName}", method = RequestMethod.GET)
  public List<Sample> getTrain(@PathVariable String trainingName) {
    return sampleCrud.findAll(trainingName);
  }

  @RequestMapping(value = "/sample", method = RequestMethod.POST)
  public Sample create(@RequestBody Sample sample) {
    return sampleCrud.create(sample);
  }
}
