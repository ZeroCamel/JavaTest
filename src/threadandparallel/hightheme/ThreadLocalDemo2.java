package threadandparallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${线程局部存储 互不干扰}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 15:45
 **/
public class ThreadLocalDemo2 {

    private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);


    public static void main(String[] args)
    {
        for (int i = 0;i<6;i++)
        {
            MyRun myRun = new MyRun();
            myRun.start();
        }

    }

    public static class MyRun extends Thread{
        @Override
        public void run() {
            Integer o = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"得到了:"+o);
            threadLocal.set(o-1);
            System.out.println(Thread.currentThread().getName()+"还剩下:"+threadLocal.get());
        }
    }

}
