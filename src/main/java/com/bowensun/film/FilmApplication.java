package com.bowensun.film;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author 郑建雄
 */
@SpringBootApplication
@ServletComponentScan
@EnableCaching
@MapperScan("com.bowensun.film.repository")
public class FilmApplication{
    public static void main(String[] args) {
        SpringApplication.run(FilmApplication.class, args);
    }
}
