package threadandparallel.community;

import threadandparallel.threadstate.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: JavaTest
 * @description: ${线程通信的两种方式：
 * 1 共享内存 volatile synchronized 等待/通知机制 wait notify
 * 2 消息传递 管道输入/输出流}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-10 19:34
 **/
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        SleepUtils.second(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    /**
     * 等待方 实际为消费方
     */
    static class Wait implements Runnable
    {
        @Override
        public void run() {
            synchronized (lock)
            {
                while (flag)
                {
                    System.out.println(Thread.currentThread()+"flag is true. wait @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread()+"flag is false.running @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    /**
     * 通知方 实际为生产者
     */
    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock)
            {
                System.out.println(Thread.currentThread()+"hold lock. Notify @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }

            synchronized (lock)
            {
                System.out.println(Thread.currentThread()+"hold lock again.Sleep @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
