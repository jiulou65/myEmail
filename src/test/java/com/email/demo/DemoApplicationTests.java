package com.email.demo;

import com.email.demo.bean.MailMessage;
import com.email.demo.utils.JacksonUtil;
import com.email.demo.utils.MessageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private MessageUtil messageUtil;

    @Test
    public void test(){
        List<String> user = new ArrayList<>();
        user.add("1665222493@qq.com");
        user.add("zxx1965_top@163.com");
        MailMessage mailMessage = new MailMessage(user,"hi","你王者好厉害呀！");
        messageUtil.sendEmail(mailMessage);
    }

    @Test
    public void testConvert(){
        List<String> user = new ArrayList<>();
        user.add("1665222493@qq.com");
        MailMessage mailMessage = new MailMessage(user,"hi","你王者好厉害呀！");
        String s = JacksonUtil.objectConvertString(mailMessage);
        System.out.println(s);
    }

}
