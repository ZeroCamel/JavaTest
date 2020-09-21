package threadandparallel;

/**
 * @program: JavaTest
 * @description: 龟兔赛跑2-接力赛
 * @author: zeroCamel
 * @create: 2020-08-19 11:44
 **/
public class Racer implements Runnable {

    /**
     * 步数线程全局变量 线程可见
     */
    private int totalStep=100;

    /**
     * 静态全局变量
     */
    private static String winner=null;

    @Override
    public void run() {
        while (totalStep!=0)
        {
            totalStep-=1;
            System.out.println("当前线程："+Thread.currentThread().getName()+",步数："+totalStep);

            boolean gameOver = gameOver(totalStep);
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
            if (steps==0)
            {
                winner = Thread.currentThread().getName();
                System.out.println("最后一棒："+winner);
                return true;
            }
        }
        return false;
    }
}
