package designpattern;

import designpattern.create.singlepattern.LazyStaticInnerClassSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @program: JavaTest
 * @description: ${反射调用破坏静态内部类单例}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 22:29
 **/
public class StaticInnerClassInvokeTest {
    public static void main(String[] args) throws Exception {
//        反射
//        Class<?> clazz = LazyStaticInnerClassSingleton.class;
//        Constructor<?> c = clazz.getDeclaredConstructor(null);
//        c.setAccessible(true);
//        Object o1 = c.newInstance();
//        Object o2 = c.newInstance();
//        System.out.println(o1==o2);

//        反序列化
        LazyStaticInnerClassSingleton instance1 = null;
        LazyStaticInnerClassSingleton instance2 = LazyStaticInnerClassSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("LazyStaticInnerClassSingleton.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance2);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("LazyStaticInnerClassSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        instance1 = (LazyStaticInnerClassSingleton) ois.readObject();
        ois.close();

        System.out.println(instance1 == instance2);

    }
}
