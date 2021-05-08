package com.email.demo.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {


    @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(EmailQuartz.class).storeDurably().build();
    }
    @Bean
    public Trigger testQuartzTrigger(){
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(10)  //设置时间周期单位秒
//                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withSchedule(CronScheduleBuilder.cronSchedule("0 */1 * * * ?"))
                .build();
    }
}
