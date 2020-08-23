package ThreadAndParallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${可重入锁-原理-锁可以延续使用-增加锁的识别属性
 * 1、判断是否当前线程
 * 2、增加锁的计数器}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 16:46
 **/
public class LockTest02 {

    ReLock lock = new ReLock();

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
        LockTest02 lockTest02 = new LockTest02();
        lockTest02.a();
        System.out.println(lockTest02.lock.getHoldCount());
    }
}

class ReLock {
    /**
     * 是否占用
     */
    private boolean isLocked = false;

    /**
     * 存储线程
     */
    private Thread lockBy = null;

    /**
     * 锁计数
     */
    private int holdCount = 0;

    /**
     * 使用锁
     */
    public synchronized void lock() {
        Thread thread = Thread.currentThread();

        // 判读是否锁定并且不是当前线程
        while (isLocked && lockBy != thread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isLocked = true;
        lockBy = thread;
        holdCount++;
    }

    /**
     * 根据锁的计数标识和是否当前线程-释放锁
     */
    public synchronized void unlock() {

        if (Thread.currentThread() == lockBy) {
            holdCount--;
            if (holdCount == 0) {

                isLocked = false;
                notify();
                lockBy = null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}

