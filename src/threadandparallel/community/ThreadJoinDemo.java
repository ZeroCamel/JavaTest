package threadandparallel.community;

import threadandparallel.threadstate.SleepUtils;

/**
 * @program: JavaTest
 * @description: ${线程编排
 * join 与等待通知机制一致 都是加锁、循环处理逻辑 }
 * @author: Mr.ZeroCamel
 * @create: 2021-10-10 20:07
 **/
public class ThreadJoinDemo {
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;

        }

        SleepUtils.second(5);
        System.out.println(Thread.currentThread().getName()+ " terminate.");
    }

    static class Domino implements Runnable
    {
        private Thread thread;
        public Domino(Thread thread)
        {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" terminate.");
        }
    }
}
