package com.hhp.redis;

import redis.clients.jedis.Jedis;

/**
 * jedisDemo1
 * Created by huanghaopeng on 16/10/19.
 */
public class JedisDemo1 {
    public static void main(String[] args) {
        RedisClient client = new RedisClient();
        for(int i = 0 ; i < 10 ; i++){
            Jedis jedis = client.getJedis();
            String value = jedis.get("mykey");
            jedis.close();
            System.out.println(value);
        }
        System.out.println("redis操作结束");
    }
}
