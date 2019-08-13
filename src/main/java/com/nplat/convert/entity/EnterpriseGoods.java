package com.nplat.convert.entity;

import java.math.BigDecimal;
import java.util.Date;

public class EnterpriseGoods {
    private Long id;

    private String personId;

    private String bName;

    private String bDesc;

    private BigDecimal bRealPrise;

    private BigDecimal bPrice;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Integer status;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbDesc() {
        return bDesc;
    }

    public void setbDesc(String bDesc) {
        this.bDesc = bDesc == null ? null : bDesc.trim();
    }

    public BigDecimal getbRealPrise() {
        return bRealPrise;
    }

    public void setbRealPrise(BigDecimal bRealPrise) {
        this.bRealPrise = bRealPrise;
    }

    public BigDecimal getbPrice() {
        return bPrice;
    }

    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}