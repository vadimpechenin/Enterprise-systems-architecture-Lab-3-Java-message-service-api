package com.example.wokers_machines_l2.mqactive;
import com.example.wokers_machines_l2.entitymessages.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActiveMQConsumer {
    /*@JmsListener(destination="superqueue")
    public void processMessages(String message){
        log.info("Received:"+message);
    }*/

    @JmsListener(destination = "superqueue")
    @SendTo("superqueue-answer")
    public void processREST(Message message) {
        log.info("Received:" + message);
        //return "I got:"+click.getName();
    }
}
