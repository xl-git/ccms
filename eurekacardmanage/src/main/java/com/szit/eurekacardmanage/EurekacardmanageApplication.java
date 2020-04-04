package com.szit.eurekacardmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.szit.eurekacardmanager.mapper")
public class EurekacardmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekacardmanageApplication.class, args);
        System.out.println("卡片服务器已启动!");
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
