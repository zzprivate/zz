package com.nplat.convert.entity;

import java.util.Date;

public class PersonInfo {
    private Long id;

    private String personId;

    private Integer uLevel;

    private String nickName;

    private String avataUrl;

    private Integer gender;

    private String country;

    private String province;

    private String city;

    private String personalQrCode;

    private Integer myFans;

    private String uPhoneNumber;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return personId;
    }

    public void setOpenId(String openId) {
        this.personId = openId == null ? null : openId.trim();
    }

    public Integer getuLevel() {
        return uLevel;
    }

    public void setuLevel(Integer uLevel) {
        this.uLevel = uLevel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvataUrl() {
        return avataUrl;
    }

    public void setAvataUrl(String avataUrl) {
        this.avataUrl = avataUrl == null ? null : avataUrl.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
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

    public String getPersonalQrCode() {
        return personalQrCode;
    }

    public void setPersonalQrCode(String personalQrCode) {
        this.personalQrCode = personalQrCode == null ? null : personalQrCode.trim();
    }

    public Integer getMyFans() {
        return myFans;
    }

    public void setMyFans(Integer myFans) {
        this.myFans = myFans;
    }

    public String getuPhoneNumber() {
        return uPhoneNumber;
    }

    public void setuPhoneNumber(String uPhoneNumber) {
        this.uPhoneNumber = uPhoneNumber == null ? null : uPhoneNumber.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}