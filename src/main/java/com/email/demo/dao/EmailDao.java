package com.email.demo.dao;

import com.email.demo.bean.MailMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmailDao {

    List<MailMessage> queryEmail();
}
