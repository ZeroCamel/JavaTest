package ThreadAndParallel.threadsafe;

/**
 * @program: JavaTest
 * @description: 快乐影院-使用同步方法
 * @author: zeroCamel
 * @create: 2020-08-20 16:37
 **/
public class HappyCinema2 {
    public static void main(String[] args)
    {
        HappyCinemalUp happyCinema2 = new HappyCinemalUp(10, "大话西游");
        new Customer2(happyCinema2,"顾客A",2).start();
        new Customer2(happyCinema2,"顾客B",1).start();
    }
}

/**
 * Thread 代理类 可以给线程增加额外的变量
 */
class Customer2 extends Thread{

    int seats;

    public Customer2(Runnable target,String name,int seats) {
        super(target,name);
        this.seats = seats;
    }

}

class HappyCinemalUp implements Runnable{

    int available;
    String name;

    public HappyCinemalUp(int available, String name) {
        this.available = available;
        this.name = name;
    }

    /**
     * 下单
     * @return
     */
    public synchronized boolean bookService(int seats)
    {
        if (available<seats)
        {
            return false;
        }
        else
        {
            System.out.println("可用位置:"+available);
            available-=seats;
            return true;
        }
    }

    /**
     * 订票
     */
    @Override
    public void run() {

        // 获取当前线程进行强制转换
        Customer2 customer2= (Customer2)Thread.currentThread();

        boolean bookService = this.bookService(customer2.seats);
        if (bookService)
        {
            System.out.println(Thread.currentThread().getName()+",座位锁定，购票成功-->预定个数:"+customer2.seats);
        }
        else
        {
            System.out.println(Thread.currentThread().getName()+",座位不够，购票失败-->预定个数:"+customer2.seats);
        }
    }

}

