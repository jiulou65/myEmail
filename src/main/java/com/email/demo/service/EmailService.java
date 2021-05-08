package com.email.demo.service;

import com.email.demo.bean.MailMessage;

import java.util.List;

public interface EmailService {
    List<MailMessage> queryEmail();
}
