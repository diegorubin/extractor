package com.diegorubin.extractor.api.train.gateways.mongo;

import com.diegorubin.extractor.api.train.domain.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Sample Repository
 *
 * @author diegorubin
 */
public interface SampleRepository extends MongoRepository<Sample, String> {
}
