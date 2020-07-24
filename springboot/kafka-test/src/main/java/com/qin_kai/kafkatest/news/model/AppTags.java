package com.qin_kai.kafkatest.news.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author zhangwenqiang
 * @date 2019/4/4
 */
public class AppTags {
    private String artCode;
    private List<InfoTag> infoStandTags;
    private List<InfoTag> infoTags;

    public String getArtCode() {
        return artCode;
    }

    @JSONField(name = "art_Code")
    public void setArtCode(String artCode) {
        this.artCode = artCode;
    }

    public List<InfoTag> getInfoStandTags() {
        return infoStandTags;
    }

    public void setInfoStandTags(List<InfoTag> infoStandTags) {
        this.infoStandTags = infoStandTags;
    }

    public List<InfoTag> getInfoTags() {
        return infoTags;
    }

    public void setInfoTags(List<InfoTag> infoTags) {
        this.infoTags = infoTags;
    }
}
