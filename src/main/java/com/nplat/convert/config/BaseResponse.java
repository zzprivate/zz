package com.nplat.convert.config;

import java.io.Serializable;

/**
 * Created by roy on 2019/2/18.
 */
public class BaseResponse{
    protected int resCode;
    protected String resDes;
    protected Object data;

    public int getResCode() {
        return this.resCode;
    }

    public String getResDes() {
        return resDes;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseResponse() {
        this.resCode = ApiMsgEnum.OK.getResCode();
        this.resDes = ApiMsgEnum.OK.getResDes();
    }



    public BaseResponse(Object data) {
        this.resCode = ApiMsgEnum.OK.getResCode();
        this.resDes = ApiMsgEnum.OK.getResDes();
        this.data = data;
    }

    public void setMsgEnum(ApiMsgEnum msgEnum) {
        this.resCode = msgEnum.getResCode();
        this.resDes = msgEnum.getResDes();
        this.data = "";
    }
}

