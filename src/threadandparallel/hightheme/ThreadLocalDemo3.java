package threadandparallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${ThreadLocal上下文
 * 构造函数中的线程还是主线程体}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 15:45
 **/
public class ThreadLocalDemo3 {

    private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);


    public static void main(String[] args)
    {
        MyRun myRun = new MyRun();
        new Thread(new MyRun()).start();

        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{

        public MyRun()
        {
            threadLocal.set(1000);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }

        @Override
        public void run() {
            Integer o = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"得到了:"+o);
            threadLocal.set(o-1);
            System.out.println(Thread.currentThread().getName()+"还剩下:"+threadLocal.get());
        }
    }

}
