package designpattern.create.singlepattern;

/**
 * @program: JavaTest
 * @description: ${静态内部类
 * 兼顾饿汉式单例写法的内存浪费和synchronized的性能问题 默认先初始化内部类
 * java 本身语法特点 如果没使用 内部类是不加载的
 * static 单例模式的空间共享 保证方法不会被重写 重载
 * 反射会破坏 需要在构造函数中增加校验抛出异常}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 22:19
 **/
public class LazyStaticInnerClassSingleton {

    private LazyStaticInnerClassSingleton(){}
    private static LazyStaticInnerClassSingleton getInstance()
    {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }
}
