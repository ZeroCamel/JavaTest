package designpattern;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 20:46
 **/
public class ThreadInvokeTest {
    public static void main(String[] args) {
        ExectorThread exectorThread = new ExectorThread();
        Thread thread = new Thread(exectorThread);
        Thread thread1 = new Thread(exectorThread);
        thread.start();
        thread1.start();

//        单例
//        System.out.println(ThreadLocalSingleton.getInstance());
//        System.out.println(ThreadLocalSingleton.getInstance());
//        System.out.println(ThreadLocalSingleton.getInstance());

        System.out.println("End");
    }
}
