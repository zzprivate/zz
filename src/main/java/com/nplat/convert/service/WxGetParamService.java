package com.nplat.convert.service;

/**
 * Created by roy on 2019/5/19.
 */
public class WxGetParamService {

    //登录凭证校验。通过 wx.login() 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
    public static String code2Session(String appId, String secret, String js_code) {
        StringBuilder builder = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?appid=");
        builder.append(appId);
        builder.append("&secret=");
        builder.append(secret);
        builder.append("&js_code=");
        builder.append(js_code);
        builder.append("&grant_type=authorization_code");
        return builder.toString();
    }

    //用户支付完成后，获取该用户的 UnionId，无需用户授权。本接口支持第三方平台代理查询。
    //注意：调用前需要用户完成支付，且在支付后的五分钟内有效。
    public static String getPaidUnionId(String accessToken, String openId,String transactionId,String  mchId,String outTradeNo) {
        StringBuilder builder = new StringBuilder("https://api.weixin.qq.com/wxa/getpaidunionid?access_token=");
        builder.append(accessToken);
        builder.append("&openid=");
        builder.append(openId);
        if(transactionId != null && !"".equals(transactionId)) {
            builder.append("&transaction_id=");
            builder.append(transactionId);
        }
        if(mchId != null && !"".equals(mchId)) {
            builder.append("&mch_id=");
            builder.append(mchId);
        }
        if(outTradeNo != null && !"".equals(outTradeNo)) {
            builder.append("&out_trade_no=");
            builder.append(outTradeNo);
        }
        return builder.toString();
    }

    //获取小程序全局唯一后台接口调用凭据（access_token）。调调用绝大多数后台接口时都需使用 access_token，开发者需要进行妥善保存。
    public static String getAccessToken(String appId,String secret){
        StringBuilder builder = new StringBuilder("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=");
        builder.append(appId);
        builder.append("&secret=");
        builder.append(secret);
        return builder.toString();
    }

    public static String send(String accessToken) {
        StringBuilder builder = new StringBuilder("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=");
        builder.append(accessToken);
        return builder.toString();
    }



}
