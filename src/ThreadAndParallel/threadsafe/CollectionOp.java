package ThreadAndParallel.threadsafe;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: JavaTest
 * @description: 容器操作
 * 快速失败错误检测机制
 *  fail-fast集合
 *  fail-safe集合
 * @author: zeroCamel
 * @create: 2020-08-20 13:22
 **/
public class CollectionOp {
    public static void main(String[] args)
    {
        simple.synContainer();
    }
}
class simple{

    /**
     * 非并发集合
     */
    public static void simgList()
    {
        ArrayList<String> strings = new ArrayList<>();
        int i =10000;
        while (i>0)
        {
            new Thread(()->{

                synchronized (strings)
                {
                    strings.add(Thread.currentThread().getName());
                }

            }).start();

            i--;
        }

        // 延时等待线程结束 再获取结果
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(strings.size());
    }

    /**
     * 并发容器 线程安全 底层实现Synchronized
     */
    public static void synContainer()
    {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        int i =10000;
        while (i>0)
        {
            new Thread(()->{
                    strings.add(Thread.currentThread().getName());
            }).start();

            i--;
        }

        // 延时等待线程结束 再获取结果
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(strings.size());
    }
}
