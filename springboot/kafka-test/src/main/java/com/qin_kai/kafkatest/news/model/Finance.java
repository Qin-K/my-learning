package com.qin_kai.kafkatest.news.model;

/**
 * @author xianzhi.wang
 * @date 2018/3/13 -14:40
 */
public class Finance {
    /**
     * 词id
     */
   // private Integer wid;
    /**
     * 频次
     */
    //private Integer freq;
    /**
     * 标题频次
     */
   // private Integer titlefreq;
    /**
     * 词名
     */
    private String wname;
    /**
     * 内码
     */
    private String innercode;
    /**
     *
     */
    private String lowtype;
    /**
     * 权重
     */
    private float weight;

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getInnercode() {
        return innercode;
    }

    public void setInnercode(String innercode) {
        this.innercode = innercode;
    }

    public String getLowtype() {
        return lowtype;
    }

    public void setLowtype(String lowtype) {
        this.lowtype = lowtype;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
