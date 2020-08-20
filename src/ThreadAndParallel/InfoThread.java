package ThreadAndParallel;

/**
 * @program: JavaTest
 * @description: 线程信息
 * @author: zeroCamel
 * @create: 2020-08-20 09:18
 **/
public class InfoThread {
    public static void infoTest()
    {
        Thread thread = new Thread(() -> {
            System.out.println("打印线程信息...");
        });

        thread.setName("线程名字");
        thread.start();

        System.out.println(thread.isAlive());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.isAlive());
    }
}
