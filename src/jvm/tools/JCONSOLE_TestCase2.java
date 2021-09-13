package jvm.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JavaTest
 * @description: ${
 * 线程标签 jstack
 * }
 * @author: Mr.ZeroCamel
 * @create: 2021-09-13 23:09
 **/
public class JCONSOLE_TestCase2 {
    /**
     * 线程死循环演示
     */
    public static void createBusyThread()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        },"testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        createBusyThread();
        bufferedReader.readLine();
        Object o = new Object();
        createLockThread(o);
    }
}
