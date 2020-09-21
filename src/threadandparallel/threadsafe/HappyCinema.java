package threadandparallel.threadsafe;

/**
 * @program: JavaTest
 * @description: 快乐影院
 * @author: zeroCamel
 * @create: 2020-08-20 16:37
 **/
public class HappyCinema {
    public static void main(String[] args)
    {
        Cinemal cinemal = new Cinemal(20,"大话西游");
        new Thread(new Customer(2,cinemal),"顾客1").start();
        new Thread(new Customer(1,cinemal),"顾客2").start();
    }
}

class Customer implements Runnable{

    int seats;
    Cinemal cinemal;

    public Customer(int seats, Cinemal cinemal) {
        this.seats = seats;
        this.cinemal = cinemal;
    }

    @Override
    public void run() {
        bookTicket(this.seats);
    }

    /**
     * 买票
     * @param seats
     */
    public void bookTicket(int seats)
    {
        synchronized (cinemal)
        {
            boolean bookService = cinemal.bookService(seats);
            if (bookService)
            {
                System.out.println(Thread.currentThread().getName()+",座位锁定，购票成功-->预定个数:"+seats);
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+",座位不够，购票失败-->预定个数:"+seats);
            }
        }
    }
}

class Cinemal{

    int available;
    String name;

    public Cinemal(int available, String name) {
        this.available = available;
        this.name = name;
    }

    /**
     * 下单买票
     * @return
     */
    public boolean bookService(int seats)
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

}

