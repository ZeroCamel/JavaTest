package threadandparallel;

/**
 * @program: JavaTest
 * @description: 终止线程
 * @author: zeroCamel
 * @create: 2020-08-19 15:55
 **/
public class TerminateThread implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        while (flag)
        {
            System.out.println("运行中...");
        }
    }

    public void stop()
    {
        this.flag = false;
    }
}
