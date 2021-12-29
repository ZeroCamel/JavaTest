package designpattern.create.singlepattern;

/**
 * @program: JavaTest
 * @description: ${线程单例}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-29 23:35
 **/
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance()
    {
        return threadLocalInstance.get();
    }
}
