package com.szit.eurekarepaymentmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.szit.eurekarepaymentmanager.mapper")
public class EurekarepaymentmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekarepaymentmanageApplication.class, args);
        System.out.println("还款服务器已启动!");
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
