package ThreadAndParallel.hightheme;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: JavaTest
 * @description: ${CAS-无锁机制-乐观锁机制
 * 原理：JNI
 * }
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 20:58
 **/
public class CASTest {

    // 库存
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

            new Thread(() -> {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // CAS 无锁实现
                int decrementAndGet = stock.decrementAndGet();
                if (decrementAndGet < 1) {
                    System.out.println("抢完了...");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "抢了一件商品...");
                System.out.println("-->还剩" + decrementAndGet);


            }).start();

        }
    }
}
