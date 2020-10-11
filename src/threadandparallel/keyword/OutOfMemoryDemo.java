package threadandparallel.keyword;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-10-11 16:46
 **/
public class OutOfMemoryDemo {

    public static class TestThread extends Thread {
        @Override
        public void run() {
            ThreadLocal threadLocal = new ThreadLocal();
            int[] ints = new int[1024 * 1024];
            threadLocal.set(ints);
//            threadLocal.remove();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            threadPoolExecutor.execute(new TestThread());
        }

        threadPoolExecutor.shutdown();

    }
}
