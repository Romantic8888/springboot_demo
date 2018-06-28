package cn.itcast.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 发消息 springboot版本
 */
@RestController
@RequestMapping("/mq")
public class QueueController {
        @Autowired
        private JmsTemplate jmsTemplate;
        @Autowired
        private Environment environment;
        //发消息
        @RequestMapping("/send")
        public String send(String name){
            jmsTemplate.send(environment.getProperty("message"), new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    MapMessage mapMessage = session.createMapMessage();
                    mapMessage.setString("phone","1111111");
                    mapMessage.setString("code","123456");
                    return mapMessage;
                }
            });
            return "success";
        }
}
