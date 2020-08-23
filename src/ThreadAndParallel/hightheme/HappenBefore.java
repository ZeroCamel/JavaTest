package ThreadAndParallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${指令重排}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-22 18:44
 **/
public class HappenBefore {
    private static boolean flag = false;
    private static int a = 0;
    public static void main(String[] args) throws InterruptedException {

        for (int i=0;i<100;i++)
        {
            a=0;
            flag = false;
        // 修改
        Thread thread = new Thread(() -> {
            a = 1;
            flag = true;
        });

        // 更改
        Thread thread1 = new Thread(() -> {
            if (flag) {
                a *= 1;
            }

            if (a == 0) {
                System.out.println("happen before：" + a);
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        }
    }
}
