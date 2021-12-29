package designpattern;

import designpattern.create.singlepattern.EnumSingleton;

import java.io.*;

/**
 * @program: JavaTest
 * @description: ${枚举测试类}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 22:45
 **/
public class EnumSingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化
        EnumSingleton instance1 = null;
        EnumSingleton instance2 = EnumSingleton.getInstance();
        instance2.setData(new Object());

        FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance2);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("EnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        instance1 = (EnumSingleton) ois.readObject();
        ois.close();

        System.out.println(instance1.getData());
        System.out.println(instance2.getData());
        System.out.println(instance1 == instance2);

        // 反射
//        Class aClass = EnumSingleton.class;
//        Constructor c = null;
//        try {
//            c = aClass.getDeclaredConstructor();
//            c.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 反射2
//        Class aClass = EnumSingleton.class;
//        Constructor c = null;
//        try {
//            c = aClass.getDeclaredConstructor(String.class,int.class);
//            c.setAccessible(true);
//            c.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        // Runtime

    }
}
