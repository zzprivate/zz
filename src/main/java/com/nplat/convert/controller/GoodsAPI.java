package com.nplat.convert.controller;

import com.nplat.convert.basePackage.request.GoodsRequest;
import com.nplat.convert.basePackage.response.GoodsResponse;
import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.service.GoodsService;
import com.nplat.convert.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsAPI {

    @Autowired
    private GoodsService goodsService;

    @PostMapping(path = "/good/info")
    @ResponseBody
    public BaseResponse uploadFile(@RequestBody GoodsRequest request) {
        BaseResponse response = new BaseResponse();
        try {
           Long goodId =  goodsService.createGoods(request.getPersonId(),
                   request.getbName(),
                   request.getbDesc(),
                   request.getbRealPrise(),
                   request.getbPrice(),
                   request.getLatitude(),
                   request.getLongitude(),
                   request.getGoodImages());
            response.setData(goodId);
            return response;
        }catch (Exception e) {
            e.printStackTrace();
            return response;
        }
    }


    @GetMapping(path = "/user/good/info/{personId}")
    @ResponseBody
    public BaseResponse userGoodInfo(@PathVariable String personId) {
        BaseResponse response = new BaseResponse();
        try {
            List<GoodsResponse> goodsResponseList =  goodsService.searchByPersonId(personId);
            response.setData(goodsResponseList);
            return response;
        }catch (Exception e) {
            LogUtils.ERROR_LOG.error("=", e);
            e.printStackTrace();
            return response;
        }
    }



}
