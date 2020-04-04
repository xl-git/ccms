package com.szit.eurekamanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.szit.eurekamanager.mapper")
public class EurekamanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekamanagerApplication.class, args);
        System.out.println("管理员服务器已启动!");
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
