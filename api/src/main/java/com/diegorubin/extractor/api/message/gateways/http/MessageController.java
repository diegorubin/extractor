package com.diegorubin.extractor.api.message.gateways.http;

import com.diegorubin.extractor.api.message.domain.Message;
import com.diegorubin.extractor.api.message.usecases.MessageCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
  public List<Message> getMessages(@RequestParam(value = "worker", required = false) String worker,
                                   @RequestParam(value = "day", required = false) String date) {
    LocalDate localDate = null;
    if (date != null) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      localDate = LocalDate.parse(date, formatter);
    }
    return messageCrud.findAll(worker, localDate);
  }

  @RequestMapping(value = "untrained", method = RequestMethod.GET)
  public List<Message> getUntrained() {
    return messageCrud.findAllUntrained();
  }

  @RequestMapping(method = RequestMethod.POST)
  public Message create(@RequestBody Message message) {
    return messageCrud.create(message);
  }

}
