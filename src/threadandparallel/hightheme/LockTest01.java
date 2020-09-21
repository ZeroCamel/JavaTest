package threadandparallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${Lock}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-23 16:46
 **/
public class LockTest01 {

    Lock lock = new Lock();

    public void a()
    {
        lock.lock();
        doSomething();
        lock.unlock();
    }

    /**
     * 不可重入锁
     */
    public void doSomething()
    {
        lock.lock();
        lock.unlock();
    }

    public static void main(String[] args)
    {
        LockTest01 lockTest01 = new LockTest01();
        lockTest01.a();
    }
}
class Lock{
    /**
     * 是否占用
     */
    private boolean isLocked = false;

    /**
     * 使用锁
     */
    public synchronized void lock()
    {
        while (isLocked)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isLocked = true;
    }

    /**
     * 释放锁
     */
    public synchronized void unlock()
    {
        isLocked = false;
        notify();
    }
}

