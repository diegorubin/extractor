package com.diegorubin.extractor.api.message.gateways;

import com.diegorubin.extractor.api.message.domain.Message;

import java.time.LocalDate;
import java.util.List;

/**
 * Message Gateway
 *
 * @author diegorubin
 */
public interface MessageGateway {

  /**
   * List all messages
   *
   * @return list of messages
   */
  List<Message> findAll(LocalDate date);

  /**
   * List all messages by worker
   *
   * @param worker the worker
   *
   * @return list of messages by worker
   */
  List<Message> findByWorker(String worker);

  /**
   * Create message
   *
   * @param message the message
   *
   * @return created message
   */
  Message create(Message message);

  /**
   * Count received messages for worker
   *
   * @param worker the worker name
   *
   * @return number of messages imported by worker
   */
  Long countByWorker(String worker);
}
