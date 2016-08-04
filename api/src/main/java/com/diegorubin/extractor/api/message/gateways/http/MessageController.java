package com.diegorubin.extractor.api.message.gateways.http;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.usecases.MessageCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Message Controller
 *
 * @author diegorubin
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

  @Autowired
  private MessageCrud messageCrud;

  @RequestMapping(method = RequestMethod.GET)
  public List<Message> getMessages(@RequestParam(value = "worker", required = false) String worker) {
    return messageCrud.findAll(worker);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Message create(@RequestBody Message message) {
    return messageCrud.create(message);
  }

}
