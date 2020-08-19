package ThreadAndParallel;

/**
 * @program: JavaTest
 * @description: lambda表达式 不使用不编译，使用才编译，接口只允许有一个方法
 * @author: zeroCamel
 * @create: 2020-08-19 14:41
 **/
public class LambdaThread {

    /**
     *  外部类 -> 静态内部类 只使用一次 -> 局部内部类 -> 匿名内部类
     */
    static class Test implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<20;i++)
            {
                System.out.println("一边听歌...");
            }
        }
    }
}
