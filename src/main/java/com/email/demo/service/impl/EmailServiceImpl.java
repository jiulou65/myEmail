package com.email.demo.service.impl;

import com.email.demo.bean.MailMessage;
import com.email.demo.dao.EmailDao;
import com.email.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailDao emailDao;

    @Override
    public List<MailMessage> queryEmail() {
        return emailDao.queryEmail();
    }
}
