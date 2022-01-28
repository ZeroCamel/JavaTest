package designpattern.create.singlepattern;

/**
 * @program: JavaTest
 * @description: ${双重校验锁}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 21:54
 **/
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;
    private LazyDoubleCheckSingleton() {}
    public static LazyDoubleCheckSingleton getInstance()
    {
        synchronized (LazyDoubleCheckSingleton.class)
        {
            if (instance == null)
            {
                instance = new LazyDoubleCheckSingleton();
            }
        }
        return instance;
    }
}
