package threadandparallel;

/**
 * @program: JavaTest
 * @description: ${守护线程：为用户线程服务;JVM停止不用等待}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-19 23:28
 **/
public class DaemonThread {

    public static void test01()
    {
        god god = new god();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();

        MyLife myLife = new MyLife();
        new Thread(myLife).start();
    }

}
class MyLife implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<=365*100;i++)
        {
            System.out.println("Happy everydata...");
        }
    }
}
class god implements Runnable{
    @Override
    public void run() {
        while (true)
        {
            System.out.println("i am here....");
        }
    }
}



