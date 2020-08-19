package ThreadAndParallel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: JavaTest
 * @description: 龟兔赛跑3-淘汰赛
 * @author: zeroCamel
 * @create: 2020-08-19 11:44
 **/
public class Racer01 implements Runnable {

    private static String winner=null;

    private int TOTAL_STEP = 100;

    @Override
    public void run() {
        // steps 位于线程内部
        for (int steps=1;steps<=TOTAL_STEP;steps++)
        {
            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("rabbit")&&steps%5==0)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Date date = new Date(System.currentTimeMillis() + 1000 * 10);
            System.out.println(Thread.currentThread().getName()+":"+new SimpleDateFormat("hh:mm:ss").format(date) +"-->"+steps);
            boolean gameOver = gameOver(steps);
            if (gameOver)
            {
                break;
            }
        }
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
