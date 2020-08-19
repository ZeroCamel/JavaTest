package ThreadAndParallel;

/**
 * @program: JavaTest
 * @description: ${线程状态}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-19 22:10
 **/
public class AllState {
    public static void test01()
    {
        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("...");
        });

        System.out.println(thread.getState());
        // 活跃的线程数
        System.out.println(Thread.activeCount());

        thread.start();
        System.out.println(thread.getState());

        while (thread.getState()!=Thread.State.TERMINATED)
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getState());
        }

        System.out.println(Thread.activeCount());
        System.out.println(thread.getState());
    }
}
