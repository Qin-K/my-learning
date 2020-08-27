package com.example.model;

import java.math.BigDecimal;

public class CompanyExtension {
    private String companyId;

    private String registeredCapital;

    private String companyChargeUserName;

    private String companyChargeUserPhoneNo;

    private Boolean industryStatus;

    private String projectFinancingNeeds;

    private Boolean stockRightFinancingNeeds;

    private BigDecimal stockRightFinancingQuota;

    private String ratioOfEquityQuotaReleased;

    private Boolean roadshowWillingness;

    private Boolean listingPlan;

    private String suggestion;

    private String noteInfo;

    public CompanyExtension(String companyId, String registeredCapital, String companyChargeUserName, String companyChargeUserPhoneNo, Boolean industryStatus, String projectFinancingNeeds, Boolean stockRightFinancingNeeds, BigDecimal stockRightFinancingQuota, String ratioOfEquityQuotaReleased, Boolean roadshowWillingness, Boolean listingPlan, String suggestion, String noteInfo) {
        this.companyId = companyId;
        this.registeredCapital = registeredCapital;
        this.companyChargeUserName = companyChargeUserName;
        this.companyChargeUserPhoneNo = companyChargeUserPhoneNo;
        this.industryStatus = industryStatus;
        this.projectFinancingNeeds = projectFinancingNeeds;
        this.stockRightFinancingNeeds = stockRightFinancingNeeds;
        this.stockRightFinancingQuota = stockRightFinancingQuota;
        this.ratioOfEquityQuotaReleased = ratioOfEquityQuotaReleased;
        this.roadshowWillingness = roadshowWillingness;
        this.listingPlan = listingPlan;
        this.suggestion = suggestion;
        this.noteInfo = noteInfo;
    }

    public CompanyExtension() {
        super();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    public String getCompanyChargeUserName() {
        return companyChargeUserName;
    }

    public void setCompanyChargeUserName(String companyChargeUserName) {
        this.companyChargeUserName = companyChargeUserName == null ? null : companyChargeUserName.trim();
    }

    public String getCompanyChargeUserPhoneNo() {
        return companyChargeUserPhoneNo;
    }

    public void setCompanyChargeUserPhoneNo(String companyChargeUserPhoneNo) {
        this.companyChargeUserPhoneNo = companyChargeUserPhoneNo == null ? null : companyChargeUserPhoneNo.trim();
    }

    public Boolean getIndustryStatus() {
        return industryStatus;
    }

    public void setIndustryStatus(Boolean industryStatus) {
        this.industryStatus = industryStatus;
    }

    public String getProjectFinancingNeeds() {
        return projectFinancingNeeds;
    }

    public void setProjectFinancingNeeds(String projectFinancingNeeds) {
        this.projectFinancingNeeds = projectFinancingNeeds == null ? null : projectFinancingNeeds.trim();
    }

    public Boolean getStockRightFinancingNeeds() {
        return stockRightFinancingNeeds;
    }

    public void setStockRightFinancingNeeds(Boolean stockRightFinancingNeeds) {
        this.stockRightFinancingNeeds = stockRightFinancingNeeds;
    }

    public BigDecimal getStockRightFinancingQuota() {
        return stockRightFinancingQuota;
    }

    public void setStockRightFinancingQuota(BigDecimal stockRightFinancingQuota) {
        this.stockRightFinancingQuota = stockRightFinancingQuota;
    }

    public String getRatioOfEquityQuotaReleased() {
        return ratioOfEquityQuotaReleased;
    }

    public void setRatioOfEquityQuotaReleased(String ratioOfEquityQuotaReleased) {
        this.ratioOfEquityQuotaReleased = ratioOfEquityQuotaReleased == null ? null : ratioOfEquityQuotaReleased.trim();
    }

    public Boolean getRoadshowWillingness() {
        return roadshowWillingness;
    }

    public void setRoadshowWillingness(Boolean roadshowWillingness) {
        this.roadshowWillingness = roadshowWillingness;
    }

    public Boolean getListingPlan() {
        return listingPlan;
    }

    public void setListingPlan(Boolean listingPlan) {
        this.listingPlan = listingPlan;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    public String getNoteInfo() {
        return noteInfo;
    }

    public void setNoteInfo(String noteInfo) {
        this.noteInfo = noteInfo == null ? null : noteInfo.trim();
    }
}