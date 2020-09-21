package threadandparallel.hightheme;

import java.util.Random;

/**
 * @program: JavaTest
 * @description: ${ThreadLocal基本操作：get/set/InitValue}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 15:45
 **/
public class ThreadLocalDemo {

//    private static ThreadLocal threadLocal = new ThreadLocal();

//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal(){
//        @Override
//        protected Object initialValue() {
//            return 20;
//        }
//    };

//    //JDK8--Lambda表达式
    private static ThreadLocal threadLocal=ThreadLocal.withInitial(()->30);


    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        // 再次新建一个线程
        new Thread(()->{
            threadLocal.set((new Random().nextInt())*99);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        }).start();

    }
}
