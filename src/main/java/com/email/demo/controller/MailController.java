package com.email.demo.controller;

import com.email.demo.bean.MailMessage;
import com.email.demo.utils.JacksonUtil;
import com.email.demo.utils.MessageUtil;
import com.email.demo.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MessageUtil messageUtil;

    /**
     * 此方法未作参数校验，所以只支持正确的参数格式，格式错误也不会返回响应错误提示
     * 参数示例：
     *     带附件，绝对路径：{"toEmail":["xxx@qq.com","xxx@163.com"],"subject":"hi","text":"你王者好厉害呀！","filePath":"D://IDEA//Java//myEmail//src//main//resources//static//tnsnames.ora"}
     *     不带附件：{"toEmail":["xxx@qq.com","xxx@163.com"],"subject":"hi","text":"你王者好厉害呀！"}
     *
     * @param mailMessage
     * @return
     */
    @RequestMapping(path = "/send")
    @ResponseBody
    public String sendMail(@RequestBody MailMessage mailMessage){
        ResultVo ro = null;
        try {
            if (mailMessage.getFilePath() != null){
                // 带附件
                messageUtil.sendCompleteEmail(mailMessage);
            } else {
                // 不带附件
                messageUtil.sendEmail(mailMessage);
            }
            ro = new ResultVo("200","success","发送成功");
        } catch (Exception e){
            ro = new ResultVo("500","failed",e.getMessage());
        }
        return JacksonUtil.objectConvertString(ro);
    }

}
