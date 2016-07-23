package com.diegorubin.tarzan.api.message.gateways.mongo;

import com.diegorubin.tarzan.api.message.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Message Repository
 *
 * @author diegorubin
 */
interface MessageRepository extends MongoRepository<Message, String> {

  List<Message> findByWorker(String worker);

}
