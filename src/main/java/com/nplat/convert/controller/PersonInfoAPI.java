package com.nplat.convert.controller;


import com.alibaba.fastjson.JSONObject;
import com.nplat.convert.basePackage.request.LoginRequest;
import com.nplat.convert.basePackage.request.PersonInfoRequest;
import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.entity.PersonInfo;
import com.nplat.convert.service.PersonInfoService;
import com.nplat.convert.service.WxGetParamService;
import com.nplat.convert.utils.HttpUtils;
import com.nplat.convert.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by roy on 2019/2/14.
 */
@Controller
public class PersonInfoAPI {

    @Autowired
    private PersonInfoService infoService;
    @Value("${weChat.appId}")
    private String appId;
    @Value("${weChat.secret}")
    private String secret;


    //用户注册登陆
    @PostMapping(path = "/user/code2Session")
    @ResponseBody
    public BaseResponse RegisterAndGetOpenId(@RequestBody LoginRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            HashMap hashMap = new HashMap();
            Long id = null;
            String res = HttpUtils.doGet(WxGetParamService.code2Session(appId, secret, request.getCode()));
            JSONObject jsonObject = JSONObject.parseObject(res);
            int errCode = jsonObject.getIntValue("errcode");
            String openId = jsonObject.getString("openid");
            String session_key = jsonObject.getString("session_key");
            if (openId != null) {
                id = infoService.createPersonInfo(openId);
            } else if (errCode == 40029) {
                id = infoService.createPersonInfo("openId");
            }
            LogUtils.API_ACCESS_LOG.info(res);
            hashMap.put("id",id);
            hashMap.put("personId",openId);
            response.setData(hashMap);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }




    @GetMapping(path = "/get/user/person/{id}")
    @ResponseBody
    public BaseResponse getPersonInfo(@PathVariable Integer id) {
        BaseResponse response = new BaseResponse();
        try {
            PersonInfo personInfo = infoService.getInfoById(id);
            response.setData(personInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    @PostMapping(path = "/update/user/person")
    @ResponseBody
    public BaseResponse updatePersonInfo(@RequestBody  PersonInfoRequest request) {
        BaseResponse response = new BaseResponse();
        infoService.updatePersonInfo(request.getId(),request.getNickName(),request.getAvatarUrl(),request.getGender(),
                request.getCountry(),request.getProvince(),request.getCity(),request.getPersonalQrCode(),request.getFans(),request.getuPhoneNumber());
        return response;
    }


}
