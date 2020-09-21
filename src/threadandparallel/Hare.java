package threadandparallel;

import java.util.Random;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${1、implements Runable 2、extends Thread}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-17 20:04
 **/
public class Hare implements Runnable {
    private boolean[] flags = {true,false};
    private int step;
    private int totalStep;

    public Hare(int totalStep)
    {
        this.totalStep = totalStep;
    }

    @Override
    public void run() {
        try{
            while(step<totalStep)
            {
                Thread.sleep(1000);
                boolean ifHareSleep = flags[(int)(new Random().nextInt())%2];
                if(ifHareSleep)
                {
                    out.println("兔子睡着了...");
                } else {
                    step+=2;
                    out.printf("兔子走了 %d步...%n",step);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
