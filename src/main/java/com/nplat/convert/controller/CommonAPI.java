package com.nplat.convert.controller;


import com.nplat.convert.config.ApiMsgEnum;
import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.entity.PlatformSvg;
import com.nplat.convert.service.PlatformSvgService;
import com.nplat.convert.service.QiNiuService;
import com.nplat.convert.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommonAPI {

    @Autowired
    private QiNiuService qiNiuService;
    @Autowired
    private PlatformSvgService platformSvgService;

    @PostMapping(path = "/update/file")
    @ResponseBody
    public BaseResponse uploadFile(@RequestParam(value = "img", required = false) MultipartFile file ) {
        BaseResponse response = new BaseResponse();
        try {
           String res  = qiNiuService.uploadFile(file.getInputStream());
            response.setData(res);
            return response;
        }catch (Exception e) {
            LogUtils.ERROR_LOG.error("上传文件出错=",e);
            e.printStackTrace();
            return response;
        }
    }

    //请求失败后的拦截返回
    @GetMapping(path = "/error/01")
    @ResponseBody
    public BaseResponse error01() {
        BaseResponse response = new BaseResponse();
        response.setMsgEnum(ApiMsgEnum.FORBIDDEN);
        return response;
    }

    //查询所有用户数
    @GetMapping(path = "/user/counts")
    @ResponseBody
    public BaseResponse allUsersCount() {
        BaseResponse response = new BaseResponse();
        PlatformSvg platformSvg = platformSvgService.selectPlatformSvg(1);
        response.setData(platformSvg);
        return response;
    }

    //查询所有商户数
    @GetMapping(path = "/enterprise/count")
    @ResponseBody
    public BaseResponse allEnterpriseCount() {
        BaseResponse response = new BaseResponse();
        PlatformSvg platformSvg =  platformSvgService.selectPlatformSvg(2);
        response.setData(platformSvg);
        return response;
    }
}
