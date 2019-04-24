package com.data.datachange.config.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @author lz
 * 2018/8/20 16:32
 */
@Component
@EnableScheduling
@Slf4j
public class SchedulerConfig {

    @Scheduled(cron = "${spring.scheduled.time.generate}")
    public void generateFiles(){
        log.debug("generateFiles---->>>[{}]", new Date());
    }

}
