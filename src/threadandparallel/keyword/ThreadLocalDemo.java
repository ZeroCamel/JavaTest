package threadandparallel.keyword;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: JavaTest
 * @description: ${内存泄漏模拟}
 * @author: Mr.ZeroCamel
 * @create: 2020-10-11 09:33
 **/
public class ThreadLocalDemo {
    public static void main(String[] args) {

        boolean doRemove = true;

        Object object = new Object();

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Map<Long,Integer> hashMap = new ConcurrentHashMap<>();

        for (int i = 0;i<20;i++)
        {
            executorService.execute(()->{
                synchronized (object){
                    Integer integer = hashMap.putIfAbsent(Thread.currentThread().getId(), 1);
                    if (null == integer)
                    {
                        ThreadLocal<Byte[]> threadLocal = new ThreadLocal<>();
                        threadLocal.set(new Byte[1024*1024]);
                        if (doRemove)
                        {
                            threadLocal.remove();
                        }
                        threadLocal = null;

                        System.gc();

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

}
