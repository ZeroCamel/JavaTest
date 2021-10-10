package threadandparallel;

/**
 * @program: JavaTest
 * @description: ${线程优先级不能作为程序正确性的依赖}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-19 22:36
 **/
public class PriorityThread {
    public static void test01()
    {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();

        Thread thread = new Thread(myPriority,"a");
        Thread thread1 = new Thread(myPriority,"b");
        Thread thread2 = new Thread(myPriority,"c");
        Thread thread3 = new Thread(myPriority,"d");
        Thread thread4 = new Thread(myPriority,"e");
        Thread thread5 = new Thread(myPriority,"f");

        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread4.setPriority(Thread.MIN_PRIORITY);
        thread5.setPriority(Thread.MIN_PRIORITY);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}