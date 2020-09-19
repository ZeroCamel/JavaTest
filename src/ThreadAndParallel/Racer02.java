package ThreadAndParallel;

import java.util.concurrent.Callable;

/**
 * @program: JavaTest
 * @description: 龟兔赛跑4-Callable
 * @author: zeroCamel
 * @create: 2020-08-19 11:44
 **/
public class Racer02 implements Callable<Integer> {

    private String winner=null;

    private static int TOTAL_STEP = 100;

    @Override
    public Integer call() throws InterruptedException {
        // steps 位于线程内部
        for (int steps=1;steps<=TOTAL_STEP;steps++)
        {
            // 模拟兔子休息
            String strThread = "pool-1-thread-1";
            if (Thread.currentThread().getName().equals(strThread)&&steps%5==0)
            {
               Thread.sleep(100);
            }

            System.out.println("当前线程："+Thread.currentThread().getName()+",步数："+steps);

            boolean gameOver = gameOver(steps);
            if (gameOver)
            {
                return steps;
            }
        }
        return -1;
    }


    public boolean gameOver(int steps)
    {
        if (winner!=null)
        {
            return true;
        }
        else
        {
            if (steps==TOTAL_STEP)
            {
                winner = Thread.currentThread().getName();
                System.out.println("胜利者："+winner);
                return true;
            }
        }
        return false;
    }
}
