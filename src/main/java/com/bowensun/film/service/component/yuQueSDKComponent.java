package com.bowensun.film.service.component;

import cn.hutool.http.HttpRequest;
import org.springframework.stereotype.Component;


/**
 * 语雀SDK服务
 *
 * @author 郑建雄
 * @date 2021/7/16
 */
@Component
public class yuQueSDKComponent {


    public void getUserInfo(){
        String api = "https://www.yuque.com/api/v2";
        String accessToken = "ILNqlPTbSnvaaBLfvq12bwSFicQB3MbsJJLdYBZi";
        String url = api.concat("/user");
        String body = HttpRequest.get(url).header("X-Auth-Token", accessToken).execute().body();
        System.out.println(body);
    }


}
