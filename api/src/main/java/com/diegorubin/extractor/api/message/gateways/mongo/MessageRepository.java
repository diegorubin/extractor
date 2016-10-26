package com.diegorubin.extractor.api.message.gateways.mongo;

import com.diegorubin.extractor.api.message.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Message Repository
 *
 * @author diegorubin
 */
interface MessageRepository extends MongoRepository<Message, String> {

  List<Message> findByWorkerOrderByReceivedInDesc(String worker);
  Long countByWorker(String worker);

  @Query(value = "{'receivedIn': {'$gte': ?0, '$lte': ?1}}")
  List<Message> findByDate(LocalDateTime begin, LocalDateTime end);

}
