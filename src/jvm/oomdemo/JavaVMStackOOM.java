package jvm.oomdemo;

/**
 * @program: JavaTest
 * @description: ${创建线程导致内存溢出异常}
 * @author: Mr.ZeroCamel
 * @create: 2021-08-22 10:46
 **/
public class JavaVMStackOOM {
    private void dontStop()
    {
        while (true)
        {

        }
    }

    public void stackLeakByThread()
    {
        int i = 0;
        while (true)
        {
            i++;
            System.out.println("线程数量:"+i);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }
}
