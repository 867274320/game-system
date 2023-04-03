package org.evolution.redis;

import org.evolution.BaseTest;
import org.evolution.modules.user.entities.User;
import org.evolution.modules.user.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StringTest extends BaseTest {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void setKey() {
        List<User> users = userMapper.selectList(null);
        for (User user:users) {
            redisTemplate.opsForValue().set("user:" + user.getRowId(),user);
        }
    }

    @Test
    public void getKey() {
        List<User> users = userMapper.selectList(null);
        for (User user:users) {
            User s = (User) redisTemplate.opsForValue().get("user:" + user.getRowId());
            System.out.println(s.getRowId());
        }
    }

    @Test
    public void delKey() {
        List<User> users = userMapper.selectList(null);
        for (User user:users) {
            redisTemplate.delete("user:" + user.getRowId());
        }
    }

    @Test
    public void setIfPresent() {
        redisTemplate.opsForValue().setIfPresent("key2","value2",5, TimeUnit.SECONDS);
    }


}
