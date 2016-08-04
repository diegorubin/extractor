package com.diegorubin.extractor.api.message.gateways.mongo;

import com.diegorubin.extractor.api.message.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Message Repository
 *
 * @author diegorubin
 */
interface MessageRepository extends MongoRepository<Message, String> {

  List<Message> findByWorkerOrderByReceivedInDesc(String worker);
  Long countByWorker(String worker);

}
