package ThreadAndParallel.cooperation;

/**
 * @program: JavaTest
 * @description: 协作模型：生产者消费者实现方式-信号灯-保证有序性
 * 借助标志位
 * 场景-电视直播
 * @author: zeroCamel
 * @create: 2020-08-21 13:44
 **/
public class CoTest02 {
    public static void main(String[] args)
    {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

/**
 * 演员
 */
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++)
        {
            if (i%2==0)
            {
                tv.play("满城尽带黄金甲");
            }
            else
            {
                tv.play("我自横刀向天笑");
            }
        }
    }
}

/**
 * 观众
 */
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++)
        {
            tv.watch();
        }
    }

}

class Tv{
    String voice;

    /**
     * 信号灯
     */
    boolean blFlag = true;

    /**
     * 表演了
     * @param voice
     */
    public synchronized void play(String voice)
    {
        if (!blFlag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("表演了:"+voice);
        this.voice = voice;

        this.notifyAll();
        this.blFlag =!this.blFlag;
    }

    /**
     * 观看了
     */
    public synchronized void watch()
    {
        if (this.blFlag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("听到了:"+voice);
        this.notifyAll();
        this.blFlag = !blFlag;
    }
}