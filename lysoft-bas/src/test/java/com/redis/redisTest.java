package com.redis;

import com.lysoftbas.LysoftBasApplication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * lysoft
 * Creat by zmy on 2021-05-07 15:28
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {LysoftBasApplication.class})
public class redisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    public void contextLoad(){
        stringRedisTemplate.opsForValue().set("name","zhangsan");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

}
