package jvm.testloadclass;

/**
 * <p>
 * 被动引用
 * 初始化 实例化 是不一样的概念
 * </p>
 *
 * @package: jvm.testloadclass
 * @description: 被动引用 HotSpot 虚拟机并不会触发子类的初始化操作
 * @author: zjf
 * @date: Created in 2021/12/17 11:36
 * @copyright: Copyright (c)2021
 * @version: V1.0
 * @modified: zjf
 **/
public class ClassLoadDemo4 {
    static {
        System.out.println("main class load!");
    }

    public static void main(String[] args) {
        // 触发调用类的初始化
        System.out.println(SubClass.value);
    }
}

class SuperClass {
    static {
        System.out.println("super class init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("subclass init!");
    }
}