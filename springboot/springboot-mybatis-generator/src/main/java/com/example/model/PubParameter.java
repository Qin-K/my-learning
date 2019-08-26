package com.example.model;

public class PubParameter {
    private Integer aprId;

    private String aprName;

    private String aprCode;

    private String aprValue;

    private String aprShowmsg;

    public PubParameter(Integer aprId, String aprName, String aprCode, String aprValue, String aprShowmsg) {
        this.aprId = aprId;
        this.aprName = aprName;
        this.aprCode = aprCode;
        this.aprValue = aprValue;
        this.aprShowmsg = aprShowmsg;
    }

    public PubParameter() {
        super();
    }

    public Integer getAprId() {
        return aprId;
    }

    public void setAprId(Integer aprId) {
        this.aprId = aprId;
    }

    public String getAprName() {
        return aprName;
    }

    public void setAprName(String aprName) {
        this.aprName = aprName == null ? null : aprName.trim();
    }

    public String getAprCode() {
        return aprCode;
    }

    public void setAprCode(String aprCode) {
        this.aprCode = aprCode == null ? null : aprCode.trim();
    }

    public String getAprValue() {
        return aprValue;
    }

    public void setAprValue(String aprValue) {
        this.aprValue = aprValue == null ? null : aprValue.trim();
    }

    public String getAprShowmsg() {
        return aprShowmsg;
    }

    public void setAprShowmsg(String aprShowmsg) {
        this.aprShowmsg = aprShowmsg == null ? null : aprShowmsg.trim();
    }
}