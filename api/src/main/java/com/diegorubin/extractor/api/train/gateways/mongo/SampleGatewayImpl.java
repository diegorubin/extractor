package com.diegorubin.extractor.api.train.gateways.mongo;

import com.diegorubin.extractor.api.train.domain.Sample;
import com.diegorubin.extractor.api.train.gateways.SampleGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Sample Gateway Implementation
 *
 * @author diegorubin
 */
@Component
public class SampleGatewayImpl implements SampleGateway {

  @Autowired
  private SampleRepository sampleRepository;

  @Override
  public List<Sample> findAll() {
    return sampleRepository.findAll();
  }

  @Override
  public List<Sample> findByTrainingName(String trainingName) {
    return sampleRepository.findByTrainingName(trainingName);
  }

  @Override
  public Sample create(Sample sample) {
    return sampleRepository.save(sample);
  }
}
