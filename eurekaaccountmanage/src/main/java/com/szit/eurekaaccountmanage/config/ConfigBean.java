package com.szit.eurekaaccountmanage.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 刘鑫垚
 */
@Configuration
public class ConfigBean {

    @Bean
    // @LoadBalanced注解让RestTemplate具有负载均衡功能，通过调用Ribbon访问Provider集群
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
