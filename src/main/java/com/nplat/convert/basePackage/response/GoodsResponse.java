package com.nplat.convert.basePackage.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public class GoodsResponse {
    private Long id;

    private String personId;

    private String bName;

    private String bDesc;

    private BigDecimal bRealPrise;

    private BigDecimal bPrice;

    private String createDate;

    private List<HashMap> images;

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<HashMap> getImages() {
        return images;
    }

    public void setImages(List<HashMap> images) {
        this.images = images;
    }
}
