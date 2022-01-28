package designpattern.create.singlepattern;

/**
 * @program: JavaTest
 * @description: ${懒汉加锁}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 20:39
 **/
public class LazySimpleLockSingleton {

    /**
     * 静态块 公共内存区域
     */
    private static LazySimpleLockSingleton lazy = null;

    private LazySimpleLockSingleton() {
    }

    public synchronized static LazySimpleLockSingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySimpleLockSingleton();
        }
        return lazy;
    }
}
