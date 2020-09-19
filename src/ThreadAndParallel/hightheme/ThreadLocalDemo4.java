package ThreadAndParallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${InheritableThreadLocal-继承上下文环境的数据
 * 将复数据Copy到子线程，但是子线程可以更改，不影响父线程}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 15:45
 **/
public class ThreadLocalDemo4 {

    private static ThreadLocal<Integer> threadLocal= new InheritableThreadLocal<>();


    public static void main(String[] args)
    {
        threadLocal.set(10);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        // 线程由Main线程开启
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
            threadLocal.set(100);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }).start();

        threadLocal.remove();
    }

}
