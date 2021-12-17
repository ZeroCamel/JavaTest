package jvm.testloadclass;

/**
 * @program: JavaTest
 * @description: JVM类型加载
 * @author: zeroCamel
 * @create: 2020-08-26 15:41
 **/
public class ClassLoadDemo {

    static {
        System.out.println("ClassLoadDemo01");
    }

    public static void main(String[] args) {
        System.out.println("main执行");
        A a = new A();
        System.out.println(A.width);

        // 再次实例化 不会有静态域打印输出 只会加载一次
        A a1 = new A();

        // B 不初始化 被动引用
        System.out.println(B.width);
    }

}
class B extends A{
    static {
        System.out.println("静态初始化B");
    }
}
class A extends A_Father{

    // 静态域
    public static int width = 100;

    // 静态快
    static {
        System.out.println("静态初始化类A");
        width=300;
    }

    public A()
    {
        System.out.println("创建A类的对象");
    }
}
class A_Father{
    static {
        System.out.println("静态初始化A_Father");
    }
}