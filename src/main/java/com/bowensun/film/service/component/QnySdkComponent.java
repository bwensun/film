package com.bowensun.film.service.component;

import com.alibaba.fastjson.JSON;
import com.bowensun.film.common.properties.CustomProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 七牛云SDK封装
 *
 * @author 郑建雄
 * @date 2022/2/15
 */
@Component
@Slf4j
public class QnySdkComponent {

    private static final String IMAGE_PREFIX = "http://image.bowensun.top/";

    @Resource
    private CustomProperties customProperties;

    public String upload(String bucket, String key, String path) {
        String accessKey = customProperties.getQiniuyun().getAccessKey();
        String secretKey = customProperties.getQiniuyun().getAccessKey();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        log.info(upToken);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //构造一个带指定 Region 对象的配置类  region0 标识华东
        Configuration cfg = new Configuration(Region.region0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Response response = uploadManager.put(path, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new ObjectMapper().readValue(response.bodyString(), DefaultPutRet.class);
            log.info(JSON.toJSONString(putRet));
        } catch (Exception e) {
            log.error("【七牛云】解析失败");
        }
        return IMAGE_PREFIX + key;
    }
}
