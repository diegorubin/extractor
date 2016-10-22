package com.diegorubin.extractor.api.train.usecases;

import com.diegorubin.extractor.api.train.domain.Sample;
import com.diegorubin.extractor.api.train.gateways.SampleGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Sample Crud Use Case
 *
 * @author diegorubin
 */
@Component
public class SampleCrud {

  @Autowired
  private SampleGateway sampleGateway;

  public List<Sample> findAll(String trainingName) {
    return sampleGateway.findByTrainingName(trainingName);
  }

  public Sample create(Sample sample) {
    return sampleGateway.create(sample);
  }

  public Long countByMessage(String message) {
    return sampleGateway.countByMessage(message);
  }
}
