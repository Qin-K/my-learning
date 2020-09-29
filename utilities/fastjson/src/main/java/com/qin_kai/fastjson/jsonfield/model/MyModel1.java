package com.qin_kai.fastjson.jsonfield.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author qin kai
 * @Date 2020/9/29
 */
public class MyModel1 {

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
