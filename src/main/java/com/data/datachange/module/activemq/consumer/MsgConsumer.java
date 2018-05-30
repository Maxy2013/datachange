package com.data.datachange.module.activemq.consumer;

import com.data.datachange.config.ConfigConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class MsgConsumer {

    @JmsListener(destination = ConfigConstants.MQ_DEMO)
    public void readQueue(Map<String, String> text){
        log.info("received msg -->{}", text);
    }
}
