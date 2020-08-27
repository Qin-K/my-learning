package com.example.model;

import java.math.BigDecimal;

public class FundsRecord {
    private Long fundsRecordId;

    private String companyId;

    private String year;

    private BigDecimal operatingIncome;

    private BigDecimal profit;

    private Boolean rDProportion;

    public FundsRecord(Long fundsRecordId, String companyId, String year, BigDecimal operatingIncome, BigDecimal profit, Boolean rDProportion) {
        this.fundsRecordId = fundsRecordId;
        this.companyId = companyId;
        this.year = year;
        this.operatingIncome = operatingIncome;
        this.profit = profit;
        this.rDProportion = rDProportion;
    }

    public FundsRecord() {
        super();
    }

    public Long getFundsRecordId() {
        return fundsRecordId;
    }

    public void setFundsRecordId(Long fundsRecordId) {
        this.fundsRecordId = fundsRecordId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public BigDecimal getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(BigDecimal operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Boolean getrDProportion() {
        return rDProportion;
    }

    public void setrDProportion(Boolean rDProportion) {
        this.rDProportion = rDProportion;
    }
}