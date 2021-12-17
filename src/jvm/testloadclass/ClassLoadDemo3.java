package jvm.testloadclass;

/**
 * <p>
 * 类属性执行顺序
 * 1 类中有静态属性 初始化当前类 会默认执行吗？
 * 2 准备阶段会给静态属性分配空间 静态常量准备阶段直接赋值
 * </p>
 *
 * @package: jvm.testloadclass
 * @description: 类属性执行顺序
 * @author: zjf
 * @date: Created in 2021/12/17 11:15
 * @copyright: Copyright (c)2021
 * @version: V1.0
 * @modified: zjf
 **/
public class ClassLoadDemo3 {
    public static void main(String[] args) {
        // 主动引用
        // 1 类的静态变量 会触发类的初始化操作
        // 2 类的常量引用 不会触发类的初始化操作 编译期间 常量传播优化
        System.out.println(T.COUNT);
        // 再次调用 直接输出
        System.out.println(T.COUNT);
    }
}

/**
 * 静态属性在编译时已经指定
 */
class T0 {
    public static int COUNT;

    public static float AFLOAT;

    public T0() {
        COUNT++;
    }
}

class T {
    /**
     * 静态属性 优于构造函数装载
     */
    public static int COUNT = 2;

    /**
     * 静态属性 初始化当前类
     */
    public static T t = new T();

    public static T t1 = new T();

    // 静态代码块1 先声明先执行 因为上面有属性进行初始化操作 所以在构造函数之后执行
    // 反例见 参考Demo5
    static {
        System.out.println("STATIC T:" + COUNT);
        COUNT++;
        System.out.println("STATIC T:" + COUNT);
    }

    /**
     * 构造函数 初始化时执行
     */
    public T() {
        System.out.println("T:" + COUNT);
        COUNT++;
        System.out.println("T:" + COUNT);
    }

    // 静态代码块2 后声明后执行  因为上面有属性进行初始化操作 所以在构造函数之后执行
    static {
        System.out.println("STATIC T:" + COUNT);
        COUNT++;
        System.out.println("STATIC T:" + COUNT);
    }

    // 构造代码块 在创建对象的时候执行 没创建一次 就执行一次
    {
        System.out.println("NOT STATIC T:" + COUNT);
        COUNT++;
        System.out.println("NOT STATIC T:" + COUNT);
    }
}

class T1 {
    public static T1 t = new T1();
    public static int COUNT = 2;

    public T1() {
        System.out.println("T1:" + COUNT);
        COUNT++;
        System.out.println("T1:" + COUNT);
    }
}