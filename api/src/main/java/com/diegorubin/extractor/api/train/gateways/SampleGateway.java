package com.diegorubin.extractor.api.train.gateways;

import com.diegorubin.extractor.api.train.domain.Sample;

import java.util.List;

/**
 * Sample Gateway
 *
 * @author diegorubin
 */
public interface SampleGateway {

  /**
   * List all samples
   *
   * @return list of samples
   */
  List<Sample> findAll();

  /**
   * List all samples by training name
   *
   * @param trainingName the training name
   * @return list of samples
   */
  List<Sample> findByTrainingName(String trainingName);

  /**
   * Create sample
   *
   * @param sample the sample
   * @return created sample
   */
  Sample create(Sample sample);

  Long countByMessage(String message);

}
