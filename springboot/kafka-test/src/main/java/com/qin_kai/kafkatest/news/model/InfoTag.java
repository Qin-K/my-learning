package com.qin_kai.kafkatest.news.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zhangwenqiang
 * @date 2019/4/4
 */
public class InfoTag {
    /**
     * 词名
     */
    private String wname = "";
    /**
     * 内码
     */
    private String innerCode = "";
    /**
     *
     */
    private String lowType = "";
    /**
     * 权重
     */
    private double weight;
    /**
     * 个股代码
     */
    private String secuCode = "";

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getInnerCode() {
        return innerCode;
    }

    @JSONField(name = "innercode")
    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public String getLowType() {
        return lowType;
    }

    @JSONField(name = "lowtype")
    public void setLowType(String lowType) {
        this.lowType = lowType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSecuCode() {
        return secuCode;
    }

    @JSONField(name = "secucode")
    public void setSecuCode(String secuCode) {
        this.secuCode = secuCode;
    }
}
