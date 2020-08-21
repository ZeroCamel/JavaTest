package ThreadAndParallel.threadsafe;

/**
 * @program: JavaTest
 * @description: 死锁产生原因:
 * 四大必要条件之一 请求与保持
 * 另外三个 不可剥夺 互斥 环路等待
 *
 * 1、静态资源 模拟临界区域
 * 2、非静态资源
 * 3、阻塞 非阻塞
 *
 * synchronized
 * 可重入 不可中断 非公平
 *
 * @author: zeroCamel
 * @create: 2020-08-21 10:03
 **/
public class DeadLock {
    public static void main(String[] args)
    {
        MakeUp makeUp = new MakeUp(0, "A");
        MakeUp makeUp1 = new MakeUp(1, "B");

        makeUp.start();
        makeUp1.start();
    }
}
class Lipstick{

}
class Mirror{

}
class MakeUp extends Thread{

    /**
     * 静态资源
     */
    public static Lipstick lipstick = new Lipstick();
    public static Mirror mirror = new Mirror();

    public int choice;
    public String name;

    public MakeUp(int choice,String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        makeUp();
    }

    /**
     * 持有多个对象的锁
     */
    public void makeUp()
    {
        if (this.choice == 0)
        {
            synchronized (lipstick)
            {
                System.out.println(this.name+"拿口红");
                try {
                    // 阻塞
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror)
                {
                    System.out.println(this.name+"拿镜子");
                }
            }

        } else {
            synchronized (mirror)
            {
                System.out.println(this.name+"拿镜子");
                try {
                    // 阻塞
                    Thread.sleep(1000*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick)
                {
                    System.out.println(this.name+"拿口红");
                }
            }
        }
    }

    /**
     * 哲学家问题
     */
    public void makeUpNoDead()
    {
        if (this.choice == 0)
        {
            synchronized (lipstick)
            {
                System.out.println(this.name+"拿口红");
                try {
                    // 阻塞
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (mirror)
            {
                System.out.println(this.name+"拿镜子");
            }

        } else {

            synchronized (mirror)
            {
                System.out.println(this.name+"拿镜子");
                try {
                    // 阻塞
                    Thread.sleep(1000*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (lipstick)
            {
                System.out.println(this.name+"拿口红");
            }
        }
    }
}