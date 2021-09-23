package jvm.oomdemo;

import java.util.HashSet;

/**
 * @program: JavaTest
 * @description: ${运行时常量池溢出}
 * @author: Mr.ZeroCamel
 * @create: 2021-08-22 22:52
 **/
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        HashSet<String> stringHashSet = new HashSet<>();
        short i = 0;
        while (true)
        {
            stringHashSet.add(String.valueOf(i++).intern());
        }
    }
}
