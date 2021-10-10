package threadandparallel.threadstate;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaTest
 * @description: ${工具类}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-10 10:30
 **/
public class SleepUtils {
    public static final void second(long seconds)
    {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
