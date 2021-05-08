package com.email.demo.utils;

import com.email.demo.bean.MailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件服务工具类
 */
@Component
public class MessageUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送简单邮件，支持群发
     * @param message
     */
    public void sendEmail(MailMessage message){
        try {
            MimeMessage me = sender.createMimeMessage();
            MimeMailMessage mailMessage = new MimeMailMessage(me);
            mailMessage.setFrom(from);
            mailMessage.setTo(message.getToEmail().toArray(new String[message.getToEmail().size()]));
            mailMessage.setSubject(message.getSubject());
            mailMessage.setText(message.getText());
            sender.send(me);
            logger.info("发送至:"+message.getToEmail().toString()+"的邮件，发送成功！");
        } catch (Exception e) {
            logger.error("发送邮件失败！",e);
        }
    }

    /**
     * 发送带附件邮件，支持群发
     * @param message
     */
    public void sendCompleteEmail(MailMessage message){
        try {
            MimeMessage me = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(me,true);
            helper.setFrom(from);
            helper.setTo(message.getToEmail().toArray(new String[message.getToEmail().size()]));
            helper.setSubject(message.getSubject());
            helper.setText(message.getText());
            if (message.getFilePath() != null) {
                //文件流:获取本地文件
                FileSystemResource file = new FileSystemResource(new File(message.getFilePath()));
                String filename = file.getFilename();
                //可以发送多个
                helper.addAttachment(filename,file);
            }
            sender.send(me);
            logger.info("发送至:"+message.getToEmail().toString()+"的邮件，发送成功！");
        } catch (Exception e) {
            logger.error("发送邮件失败！",e);
            throw new RuntimeException("发送邮件失败!",e);
        }
    }

    public void sendMyEmail(MailMessage message){
        if (message.getFilePath() != null && !message.getFilePath().equals("")){
            // 带附件
            sendCompleteEmail(message);
        } else {
            // 不带附件
            sendEmail(message);
        }
    }

}
