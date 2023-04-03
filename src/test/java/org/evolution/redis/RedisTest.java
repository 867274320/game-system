package org.evolution.redis;

import org.evolution.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends BaseTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void connectionTest() {
        String key1 = redisTemplate.opsForValue().get("key1");
        System.out.println(key1);
    }
}
