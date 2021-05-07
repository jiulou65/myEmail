package com.email.demo.bean;

import java.util.List;

/**
 * 邮件实体类
 */
public class MailMessage {
    private List<String> toEmail;  // 发送至邮箱
    private String subject;  // 主题
    private String text;  // 正文
    private String filePath;  // 附件地址

    public MailMessage(List<String> toEmail, String subject, String text) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.text = text;
    }

    public List<String> getToEmail() {
        return toEmail;
    }

    public void setToEmail(List<String> toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
