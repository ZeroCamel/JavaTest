package designpattern.create.singlepattern;

/**
 * @program: JavaTest
 * @description: ${懒汉}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 20:39
 **/
public class LazySimpleSingleton {
    private LazySimpleSingleton() { }
    // 静态块 公共内存区域
    private static LazySimpleSingleton lazy = null;
    public static LazySimpleSingleton getInstance()
    {
        if (lazy == null)
        {
            return new LazySimpleSingleton();
        }
        return lazy;
    }
}
