package org.evolution.jedis;

import org.evolution.BaseTest;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest extends BaseTest {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("192.168.124.100",6379);
        
    }

    @Test
    public void jedisTest() {
        String ping = jedis.ping();
        System.out.println(ping);
    }

    @Test
    public void jedis() {

    }
}
