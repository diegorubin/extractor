package com.diegorubin.extractor.api.train.gateways.mongo;

import com.diegorubin.extractor.api.train.domain.Sample;
import com.diegorubin.extractor.api.train.gateways.SampleGateway;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Sample Gateway Implementation
 *
 * @author diegorubin
 */
@Component
public class SampleGatewayImpl implements SampleGateway {

  @Override
  public List<Sample> findAll() {
    return null;
  }

  @Override
  public List<Sample> findByTrainingName(String trainingName) {
    return null;
  }

  @Override
  public Sample create(Sample sample) {
    return null;
  }
}
