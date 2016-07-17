package com.diegorubin.tarzan.worker.monitor.gateways.listeners.assembler;

import com.diegorubin.tarzan.worker.nlp.domain.Message;
import org.springframework.stereotype.Component;
import twitter4j.Status;

/**
 * Twitter Assembler
 *
 * @author diegorubin
 */
@Component
public class TwitterAssembler {

  public Message toMessage(final Status status) {
    Message message = new Message();
    message.setAuthor(status.getUser().getScreenName());
    message.setContent(status.getText());

    return message;
  }

}
