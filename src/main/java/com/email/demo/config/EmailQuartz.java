package com.email.demo.config;

import com.email.demo.bean.MailMessage;
import com.email.demo.service.EmailService;
import com.email.demo.utils.MessageUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmailQuartz extends QuartzJobBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmailService emailService;

    @Autowired
    private MessageUtil messageUtil;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<MailMessage> mailMessages = emailService.queryEmail();
        if (mailMessages != null && mailMessages.size() > 0){
            Iterator<MailMessage> iterator = mailMessages.iterator();
            while (iterator.hasNext()){
                messageUtil.sendMyEmail(iterator.next());
            }
        } else {
            logger.info("数据库暂无数据,"+new Date());
        }

    }
}
