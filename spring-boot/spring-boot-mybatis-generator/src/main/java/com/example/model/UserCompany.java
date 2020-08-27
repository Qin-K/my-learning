package com.example.model;

import java.util.Date;

public class UserCompany {
    private String companyId;

    private String number;

    private String organizationCode;

    private String certificateType;

    private String companyName;

    private String industry;

    private String scale;

    private String concepts;

    private String legalPersonName;

    private String legalPersonIdentityNo;

    private String legalPersonPhoneNo;

    private String ifJointStockExchangeCenter;

    private String companyContractUserPhoneNo;

    private String companyContractUserName;

    private String businessPath;

    private String companyAuthorizationPath;

    private String province;

    private String city;

    private String county;

    private String town;

    private String companyLocation;

    private String companySummary;

    private String companyCharacteristics;

    private Date createTime;

    private Date auditTime;

    private String channel;

    private String email;

    private String note;

    private String legalPersonPathFront;

    private String legalPersonPathBack;

    private String companyLogoPath;

    private String creditCollectionPath;

    private Integer count;

    private String applyUserId;

    private Date updateTime;

    private Boolean currentType;

    private Boolean applyType;

    private Boolean applyStatus;

    private String paCompanyId;

    private String stickScale;

    private Date stickCreateTime;

    private String ifAuthorization;

    private Boolean isShowInFront;

    public UserCompany(String companyId, String number, String organizationCode, String certificateType, String companyName, String industry, String scale, String concepts, String legalPersonName, String legalPersonIdentityNo, String legalPersonPhoneNo, String ifJointStockExchangeCenter, String companyContractUserPhoneNo, String companyContractUserName, String businessPath, String companyAuthorizationPath, String province, String city, String county, String town, String companyLocation, String companySummary, String companyCharacteristics, Date createTime, Date auditTime, String channel, String email, String note, String legalPersonPathFront, String legalPersonPathBack, String companyLogoPath, String creditCollectionPath, Integer count, String applyUserId, Date updateTime, Boolean currentType, Boolean applyType, Boolean applyStatus, String paCompanyId, String stickScale, Date stickCreateTime, String ifAuthorization, Boolean isShowInFront) {
        this.companyId = companyId;
        this.number = number;
        this.organizationCode = organizationCode;
        this.certificateType = certificateType;
        this.companyName = companyName;
        this.industry = industry;
        this.scale = scale;
        this.concepts = concepts;
        this.legalPersonName = legalPersonName;
        this.legalPersonIdentityNo = legalPersonIdentityNo;
        this.legalPersonPhoneNo = legalPersonPhoneNo;
        this.ifJointStockExchangeCenter = ifJointStockExchangeCenter;
        this.companyContractUserPhoneNo = companyContractUserPhoneNo;
        this.companyContractUserName = companyContractUserName;
        this.businessPath = businessPath;
        this.companyAuthorizationPath = companyAuthorizationPath;
        this.province = province;
        this.city = city;
        this.county = county;
        this.town = town;
        this.companyLocation = companyLocation;
        this.companySummary = companySummary;
        this.companyCharacteristics = companyCharacteristics;
        this.createTime = createTime;
        this.auditTime = auditTime;
        this.channel = channel;
        this.email = email;
        this.note = note;
        this.legalPersonPathFront = legalPersonPathFront;
        this.legalPersonPathBack = legalPersonPathBack;
        this.companyLogoPath = companyLogoPath;
        this.creditCollectionPath = creditCollectionPath;
        this.count = count;
        this.applyUserId = applyUserId;
        this.updateTime = updateTime;
        this.currentType = currentType;
        this.applyType = applyType;
        this.applyStatus = applyStatus;
        this.paCompanyId = paCompanyId;
        this.stickScale = stickScale;
        this.stickCreateTime = stickCreateTime;
        this.ifAuthorization = ifAuthorization;
        this.isShowInFront = isShowInFront;
    }

    public UserCompany() {
        super();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getConcepts() {
        return concepts;
    }

    public void setConcepts(String concepts) {
        this.concepts = concepts == null ? null : concepts.trim();
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName == null ? null : legalPersonName.trim();
    }

    public String getLegalPersonIdentityNo() {
        return legalPersonIdentityNo;
    }

    public void setLegalPersonIdentityNo(String legalPersonIdentityNo) {
        this.legalPersonIdentityNo = legalPersonIdentityNo == null ? null : legalPersonIdentityNo.trim();
    }

    public String getLegalPersonPhoneNo() {
        return legalPersonPhoneNo;
    }

    public void setLegalPersonPhoneNo(String legalPersonPhoneNo) {
        this.legalPersonPhoneNo = legalPersonPhoneNo == null ? null : legalPersonPhoneNo.trim();
    }

    public String getIfJointStockExchangeCenter() {
        return ifJointStockExchangeCenter;
    }

    public void setIfJointStockExchangeCenter(String ifJointStockExchangeCenter) {
        this.ifJointStockExchangeCenter = ifJointStockExchangeCenter == null ? null : ifJointStockExchangeCenter.trim();
    }

    public String getCompanyContractUserPhoneNo() {
        return companyContractUserPhoneNo;
    }

    public void setCompanyContractUserPhoneNo(String companyContractUserPhoneNo) {
        this.companyContractUserPhoneNo = companyContractUserPhoneNo == null ? null : companyContractUserPhoneNo.trim();
    }

    public String getCompanyContractUserName() {
        return companyContractUserName;
    }

    public void setCompanyContractUserName(String companyContractUserName) {
        this.companyContractUserName = companyContractUserName == null ? null : companyContractUserName.trim();
    }

    public String getBusinessPath() {
        return businessPath;
    }

    public void setBusinessPath(String businessPath) {
        this.businessPath = businessPath == null ? null : businessPath.trim();
    }

    public String getCompanyAuthorizationPath() {
        return companyAuthorizationPath;
    }

    public void setCompanyAuthorizationPath(String companyAuthorizationPath) {
        this.companyAuthorizationPath = companyAuthorizationPath == null ? null : companyAuthorizationPath.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation == null ? null : companyLocation.trim();
    }

    public String getCompanySummary() {
        return companySummary;
    }

    public void setCompanySummary(String companySummary) {
        this.companySummary = companySummary == null ? null : companySummary.trim();
    }

    public String getCompanyCharacteristics() {
        return companyCharacteristics;
    }

    public void setCompanyCharacteristics(String companyCharacteristics) {
        this.companyCharacteristics = companyCharacteristics == null ? null : companyCharacteristics.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getLegalPersonPathFront() {
        return legalPersonPathFront;
    }

    public void setLegalPersonPathFront(String legalPersonPathFront) {
        this.legalPersonPathFront = legalPersonPathFront == null ? null : legalPersonPathFront.trim();
    }

    public String getLegalPersonPathBack() {
        return legalPersonPathBack;
    }

    public void setLegalPersonPathBack(String legalPersonPathBack) {
        this.legalPersonPathBack = legalPersonPathBack == null ? null : legalPersonPathBack.trim();
    }

    public String getCompanyLogoPath() {
        return companyLogoPath;
    }

    public void setCompanyLogoPath(String companyLogoPath) {
        this.companyLogoPath = companyLogoPath == null ? null : companyLogoPath.trim();
    }

    public String getCreditCollectionPath() {
        return creditCollectionPath;
    }

    public void setCreditCollectionPath(String creditCollectionPath) {
        this.creditCollectionPath = creditCollectionPath == null ? null : creditCollectionPath.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId == null ? null : applyUserId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getCurrentType() {
        return currentType;
    }

    public void setCurrentType(Boolean currentType) {
        this.currentType = currentType;
    }

    public Boolean getApplyType() {
        return applyType;
    }

    public void setApplyType(Boolean applyType) {
        this.applyType = applyType;
    }

    public Boolean getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Boolean applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getPaCompanyId() {
        return paCompanyId;
    }

    public void setPaCompanyId(String paCompanyId) {
        this.paCompanyId = paCompanyId == null ? null : paCompanyId.trim();
    }

    public String getStickScale() {
        return stickScale;
    }

    public void setStickScale(String stickScale) {
        this.stickScale = stickScale == null ? null : stickScale.trim();
    }

    public Date getStickCreateTime() {
        return stickCreateTime;
    }

    public void setStickCreateTime(Date stickCreateTime) {
        this.stickCreateTime = stickCreateTime;
    }

    public String getIfAuthorization() {
        return ifAuthorization;
    }

    public void setIfAuthorization(String ifAuthorization) {
        this.ifAuthorization = ifAuthorization == null ? null : ifAuthorization.trim();
    }

    public Boolean getIsShowInFront() {
        return isShowInFront;
    }

    public void setIsShowInFront(Boolean isShowInFront) {
        this.isShowInFront = isShowInFront;
    }
}