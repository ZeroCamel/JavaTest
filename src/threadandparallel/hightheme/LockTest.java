package threadandparallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${可重入锁-体现了锁的继承关系 以及延续性
 * }
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 16:46
 **/
public class LockTest {

    public void test()
    {
        synchronized (this){
            while (true)
            {
                synchronized (this)
                {
                    System.out.println("可重入锁...");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new LockTest().test();
    }
}

