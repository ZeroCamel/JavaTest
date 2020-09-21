package threadandparallel.threadsafe;

/**
 * @program: JavaTest
 * @description: 12306买票示例
 * 线程不安全情况1：
 *   1>边界情况有负数
 *   2>ThreadLocal 线程局部存储 读取有票数相同的情况
 *
 * @author: zeroCamel
 * @create: 2020-08-20 09:33
 **/

public class TicketDemo {
    public static void main(String[] args)
    {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"客户A").start();
        new Thread(buyTicket,"客户B").start();
        new Thread(buyTicket,"客户C").start();
    }
}
class BuyTicket  implements Runnable{

    private int ticketNums = 10;

    private boolean flag = true;

    @Override
    public void run() {
        while (flag)
        {
            testBuy4();
        }
    }

    /**
     * Synchronized-1
     * 同步方法 粒度太大 影响效率
     */
    public synchronized void testBuy()
    {
        if (ticketNums <= 0)
        {
            flag = false;
            return;
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"-->"+ ticketNums--);
    }

    /**
     * Synchronized-2
     * 对象
     */
    public void testBuy1()
    {
        synchronized(this)
        {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }

    /**
     * Synchronized-2
     * 锁定其中一个变量失效 基本类型 装箱和拆箱 随时会变
     */
    public void testBuy2()
    {
        synchronized((Integer)ticketNums)
        {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }

    /**
     * Synchronized-3
     * 粒度太小 无法保证原子性 导致失效
     */
    public void testBuy3()
    {
        synchronized((Integer)ticketNums)
        {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }

    /**
     * Synchronized-4
     * 临界区边界问题分析 双重校验锁Double checking
     * 保证数据完整性 合理降低锁的粒度 提高效率
     */
    public void testBuy4()
    {
        // 没有票的情况 目的是减少获取锁的开销 降低锁的粒度
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        synchronized((Integer)ticketNums)
        {
            // 最后一张票的情况
            if (ticketNums <= 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }

    }
}