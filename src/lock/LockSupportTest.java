package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zerocamel
 * @version V1.0
 * @Title: LockSupport原理剖析
 * @Description:
 * 信号量机制 类似 Semaphore.wait Semaphore.release SemaphoreSlim(1)
 * LockSupport:
 *  1、线程阻塞需要消耗凭证permit-_counter 这个凭证只有一个
 *  2、unpart操作可以在part操作之前
 * @date 2021/8/20 9:45
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new ParkThread());
        thread.start();
        //  情形一
        System.out.println("开始线程唤醒");
        // 将标志位_counter置为1 同时判断前值小于1进行线程唤醒否则直接退出
        LockSupport.unpark(thread);
        System.out.println("结束线程唤醒");
    }

    /**
     * 情形一
     */
    static class ParkThread implements Runnable {
        @Override
        public void run() {

            System.out.println("开始线程阻塞");
            // 将标志位_Counter置为0 同时判断前值 小于1说明前面被unpark直接退出 否则线程阻塞
            LockSupport.park();
            System.out.println("结束线程阻塞");
        }
    }

    /**
     * 情形二 线程睡眠1秒
     */
    static class ParkThread1 implements Runnable {
        @Override
        public void run() {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            System.out.println("开始线程阻塞");
            LockSupport.park();
            System.out.println("结束线程阻塞");
        }
    }

    /**
     * 情形三  循环执行2次
     */
    static class ParkThread2 implements Runnable {
        @Override
        public void run() {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            for (int i = 0; i < 2; i++) {
                System.out.println("开始线程阻塞");
                LockSupport.park();
                System.out.println("结束线程阻塞");

            }
        }
    }
}
