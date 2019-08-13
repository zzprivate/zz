package com.nplat.convert.controller;

import com.nplat.convert.config.ApiMsgEnum;
import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.service.HomeService;
import com.nplat.convert.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageAPI {
    @Autowired
    private HomeService homeService;

    //轮播图
    @GetMapping(path = "/banners/banner")
    @ResponseBody
    public BaseResponse banner() {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(homeService.banners());
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("轮播图=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
    }

    //测试
    @GetMapping(path = "/test")
    @ResponseBody
    public BaseResponse test() {
        BaseResponse response = new BaseResponse();
        response.setData("hello");
        return response;
    }

}
