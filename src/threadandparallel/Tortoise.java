package threadandparallel;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${1、implements Runable 2、extends Thread}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-17 19:44
 **/
public class Tortoise implements Runnable {
    private int totalStep;
    private int step;
    public Tortoise(int totalStep)
    {
        this.totalStep = totalStep;
    }

    @Override
    public void run() {
        try{
            while(step<totalStep) {
                Thread.sleep(1000);
                step++;
                out.printf("乌龟跑了 %d步...%n",step);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

