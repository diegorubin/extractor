package com.diegorubin.extractor.api.train.gateways.mongo;

import com.diegorubin.extractor.api.train.domain.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Sample Repository
 *
 * @author diegorubin
 */
public interface SampleRepository extends MongoRepository<Sample, String> {

  List<Sample> findByTrainingName(String trainingName);
  Long countByMessage(String message);

}
