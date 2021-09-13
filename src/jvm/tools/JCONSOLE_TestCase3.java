package jvm.tools;

/**
 * @program: JavaTest
 * @description: ${
 * 线程标签 线程死锁
 * }
 * @author: Mr.ZeroCamel
 * @create: 2021-09-13 23:27
 **/
public class JCONSOLE_TestCase3 {
    static class SynAddRunnable implements Runnable{

        int a,b;

        SynAddRunnable(int a,int b)
        {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a))
            {
                synchronized (Integer.valueOf(b))
                {
                    System.out.println(a+b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2,1)).start();
        }
    }
}
