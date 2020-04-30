package com.szit.eurekaaccountmanage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class EurekaaccountmanageApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedis(){
        String loginUser = stringRedisTemplate.opsForValue().get("loginUser");
        System.out.println(loginUser);
    }
}
