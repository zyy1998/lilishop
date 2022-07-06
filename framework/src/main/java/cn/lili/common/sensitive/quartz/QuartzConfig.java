package cn.lili.common.sensitive.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时执行配置
 * 目前只有敏感词的更新使用到了定时任务
 *
 * @author Chopper
 * @version v1.0
 * 2021-11-23 16:30
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail sensitiveQuartzDetail() {
        return JobBuilder.newJob(SensitiveQuartz.class).withIdentity("sensitiveQuartz").storeDurably().build();
    }

    /**
     * 一小时更新一次敏感词列表
     */
    @Bean
    public Trigger sensitiveQuartzTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(3600)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(sensitiveQuartzDetail())
                .withIdentity("sensitiveQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}