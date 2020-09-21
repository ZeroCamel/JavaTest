package threadandparallel.threadsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaTest
 * @description: 快乐影院-使用容器-选择位置
 * @author: zeroCamel
 * @create: 2020-08-20 16:37
 **/
public class HappyCinema1 {
    public static void main(String[] args)
    {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        ArrayList<Integer> seates1 = new ArrayList<>();
        seates1.add(1);
        seates1.add(4);
        ArrayList<Integer> seates2 = new ArrayList<>();
        seates2.add(1);
        seates2.add(3);
        seates2.add(4);


        HappyCinemal cinemal = new HappyCinemal(integers,"大话西游");
        new Thread(new HappyCustomer(seates1,cinemal),"顾客1").start();
        new Thread(new HappyCustomer(seates2,cinemal),"顾客2").start();
    }
}

class HappyCustomer implements Runnable{

    List<Integer> seats;
    HappyCinemal cinemal;

    public HappyCustomer(List<Integer> seats, HappyCinemal cinemal) {
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
    public void bookTicket(List<Integer> seats)
    {
        synchronized (cinemal)
        {
            boolean bookService = cinemal.bookService(seats);
            if (bookService)
            {
                System.out.println(Thread.currentThread().getName()+",座位锁定，购票成功-->预定位置:"+seats);
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+",座位不够，购票失败-->预定位置:"+seats);
            }
        }
    }
}

class HappyCinemal{

    List<Integer> available;
    String name;

    public HappyCinemal(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    /**
     * 下单买票
     * @return
     */
    public boolean bookService(List<Integer> seats)
    {
        System.out.println("可用位置为:"+available);
        List<Integer> copys = new ArrayList<>();
        copys.addAll(available);

        copys.removeAll(seats);

        // 判断两个移除后数组大小是否应该一样
        if (available.size()-copys.size()!=seats.size())
        {
            return false;
        }

        available = copys;

        return true;
    }

}

