package com.bowensun.film.service.task;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bowensun.film.common.properties.CustomProperties;
import com.bowensun.film.domain.entity.FilmEntity;
import com.bowensun.film.service.FilmService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 电影定时任务
 *
 * @author 郑建雄
 * @date 2022/2/15
 */
@Component
@Slf4j
@EnableConfigurationProperties(value = CustomProperties.class)
public class FilmTask {

    @Resource
    private FilmService filmService;

    @Resource
    private CustomProperties customProperties;


    void replaceFilmCover() {
        log.info("【电影封面替换】");
        filmService.lambdaQuery()
                .page(new Page<>(0, 2000))
                .getRecords()
                .forEach(x -> {
                    final String cover = x.getCover();
                    if (cover.contains("doubanio.com")) {
                        //下载图片到本地、
                        downloadCover(x);
                        //上传图片到七牛云
                        final String filmCover = uploadQiniuyun(x);
                        x.setCover(filmCover);
                        //刷新本地的URL
                        filmService.lambdaUpdate()
                                .set(FilmEntity::getCover, x.getCover())
                                .eq(FilmEntity::getId, x.getId())
                                .update();
                    }

                });
    }

    private String uploadQiniuyun(FilmEntity film) {
        String accessKey = customProperties.getQiniuyun().getAccessKey();
        String secretKey = customProperties.getQiniuyun().getAccessKey();
        String bucket = "image-film";
        String localFilePath = "E:\\我的图片\\film_cover\\" + film.getId() + ".webp";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        log.info(upToken);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "c" + film.getId() + ".webp";

        //构造一个带指定 Region 对象的配置类  region0 标识华东
        Configuration cfg = new Configuration(Region.region0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        String filmCover = "http://image.bowensun.top/";
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new ObjectMapper().readValue(response.bodyString(), DefaultPutRet.class);
            log.info(putRet.key);
            log.info(putRet.hash);
            filmCover = filmCover + key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            log.info(r.toString());
            try {
                log.info(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return filmCover;
    }

    @SneakyThrows
    private void downloadCover(FilmEntity film) {
        final String cover = film.getCover();
        final URL url = new URL(cover);
        final URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        final InputStream inputStream = urlConnection.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        OutputStream os = new FileOutputStream("E:\\我的图片\\film_cover\\" + film.getId() + ".webp");
        // 开始读取
        while ((len = inputStream.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        inputStream.close();

        log.info("download complete!");
    }
}
