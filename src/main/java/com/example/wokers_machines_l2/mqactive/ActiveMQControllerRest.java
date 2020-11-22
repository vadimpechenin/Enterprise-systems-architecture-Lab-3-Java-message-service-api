package com.example.wokers_machines_l2.mqactive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wokers_machines_l2.entitymessages.Message;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import lombok.val;

@RestController
@RequestMapping("/active")
public class ActiveMQControllerRest {
    @Autowired
    private JmsTemplate jmsTemplate;

   /* @GetMapping(value="/send/{message}", produces="text/html")
    public String sendMessage(@PathVariable("message")String message){
        jmsTemplate.convertAndSend("superqueue",message);
        return "done";
    }*/

    @GetMapping(value="/send/{message}", produces="text/html")
    public String sendMessage(@PathVariable("message")String message) throws Exception{
        Date date1 = new Date();
        val message1 = new Message();
        Long id1 = (long)(int)(Math.random() * 3 );
        message1.setId(id1);
        message1.setChangeType("Get");
        message1.setEntity("Click");
        message1.setIdEntity((long)(ThreadLocalRandom.current().nextInt(20)));
        message1.setFieldName("Name");
        message1.setFieldNewValue(message);
        message1.setUpdateDate(date1);
        message1.setEmailСharacter("java_lessons@mail.ru");
        jmsTemplate.convertAndSend("superqueue",message1);
        return "done.sent:"+message;
    }
}
