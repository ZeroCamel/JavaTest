package redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @program: JavaTest
 * @description: ${redis客户端
 * 1、jedis 多线程线程不安全 可以使用连接池pool 每个线程单独使用一个jedis实例 但如果线程数太多 无界线程 负载加大
 * 2、lettuce
 * 3、RedisTemplate
 * }
 * @author: Mr.ZeroCamel
 * @create: 2020-09-19 19:44
 **/
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.124.21", 6379);
        System.out.println(jedis.ping());
        String k1 = jedis.get("k1");
        System.out.println(k1);
        jedis.set("redis","3.0.3");

        Set<String> sets = jedis.keys("*");
        System.out.println(sets.size());
    }
}
