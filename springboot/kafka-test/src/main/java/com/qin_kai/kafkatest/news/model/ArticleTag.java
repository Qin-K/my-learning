package com.qin_kai.kafkatest.news.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/3/13 -14:40
 */
public class ArticleTag {
    @JSONField(name = "Finance")
    private List<Finance> finance;
    private String mkdayType;
    private String source;
    private String contentType;
    private String market;
    private String style;

    public List<Finance> getFinance() {
        return finance;
    }

    public void setFinance(List<Finance> finance) {
        this.finance = finance;
    }

    public String getMkdayType() {
        return mkdayType;
    }

    public void setMkdayType(String mkdayType) {
        this.mkdayType = mkdayType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
