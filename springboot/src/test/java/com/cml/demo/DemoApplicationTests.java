package com.cml.demo;

import com.cml.demo.dao.Mapper;
import com.cml.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
  @Autowired(required = false)
  private Mapper mapper;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();
        String  s= stringStringListOperations.leftPop("k2");
        System.out.println(s);

    }


}
