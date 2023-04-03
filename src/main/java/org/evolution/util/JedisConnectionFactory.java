package org.evolution.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {


    private static final JedisPool JEDIS_POOL;


    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);
        config.setMaxIdle(8);
        config.setMinIdle(0);
        JEDIS_POOL = new JedisPool(config,"192.168.124.100",6379);
    }

    public static Jedis getJedis () {
        return JEDIS_POOL.getResource();
    }


    /*测试jedis连接*/
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        System.out.println(jedis.ping());
    }

}
