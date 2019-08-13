package com.nplat.convert.service;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;


/**
 * Created by roy on 2019/6/20.
 */
@Service
public class QiNiuService {

    @Value("${qiNiu.accessKey}")
    private String accessKey;
    @Value("${qiNiu.accessKeySecret}")
    private String accessKeySecret;
    @Value("${qiNiu.bucketName}")
    private String bucketName;
    @Value("${qiNiu.url}")
    private String URL;

    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone0());
    //...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);

    //生成上传授权uptoken

    public String Uptoken() {
        try {
            Auth auth = Auth.create(accessKey, accessKeySecret);
            String upToken = auth.uploadToken(bucketName);
            System.out.println(upToken);
            return upToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //上传代码
    public String uploadFile(InputStream reader) throws Exception {
        Auth auth = Auth.create(accessKey, accessKeySecret);
        String upToken = auth.uploadToken(bucketName);
        Response response = uploadManager.put(reader, UUID.randomUUID().toString(), upToken, null, null);
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        return URL + putRet.key;
    }


}
