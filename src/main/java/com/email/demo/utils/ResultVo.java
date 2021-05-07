package com.email.demo.utils;

/**
 * 数据VO类
 */
public class ResultVo {
    private String no;  // 响应码
    private String flag;  // 标志
    private String message;  // 信息

    public ResultVo(String no, String flag, String message) {
        this.no = no;
        this.flag = flag;
        this.message = message;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
