package com.szit.eurekaaccountmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.szit.eurekaaccountmanage.mapper")
public class EurekaaccountmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaaccountmanageApplication.class, args);
        System.out.println("账户管理服务器已启动!");
    }

}
