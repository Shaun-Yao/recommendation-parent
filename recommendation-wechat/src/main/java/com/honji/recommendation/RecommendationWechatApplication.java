package com.honji.recommendation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.honji.recommendation.mapper")
public class RecommendationWechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendationWechatApplication.class, args);
    }
}
