package com.data.datachange.module.activemq.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    /**
     * 消息生产者
     */
    @RequestMapping("/send")
    public void send(){
        Map<String, String> map = new HashMap<>();
        map.put("123", "木头人");
        map.put("678", "发大财");
        this.jmsMessagingTemplate.convertAndSend(this.queue, map);
    }
}
