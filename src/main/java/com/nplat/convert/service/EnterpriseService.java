package com.nplat.convert.service;

import com.nplat.convert.dao.EnterpriseInfoMapper;
import com.nplat.convert.dao.EnterpriseTypeMapper;
import com.nplat.convert.dao.PersonInfoMapper;
import com.nplat.convert.entity.EnterpriseInfo;
import com.nplat.convert.entity.EnterpriseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private EnterpriseTypeMapper enterpriseTypeMapper;

    //商户类型操作
    public void createEnterpriseType(String name) {
        enterpriseTypeMapper.createInfo(name);
    }
    //查询商户类型
    public List<EnterpriseType> getEnterpriseType() {
        return enterpriseTypeMapper.getEnterpriseType();
    }


    //申请成为商户
    public Long createInfoForEnterpriseInfo(String referenceId,
                                               String personId,
                                               Integer sType,
                                               String sName,
                                               String sPhone,
                                               String sImage,
                                               String openTime,
                                               String wxNumber,
                                               String sDescription,
                                               String sAddress,
                                               BigDecimal latitude,
                                               BigDecimal longitude) {
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        enterpriseInfo.setPersonId(personId);
        enterpriseInfo.setReferenceId(referenceId);
        enterpriseInfo.setsType(sType);
        enterpriseInfo.setsName(sName);
        enterpriseInfo.setsPhone(sPhone);
        enterpriseInfo.setsImage(sImage);
        enterpriseInfo.setOpenTime(openTime);
        enterpriseInfo.setWxNumber(wxNumber);
        enterpriseInfo.setsAddress(sAddress);
        enterpriseInfo.setsDescription(sDescription);
        enterpriseInfo.setLatitude(latitude);
        enterpriseInfo.setLongitude(longitude);
        enterpriseInfo.setStatus(0);
        enterpriseInfoMapper.createInfo(enterpriseInfo);
        return enterpriseInfo.getId();
    }

    public HashMap selectAskEnterprises(String personId) {
        return enterpriseInfoMapper.selectAskEnterprises(personId);
    }

    //同意
    @Transactional
    public void agreeAskEnterprise(Long id) {
        EnterpriseInfo enterpriseInfo = getEnterpriseInfoById(id);
        if(enterpriseInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", id);
            hashMap.put("status", 1);
            enterpriseInfoMapper.updateInfoById(hashMap);

            HashMap info = new HashMap();
            info.put("personId", enterpriseInfo.getPersonId());
            info.put("uLevel", 3);  //认证之后设置等级
            personInfoMapper.updateInfoBy(info);
        }
    }

    //修改商户信息
    public void updateEnterpriseInfo(Long id,
                                     Integer sType,
                                     String sName,
                                     String sPhone,
                                     String sImage,
                                     String openTime,
                                     String wxNumber,
                                     String sDescription,
                                     String sAddress,
                                     BigDecimal latitude,
                                     BigDecimal longitude) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        hashMap.put("sType", sType);
        hashMap.put("sName", sName);
        hashMap.put("sPhone", sPhone);
        hashMap.put("sImage", sImage);
        hashMap.put("openTime", openTime);
        hashMap.put("wxNumber", wxNumber);
        hashMap.put("sDescription", sDescription);
        hashMap.put("sAddress", sAddress);
        hashMap.put("latitude", latitude);
        hashMap.put("longitude", longitude);
        enterpriseInfoMapper.updateInfoById(hashMap);
    }

    //查询附近商户
    public List<EnterpriseInfo> getEnterpriseInfos(Double lat, Double lon, Integer page, Integer size) {
        Integer offset = page * size;
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", lat);
        hashMap.put("longitude", lon);
        hashMap.put("offset", offset);
        hashMap.put("size", size);
        List<EnterpriseInfo> list = null;
        System.out.println("lat=" + lat + "    lon=" + lon + "    page=" + page + "  ==  size=" + size + "    total=" + list.size());
        return list;
    }

    //查询商户详情
    public EnterpriseInfo getEnterpriseInfoByPersonId(String personId) {
        HashMap hashMap = new HashMap();
        hashMap.put("personId", personId);
        return enterpriseInfoMapper.getEnterpriseInfoBy(hashMap);
    }

    //查询商户详情
    public EnterpriseInfo getEnterpriseInfoById(Long id) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return enterpriseInfoMapper.getEnterpriseInfoBy(hashMap);
    }

    public List<HashMap> searchNearEnterprise(Integer currentPosition, Integer size, Double latitude, Double longitude) {
        HashMap hashMap = new HashMap();
        hashMap.put("currentPosition", currentPosition);
        hashMap.put("size", size);
        hashMap.put("latitude", latitude);
        hashMap.put("longitude", longitude);
        return enterpriseInfoMapper.searchEnterpriseInfoPageSize(hashMap);
    }

}
