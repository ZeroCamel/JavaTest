package threadandparallel.hightheme;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaTest
 * @description: ${可重入锁ReentrantLock}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 16:46
 **/
public class LockTest03 {

    ReentrantLock lock = new ReentrantLock();

    public void a() {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    /**
     * 不可重入锁
     */
    public void doSomething() {
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public static void main(String[] args) {
        LockTest03 lockTest03 = new LockTest03();
        lockTest03.a();
        System.out.println(lockTest03.lock.getHoldCount());
    }
}
