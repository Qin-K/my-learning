package com.qin_kai.fastjson.jsonfield.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author qin kai
 * @date 2020/9/29
 */
public class MyModel3 {

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
