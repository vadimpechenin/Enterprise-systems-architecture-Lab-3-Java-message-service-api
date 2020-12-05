package com.example.wokers_machines_l2.mqactive;
import com.example.wokers_machines_l2.entity.Machine;
import com.example.wokers_machines_l2.entitymessages.ChangeType;
import com.example.wokers_machines_l2.entitymessages.Message;
import com.example.wokers_machines_l2.repository.MachineRepository;
import com.example.wokers_machines_l2.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@Slf4j
public class ActiveMQConsumer {
    /*@JmsListener(destination="superqueue")
    public void processMessages(String message){
        log.info("Received:"+message);
    }*/
    private final static String FROM = "java_lessons_v@mail.ru";

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    private JavaMailSender emailSender;

    @JmsListener(destination = "superqueue")
    @SendTo("superqueue-answer")
    public void processREST(Message message) {
        //log.info("Received:" + message);
        //return "I got:"+click.getName();
        messageRepository.save(message);
        if (message.getEntity().equals(Machine.class.toString())) {
            if (message.getChangeType() == ChangeType.DELETE && message.getFieldName().equals("type")) {
                sendEmail(message.getEmail(), "Machine was deleted!", format("Machine with type %s was deleted", message.getFieldNewValue()));
            }
            if (message.getChangeType() == ChangeType.CREATE && message.getFieldName().equals("type")) {
                sendEmail(message.getEmail(), "Machine was created!", format("Machine with type %s was created", message.getFieldNewValue()));
            }
        }
    }

    private void sendEmail(String email, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM);
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
