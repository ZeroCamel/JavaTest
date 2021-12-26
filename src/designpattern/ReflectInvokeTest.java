package designpattern;

import designpattern.create.singlepattern.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: JavaTest
 * @description: ${反射调用破坏单例}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 22:29
 **/
public class ReflectInvokeTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = LazyStaticInnerClassSingleton.class;
        Constructor<?> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        Object o1 = c.newInstance();
        Object o2 = c.newInstance();
        System.out.println(o1==o2);
    }
}
