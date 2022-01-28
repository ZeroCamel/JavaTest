package designpattern.create.singlepattern;

/**
 * @program: JavaTest
 * @description: ${双重校验锁2}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 21:54
 **/
public class LazyDoubleCheckSingleton2 {
    private volatile static LazyDoubleCheckSingleton2 instance;
    private LazyDoubleCheckSingleton2() {}
    public static LazyDoubleCheckSingleton2 getInstance()
    {
        if(instance == null)
        {
            synchronized (LazyDoubleCheckSingleton2.class)
            {
                if (instance == null)
                {
                    instance = new LazyDoubleCheckSingleton2();
                }
            }
        }
        return instance;
    }
}
