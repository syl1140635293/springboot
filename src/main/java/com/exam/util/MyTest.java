package com.exam.util;

import com.exam.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//配置mock
@AutoConfigureMockMvc
public class MyTest {

    @Autowired
    RedisService redisService;

    @Test
    public void setRedis(){
        for (int i = 0; i < 20000; i++) {
            String key = "spring-"+i;
            redisService.save(key,i+"");
        }
    }
}
