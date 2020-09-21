package threadandparallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${volatile 保证数据的同步，也就是可见性，不保证原子性}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-22 22:42
 **/
public class VolatileTitle {

    /**
     * 静态存储资源也会加载到工作内存
     */
    private volatile static int num =0;

    public static void main(String[] args)
    {
        new Thread(()->{
            while (num==0)
            {
                // 此处不编写任何代码
            }

        }).start();

        try {
            Thread.sleep(1000);
            num =1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
