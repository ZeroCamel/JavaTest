package ThreadAndParallel;

/**
 * @program: JavaTest
 * @description: ${礼让线程- 暂停线程-使得线程进入就绪状态而不是阻塞状态}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-19 20:57
 **/
public class YieldDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"礼让线程开始...");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"礼让线程结束...");
    }
}
