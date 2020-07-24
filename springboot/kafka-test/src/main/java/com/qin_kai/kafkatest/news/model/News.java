package com.qin_kai.kafkatest.news.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created on 2017/2/23.
 *
 * @author zhangwenqiang
 */
public class News {
    private int operateType;
    //编辑相关股票列表
    private String stockEditor;
    //文章导读	人工编辑，可有可无
    private String docuReader;
    //文章唯一网址	避免重复文章
    private String url;
    //是否评论	1-评论 0-关闭评论
    private boolean isComment;
    //文章CODE码
    private String code;
    //文章标题
    private String title;
    //文章小标题
    private String simTitle;
    //文章关键字
    private String key;
    //文章作者,逗号分割
    private String authorName;
    //文章作者拼音 ""无连接作者
    private String authorPinYin;
    //文章来源(媒体)
    private String mediaName;
    //媒体类型	0:无媒体1:杂志 2:报纸 3:机构
    private int mediaType;
    //媒体拼音	"":无连接媒体
    private String mediaPinYin;
    //搜素引擎摘要
    private String guidance;
    //文章正文
    private String content;
    //是否显示画中画	0:显示(默认) 1:关闭
    private boolean showAd;
    //是否JS股票热点	0:不启用(默认)1:启用
    private boolean stockView;
    //相关新闻	包含标题和code 格式: URL,Title,TIME|URL,Title,TIME
    private String artRelationJson;
    //相关博客	包含标题和URL,作者,用户名 格式:URL,Title,TIME,BlogName|URL,Title,TIME,BlogName
    private String blogRelationJson;
    //相关专题
    private String topicRelationJson;
    //投票组ID	0为无投票
    private int voteGroupId;
    //显示时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date showTime;
    //所属频道编号	0:无所属频道
    private int channelId;
    //原标题
    private String originalTitle;
    //原地址
    private String originalUrl;
    //编辑编号
    private String editorCode;
    //手机标题类型
    private int simType;
    //手机导读
    private String simReader;
    //手机专题
    private String simRelationJson;
    //图片新闻	图片新闻地址
    private String image;
    //是否快讯
    private boolean fast;
    //文章ID
    private int newsId;
    //全部频道列表	1,4,5 负责定向到不同频道
    private String channelAll;
    //所属行业	0=无行业 其他=具体行业
    private int industry;
    //自动相关股票列表
    private String stockAuto;
    //文章摘要	最多50个汉字 用于RSS和文章相关性对比。
    private String digest;
    //栏目列表
    private String columnList;
    //属性列表	(原来叫二级栏目)
    private String scColumnList;
    //推广到媒体头条	0:不是(默认) 1:是
    private boolean mediaTop;
    //	[预留] 发布到手机	0:不发布,1:发布
    private boolean isPhone;
    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createTime;
    //编辑ID
    private int editorId;
    //编辑姓名
    private String editorName;
    //最后修改人
    private String lastEditorName;
    //搜索量	0
    private int seachCount;
    //是否处理过	0-未处理(默认)  1-已处理  2-本地重新生成,各个接口全部更新
    private int flag;
    //期刊号
    private String serial;
    //24小时栏目
    private String h24Column;
    //24小时分类
    private int h24Type;
    //是否属于手机端 0 不属于 1 属于（重大消息推送） 2 股市早盘内参 100 +  推送完成不需要再次推送
    private int mobileType;
    //修改时间	增量获取的时间字段
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateTime;
    //状态信息0是删除 1正常
    private int state;
    //排序时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date orderTime;
    //接收时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date recvDateTime;
    //入mongo时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date mongoInsertDateTime;
    private long mongoInsertTimestamp;
    //文章标签
    private ArticleTag articleTag;
    //7*24显示样式
    private int titleStyle;
    //web地址
    private String uniqueUrl;
    /**
     * 股票标签
     */
    private AppTags appTags;
    /**
     * 新版专题使用的标签
     */
    private String appRelationJson;
    /**
     * 过期时间
     */
    private long expireTime;
    /**
     * 新闻中的视频数量
     */
    private int videoCount;

    public News() {
    }

    public News(OriginalNews originalNews) {
        stockEditor = originalNews.getStockEditor();
        docuReader = originalNews.getDocuReader();
        url = originalNews.getUrl();
        isComment = originalNews.getIsComment() != 0;
        code = originalNews.getCode();
        title = originalNews.getTitle();
        simTitle = originalNews.getSimTitle();
        key = originalNews.getKey();
        authorName = originalNews.getAuthorName();
        authorPinYin = originalNews.getAuthorPinYin();
        mediaName = originalNews.getMediaName();
        mediaType = originalNews.getMediaType();
        mediaPinYin = originalNews.getMediaPinYin();
        guidance = originalNews.getGuidance();
        content = originalNews.getContent();
        showAd = originalNews.getShowAd() != 0;
        stockView = originalNews.getStockView() != 0;
        artRelationJson = originalNews.getArtRelationJson();
        blogRelationJson = originalNews.getBlogRelationJson();
        topicRelationJson = originalNews.getTopicRelationJson();
        voteGroupId = originalNews.getVoteGroupId();
        showTime = originalNews.getShowTime();
        channelId = originalNews.getChannelId();
        originalTitle = originalNews.getOriginalTitle();
        originalUrl = originalNews.getOriginalUrl();
        editorCode = originalNews.getEditorCode();
        simType = originalNews.getSimType();
        simReader = originalNews.getSimReader();
        simRelationJson = originalNews.getSimRelationJson();
        image = originalNews.getImage();
        fast = originalNews.getFast() != 0;
        newsId = originalNews.getNewsId();
        channelAll = originalNews.getChannelAll();
        industry = originalNews.getIndustry();
        stockAuto = originalNews.getStockAuto();
        digest = originalNews.getDigest();
        columnList = originalNews.getColumnList();
        scColumnList = originalNews.getScColumnList();
        mediaTop = originalNews.getMediaTop() != 0;
        isPhone = originalNews.getIsPhone() != 0;
        createTime = originalNews.getCreateTime();
        editorId = originalNews.getEditorId();
        editorName = originalNews.getEditorName();
        lastEditorName = originalNews.getLastEditorName();
        seachCount = originalNews.getSeachCount();
        flag = originalNews.getFlag();
        serial = originalNews.getSerial();
        h24Column = originalNews.getH24Column();
        h24Type = originalNews.getH24Type();
        mobileType = originalNews.getMobileType();
        updateTime = originalNews.getUpdateTime();
        state = originalNews.getState();
        orderTime = originalNews.getOrderTime();
        articleTag = originalNews.getArticleTag();
        titleStyle = originalNews.getTitleStyle();
        uniqueUrl = originalNews.getUniqueUrl();
        appTags = originalNews.getAppTags();
        appRelationJson = originalNews.getAppRelationJson();
        expireTime = originalNews.getExpireTime();
        videoCount = originalNews.getVideoCount();
    }

    public ArticleTag getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(ArticleTag articleTag) {
        this.articleTag = articleTag;
    }

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public String getStockEditor() {
        return stockEditor;
    }

    public void setStockEditor(String stockEditor) {
        this.stockEditor = stockEditor;
    }

    public String getDocuReader() {
        return docuReader;
    }

    public void setDocuReader(String docuReader) {
        this.docuReader = docuReader;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getIsComment() {
        return isComment;
    }

    public void setIsComment(boolean isComment) {
        this.isComment = isComment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSimTitle() {
        return simTitle;
    }

    public void setSimTitle(String simTitle) {
        this.simTitle = simTitle;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPinYin() {
        return authorPinYin;
    }

    public void setAuthorPinYin(String authorPinYin) {
        this.authorPinYin = authorPinYin;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaPinYin() {
        return mediaPinYin;
    }

    public void setMediaPinYin(String mediaPinYin) {
        this.mediaPinYin = mediaPinYin;
    }

    public String getGuidance() {
        return guidance;
    }

    public void setGuidance(String guidance) {
        this.guidance = guidance;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getShowAd() {
        return showAd;
    }

    public void setShowAd(boolean showAd) {
        this.showAd = showAd;
    }

    public boolean getStockView() {
        return stockView;
    }

    public void setStockView(boolean stockView) {
        this.stockView = stockView;
    }

    public String getArtRelationJson() {
        return artRelationJson;
    }

    public void setArtRelationJson(String artRelationJson) {
        this.artRelationJson = artRelationJson;
    }

    public String getBlogRelationJson() {
        return blogRelationJson;
    }

    public void setBlogRelationJson(String blogRelationJson) {
        this.blogRelationJson = blogRelationJson;
    }

    public String getTopicRelationJson() {
        return topicRelationJson;
    }

    public void setTopicRelationJson(String topicRelationJson) {
        this.topicRelationJson = topicRelationJson;
    }

    public int getVoteGroupId() {
        return voteGroupId;
    }

    public void setVoteGroupId(int voteGroupId) {
        this.voteGroupId = voteGroupId;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getEditorCode() {
        return editorCode;
    }

    public void setEditorCode(String editorCode) {
        this.editorCode = editorCode;
    }

    public int getSimType() {
        return simType;
    }

    public void setSimType(int simType) {
        this.simType = simType;
    }

    public String getSimReader() {
        return simReader;
    }

    public void setSimReader(String simReader) {
        this.simReader = simReader;
    }

    public String getSimRelationJson() {
        return simRelationJson;
    }

    public void setSimRelationJson(String simRelationJson) {
        this.simRelationJson = simRelationJson;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getFast() {
        return fast;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getChannelAll() {
        return channelAll;
    }

    public void setChannelAll(String channelAll) {
        this.channelAll = channelAll;
    }

    public int getIndustry() {
        return industry;
    }

    public void setIndustry(int industry) {
        this.industry = industry;
    }

    public String getStockAuto() {
        return stockAuto;
    }

    public void setStockAuto(String stockAuto) {
        this.stockAuto = stockAuto;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getColumnList() {
        return columnList;
    }

    public void setColumnList(String columnList) {
        this.columnList = columnList;
    }

    public String getScColumnList() {
        return scColumnList;
    }

    public void setScColumnList(String scColumnList) {
        this.scColumnList = scColumnList;
    }

    public boolean getMediaTop() {
        return mediaTop;
    }

    public void setMediaTop(boolean mediaTop) {
        this.mediaTop = mediaTop;
    }

    public boolean getIsPhone() {
        return isPhone;
    }

    public void setIsPhone(boolean isPhone) {
        this.isPhone = isPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getLastEditorName() {
        return lastEditorName;
    }

    public void setLastEditorName(String lastEditorName) {
        this.lastEditorName = lastEditorName;
    }

    public int getSeachCount() {
        return seachCount;
    }

    public void setSeachCount(int seachCount) {
        this.seachCount = seachCount;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getH24Column() {
        return h24Column;
    }

    public void setH24Column(String h24Column) {
        this.h24Column = h24Column;
    }

    public int getH24Type() {
        return h24Type;
    }

    public void setH24Type(int h24Type) {
        this.h24Type = h24Type;
    }

    public int getMobileType() {
        return mobileType;
    }

    public void setMobileType(int mobileType) {
        this.mobileType = mobileType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getRecvDateTime() {
        return recvDateTime;
    }

    public void setRecvDateTime(Date recvDateTime) {
        this.recvDateTime = recvDateTime;
    }

    public Date getMongoInsertDateTime() {
        return mongoInsertDateTime;
    }

    public void setMongoInsertDateTime(Date mongoInsertDateTime) {
        this.mongoInsertDateTime = mongoInsertDateTime;
    }

    public long getMongoInsertTimestamp() {
        return mongoInsertTimestamp;
    }

    public void setMongoInsertTimestamp(long mongoInsertTimestamp) {
        this.mongoInsertTimestamp = mongoInsertTimestamp;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getTitleStyle() {
        return titleStyle;
    }

    public void setTitleStyle(int titleStyle) {
        this.titleStyle = titleStyle;
    }

    public String getUniqueUrl() {
        return uniqueUrl;
    }

    public void setUniqueUrl(String uniqueUrl) {
        this.uniqueUrl = uniqueUrl;
    }

    public AppTags getAppTags() {
        return appTags;
    }

    public void setAppTags(AppTags appTags) {
        this.appTags = appTags;
    }

    public String getAppRelationJson() {
        return appRelationJson;
    }

    public void setAppRelationJson(String appRelationJson) {
        this.appRelationJson = appRelationJson;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }
}
