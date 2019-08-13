package com.nplat.convert.service;

import com.nplat.convert.dao.PersonInfoMapper;
import com.nplat.convert.entity.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class PersonInfoService {
    @Autowired
    private PersonInfoMapper personInfoMapper;

    public Long createPersonInfo(String openId) {
        PersonInfo info = getInfoByOpenId(openId);
        if(info == null) {
            info = new PersonInfo();
            info.setOpenId(openId);
            info.setuLevel(0);
            info.setMyFans(0);
            personInfoMapper.createInfo(info);
            return info.getId();
        } else {
            return info.getId();
        }
    }

    public void updatePersonInfo(Long id,
                                 String nickName,
                                 String avataUrl,
                                 Integer gender,
                                 String country,
                                 String province,
                                 String city,
                                 String personalQrCode,
                                 Integer fans,
                                 String uPhoneNumber) {
        HashMap hashMap = new HashMap();
        hashMap.put("id",id);
        hashMap.put("nickName",nickName);
        hashMap.put("avataUrl",avataUrl);
        hashMap.put("gender",gender);
        hashMap.put("country",country);
        hashMap.put("province",province);
        hashMap.put("city",city);
        hashMap.put("personalQrCode",personalQrCode);
        hashMap.put("myFans",fans);
        hashMap.put("uPhoneNumber",uPhoneNumber);
        personInfoMapper.updateInfoBy(hashMap);
    }

    public PersonInfo getInfoById(Integer id) {
        HashMap hashMap = new HashMap();
        hashMap.put("id",id);
        return personInfoMapper.getPersonInfoBy(hashMap);
    }
    public PersonInfo getInfoByOpenId(String openId) {
        HashMap hashMap = new HashMap();
        hashMap.put("personId",openId);
        return personInfoMapper.getPersonInfoBy(hashMap);
    }




}
