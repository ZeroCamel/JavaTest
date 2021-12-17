package jvm.testloadclass;

/**
 * <p>
 *
 * </p>
 *
 * @package: jvm.testloadclass
 * @description:
 * @author:
 * @date: Created in 2021/12/17 13:47
 * @copyright: Copyright (c)2021
 * @version: V1.0
 * @modified:
 **/
public class ClassLoadDemo5 {
    static {
        System.out.println("静态代码块");
    }

    public ClassLoadDemo5() {
        System.out.println("无参构造函数");
    }

    public ClassLoadDemo5(String str) {
        System.out.println("有参构造函数");
    }

    public void sayHello() {
        System.out.println("普通代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public static void main(String[] args) {
        System.out.println("执行了main方法");

        new ClassLoadDemo5().sayHello();

        System.out.println("---------------------------");

        new ClassLoadDemo5().sayHello();


    }
}
