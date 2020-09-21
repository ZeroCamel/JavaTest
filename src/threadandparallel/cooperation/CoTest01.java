package threadandparallel.cooperation;

/**
 * @program: JavaTest
 * @description: 协作模型：生产者消费者实现方式-管程法
 * 消息队列
 * 队列临界值 也是一种信号灯机制
 * @author: zeroCamel
 * @create: 2020-08-21 11:07
 **/
public class CoTest01 {
    public static void main(String[] args)
    {
        SynContainer synContainer = new SynContainer();
        new Producer(synContainer).start();
        new Consumer(synContainer).start();
    }
}

class Producer extends Thread{

    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i =0;i<100;i++)
        {
            synContainer.push(new SteamedCake(i));
            System.out.println(Thread.currentThread().getName()+"生产-->"+i);
        }
    }
}

class Consumer extends Thread{
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i =0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+"消费-->"+synContainer.pop().id);
        }
    }
}

class SynContainer{

    SteamedCake[] steamedCakes = new SteamedCake[10];
    int count = 0;

    public synchronized void push(SteamedCake steamedCake)
    {
        if (count == steamedCakes.length)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        steamedCakes[count] = steamedCake;
        count++;

        // 唤醒消费
        this.notifyAll();
    }

    public synchronized SteamedCake pop()
    {
        if (count == 0){
            try {
                // 阻塞
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        SteamedCake steamedCake = steamedCakes[count];

        // 唤醒生产
        this.notifyAll();

        return  steamedCake;
    }
}

class SteamedCake{

    int id;

    public SteamedCake(int id) {
        this.id = id;
    }
}