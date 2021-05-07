package com.email.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jackson工具类
 */
public class JacksonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

    /**
     * 将对象转化为json字符串
     * @param obj
     * @return
     */
    public static String objectConvertString(Object obj){
        String result = null;
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("对象转json字符串失败！",e);
        }
        return result;
    }


}
