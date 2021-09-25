package jmm;

/**
 * @program: JavaTest
 * @description: ${JMM 共享内存模型 }
 * 1 线程通信 可见性
 * 2 hsdis-amd64.dll
 * @author: Mr.ZeroCamel
 * @create: 2021-09-24 22:29
 **/
public class VolatileVisabilityTest {
    /**
     * volatile 保持变量副本工作可见 代表的是一种实时写入反馈机制
     */
    private static volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("等待数据中....");
            while (!flag)
            {

            }
            System.out.println("数据接收完毕.....");
        }).start();

        Thread.sleep(2000);

        new Thread(()->{
            prepareData();
        }).start();
    }

    public static void prepareData()
    {
        System.out.println("准备数据中....");
        flag = true;
        System.out.println("数准备完毕....");
    }
}
