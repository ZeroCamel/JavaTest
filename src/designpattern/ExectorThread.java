package designpattern;


import designpattern.create.singlepattern.LazySimpleLockSingleton;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 20:43
 **/
public class ExectorThread implements Runnable {
    @Override
    public void run() {
//      HungrySingleton.Singleton1 instance = HungrySingleton.Singleton1.getInstance();
//      LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
        LazySimpleLockSingleton instance = LazySimpleLockSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
