package com.data.datachange.config.activemq;

import javax.jms.Queue;

import com.data.datachange.config.ConfigConstants;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConfig {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(ConfigConstants.MQ_DEMO);
    }
}
