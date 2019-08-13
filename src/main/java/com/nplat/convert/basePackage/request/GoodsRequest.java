package com.nplat.convert.basePackage.request;

import java.math.BigDecimal;
import java.util.List;

public class GoodsRequest {

    private String personId;

    private String bName;

    private String bDesc;

    private BigDecimal bRealPrise;

    private BigDecimal bPrice;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private List<String>  goodImages;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbDesc() {
        return bDesc;
    }

    public void setbDesc(String bDesc) {
        this.bDesc = bDesc;
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

    public List<String> getGoodImages() {
        return goodImages;
    }

    public void setGoodImages(List<String> goodImages) {
        this.goodImages = goodImages;
    }
}
