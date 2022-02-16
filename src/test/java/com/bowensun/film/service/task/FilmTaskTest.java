package com.bowensun.film.service.task;


import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.bowensun.film.domain.avatar.Generator;
import com.bowensun.film.domain.entity.FilmEntity;
import com.bowensun.film.repository.FilmMapper;
import com.bowensun.film.service.FilmService;
import com.bowensun.film.service.component.QnySdkComponent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 爬取豆瓣数据到本地
 *
 * @author 郑建雄
 * @date 2022/2/14
 */
@SpringBootTest
@ActiveProfiles("druid")
@Slf4j
class FilmTaskTest {

    @Resource
    private FilmService filmService;

    @Resource
    private QnySdkComponent qnySdkComponent;

    @Test
    void test() throws IOException {
        Generator generator = new Generator("bwensun");
        final BufferedImage bufferedImage = generator.nextAvatar();
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", outputStream);
        qnySdkComponent.upload("image-film", "avatar-test.png", outputStream.toByteArray());
    }


    @Test
    void pictureSync(){
        filmService.lambdaQuery()
                .list()
                .forEach(x -> {
                    final String cover = x.getCover();
                    final String replace = cover.replace("http://image.bowensun.top", "https://picture.bowensun.top");
                    filmService.lambdaUpdate()
                            .set(FilmEntity::getCover, replace)
                            .eq(FilmEntity::getId, x.getId())
                            .update();
                });
    }

    /**
     * 电影
     */
    @SneakyThrows
    @Test
    void FilmSync(){
        String url = "https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%BB%8F%E5%85%B8&sort=recommend&page_limit=50&page_start=0";
        Map<String, String> map = new HashMap<>();
        //设置请求参数
        map.put("type", "movie");
        map.put("tag", "%E7%BB%8F%E5%85%B8");
        map.put("sort", "recommend");
        map.put("page_limit", "5");
        //i为一个变量，从多少条数据开始查询
        map.put("page_start", "0");

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0");
        headers.add("Cookie", "bid=QNoG_zn4mZY; _pk_id.100001.4cf6=6209709719896af7.1575619506.2.1575940374.1575621362.; __utma=30149280.1889677372.1575619507.1575619507.1575940335.2; __utmz=30149280.1575619507.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utma=223695111.986359939.1575619507.1575619507.1575940335.2; __utmz=223695111.1575619507.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __yadk_uid=QVSP2uvzzDBrpnvHKzZpZEWJnuARZ4aL; ll=\"118259\"; _vwo_uuid_v2=D1FC45CAE50CF6EE38D245C68D7CECC4F|e8d1db73f4c914f0b0be7ed85ac50d14; trc_cookie_storage=taboola%2520global%253Auser-id%3D690a21c0-9ad9-4f8d-b997-f0decb3cfc9b-tuct4e39874; _pk_ses.100001.4cf6=*; ap_v=0,6.0; __utmb=30149280.0.10.1575940335; __utmc=30149280; __utmb=223695111.0.10.1575940335; __utmc=223695111; __gads=ID=2f06cb0af40206d0:T=1575940336:S=ALNI_Ma4rv9YmqrkIUNXsIt5E7zT6kZy2w");
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(null,headers);
        final HttpResponse response = HttpUtil.createGet(url)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9", true)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.82 Safari/537.36", true)
                .header("Cookie", "bid=dDiiAJdajgE; ll=\"108169\"; douban-fav-remind=1; _vwo_uuid_v2=DF4CD1434A54930248D50DEA20D8B42BE|4645a5b6afbad147b7848dbdfddd8ace; _ga=GA1.2.1069370324.1624859986; gr_user_id=b7ce165b-a9fd-48ec-bc5a-6c36ad1e369a; __utmz=30149280.1643628188.12.10.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmz=223695111.1643628201.7.7.utmcsr=douban.com|utmccn=(referral)|utmcmd=referral|utmcct=/search; _pk_ref.100001.4cf6=%5B%22%22%2C%22%22%2C1644804450%2C%22https%3A%2F%2Fwww.douban.com%2Fsearch%3Fq%3D%25E5%2596%259C%25E5%2589%25A7%22%5D; __utma=30149280.1069370324.1624859986.1643628188.1644804450.13; __utmc=30149280; __utma=223695111.22494246.1624859986.1643628201.1644804450.8; __utmc=223695111; ap_v=0,6.0; _pk_id.100001.4cf6=b1f2b5655080e534.1624859986.8.1644805316.1643628214.", true)
                .execute();
        final String body = response.body();
        final Film film = new ObjectMapper().readValue(body, new TypeReference<Film>() {
        });
        final List<Film.Subject> subjects = film.getSubjects();
        for (Film.Subject subject : subjects) {
            final FilmEntity filmPo = new FilmEntity();
            filmPo.setFilmName(subject.getTitle());
            filmPo.setCover(subject.getCover());
            final String detailUrl = subject.getUrl();

            URL request = new URL(detailUrl);
            HttpURLConnection connection = (HttpURLConnection) request.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
            connection.setConnectTimeout(80000);
            //设置从主机读取数据超时（单位：毫秒）
            connection.setReadTimeout(80000);
            Document parse = Jsoup.parse(connection.getInputStream(), "UTF-8", detailUrl);
            String filmName = parse.getElementsByTag("span").get(4).text();

            String info = parse.getElementById("info").text();
            filmPo.setFilmType(StringUtils.substring(info, StringUtils.indexOf(info,"类型") + 3, StringUtils.indexOf(info,"制片国家")));
            filmPo.setScreenLocation(StringUtils.substring(info,StringUtils.indexOf(info,"制片国家") + 8, StringUtils.indexOf(info,"语言")));
            filmPo.setScreenDate(StringUtils.substring(info,StringUtils.indexOf(info,"上映日期") + 6, StringUtils.indexOf(info,"上映日期") + 16));
            filmPo.setFilmName(filmName);
            filmPo.setMainActor(StringUtils.substring(info,StringUtils.indexOf(info,"主演") + 3, StringUtils.indexOf(info,"类型")));
            filmPo.setDirector(StringUtils.substring(info, StringUtils.indexOf(info,"导演") + 3, StringUtils.indexOf(info,"编剧")));
            filmPo.setScreenwriter(StringUtils.substring(info, StringUtils.indexOf(info,"编剧") + 3, StringUtils.indexOf(info,"主演")));
            filmPo.setIntroduction("");
            System.out.println(filmPo);
            filmService.save(filmPo);
            Thread.sleep(3000);
        }
    }

    @Data
    static class Film {

        private List<Subject> subjects;

        @Data
        static class Subject{

            private String episodes_info;

            private String rate;

            private Integer cover_x;

            private String title;

            private String url;

            private String playable;

            private String id;

            private String cover_y;

            private String cover;

            private Boolean is_new;
        }
    }
}