package com.email.demo.config;

import com.email.demo.bean.MailMessage;
import com.email.demo.service.EmailService;
import com.email.demo.utils.MessageUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Iterator;
import java.util.List;

public class EmailQuartz extends QuartzJobBean {

    @Autowired
    private EmailService emailService;

    @Autowired
    private MessageUtil messageUtil;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<MailMessage> mailMessages = emailService.queryEmail();
        Iterator<MailMessage> iterator = mailMessages.iterator();
        while (iterator.hasNext()){
            messageUtil.sendMyEmail(iterator.next());
        }
    }
}
