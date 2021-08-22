package redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-09-19 23:57
 **/
public class JedisPoolUtil {

    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil()
    {

    }

    public JedisPool getJedisPoolUtilInstance()
    {
        if (null == jedisPool)
        {
            synchronized (JedisPoolUtil.class)
            {
                if (null == jedisPool)
                {
//                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//                    jedisPoolConfig.setMaxTotal(1000);
//                    jedisPoolConfig.setMaxIdle(32);
//                    jedisPoolConfig.setMaxWaitMillis(10*1000);
//                    jedisPoolConfig.setTestOnBorrow(true);
//
//                    jedisPool = new JedisPool(jedisPoolConfig, "192.168.124.21", 6379);

                }
            }
        }
        return jedisPool;
    }
}
