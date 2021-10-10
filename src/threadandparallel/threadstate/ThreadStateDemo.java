package threadandparallel.threadstate;

/**
 * @program: JavaTest
 * @description: 线程状态
 * cmd jstack pid
 * @author: Mr.ZeroCamel
 * @create: 2021-10-10 10:25
 **/
public class ThreadStateDemo {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"Waiting").start();
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"BlockedThread-2").start();
    }

    /**
     * 该线程不断的进行休眠
     */
    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true)
            {
                SleepUtils.second(100);
            }
        }
    }

    /**
     * 该线程在Waiting.class上等待
     */
    static class Waiting implements Runnable{
        @Override
        public void run() {
            while (true)
            {
                synchronized (Waiting.class)
                {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 该线程在Blocked实例上加锁 不会释放锁
     */
    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class)
            {
                while (true)
                {
                    SleepUtils.second(100);
                }
            }
        }
    }
}
