package com.nplat.convert.controller;

import com.nplat.convert.basePackage.request.AgreeEnterpriseRequest;
import com.nplat.convert.basePackage.request.AskForEnterpriseRequest;
import com.nplat.convert.basePackage.request.EnterpriseInfoRequest;
import com.nplat.convert.basePackage.request.EnterpriseTypeRequest;
import com.nplat.convert.basePackage.request.NearEnperpriseRequest;
import com.nplat.convert.config.ApiMsgEnum;
import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.service.EnterpriseService;
import com.nplat.convert.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class EnterpriseAPI {
    @Autowired
    private EnterpriseService enterpriseService;

    //商户类型操作
    @PostMapping(path = "/enterprise/type")
    @ResponseBody
    public BaseResponse enterpriseType(@RequestBody EnterpriseTypeRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            enterpriseService.createEnterpriseType(request.getName());
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("商户类型操作=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
    }

    //查询商户类型
    @GetMapping(path = "/enterprise/type")
    @ResponseBody
    public BaseResponse getEnterpriseType() {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(enterpriseService.getEnterpriseType());
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("查询商户类型=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
    }

    //申请成为商户
    @PostMapping(path = "/enterprise/info")
    @ResponseBody
    public BaseResponse AskEnterpriseInfo(@RequestBody EnterpriseInfoRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            Long id = enterpriseService.createInfoForEnterpriseInfo(request.getReferenceId(), request.getPersonId(), request.getsType(), request.getsName(), request.getsPhone(), request.getImageFile(), request.getOpenTime(), request.getWxNumber(), request.getsDescription(), request.getsAddress(), request.getLatitude(), request.getLongitude());
            response.setData(id);
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("申请成为商户=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }

    }

    //查看申请商户列表
    @GetMapping(path = "/ask/enterprise/infos/{personId}")
    @ResponseBody
    public BaseResponse getAskEnterpriseInfo(@PathVariable("personId") String personId) {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(enterpriseService.selectAskEnterprises(personId));
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("查看申请商户列表=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }

    }

    //同意商户申请
    @PostMapping(path = "/enterprise/agree")
    @ResponseBody
    public BaseResponse agreeEnterprise(@RequestBody AgreeEnterpriseRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            enterpriseService.agreeAskEnterprise(request.getId());
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("同意商户申请=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
    }

    //查看商户信息
    @GetMapping(path = "/enterprise/info/{id}")
    @ResponseBody
    public BaseResponse getEnterpriseInfo(@PathVariable("id") Long id) {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(enterpriseService.getEnterpriseInfoById(id));
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("查看商户信息=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }

    }


    //修改商户信息
    @PostMapping(path = "/enterprise/update_info")
    @ResponseBody
    public BaseResponse updateEnterprise(@RequestBody EnterpriseInfoRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            enterpriseService.updateEnterpriseInfo(
                    request.getId(), request.getsType(), request.getsName(), request.getsPhone(), request.getImageFile(), request.getOpenTime(),
                    request.getWxNumber(), request.getsDescription(), request.getsAddress(), request.getLatitude(), request.getLongitude());
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("修改商户信息=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }

    }


    //查询附近商户
    @PostMapping(path = "/enterprise/infos")
    @ResponseBody
    public BaseResponse nearEnterprise(@RequestBody NearEnperpriseRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            HashMap hashMap = new HashMap();
            Integer currentPosition = request.getCurrentPosition();
            List<HashMap> nearEnterpriseList = enterpriseService.searchNearEnterprise(request.getCurrentPosition(), request.getSize(), request.getLatitude(), request.getLongitude());
            currentPosition = currentPosition + nearEnterpriseList.size();
            hashMap.put("currentPosition",currentPosition);
            hashMap.put("nearList",nearEnterpriseList);
            response.setData(hashMap);
            return response;
        } catch (Exception e) {
            LogUtils.ERROR_LOG.error("查询附近商户=", e);
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
    }
}
