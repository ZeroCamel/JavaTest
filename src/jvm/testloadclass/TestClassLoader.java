package jvm.testloadclass;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: JavaTest
 * @description: 类与类加载器
 * 1 对于任意一个类，都必须有加载它的类加载器和这个类本身一起共同确定其在java虚拟机中的唯一性，
 *   每一个类加载器都有一个独立的类名称空间
 * @author: zeroCamel
 * @create: 2020-08-27 11:12
 **/
public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("hello,word");

        ClassLoader myloader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
                    if (resourceAsStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[resourceAsStream.available()];
                    resourceAsStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object newInstance = myloader.loadClass("jvm.testloadclass.TestClassLoader").newInstance();
        System.out.println(newInstance.getClass());
        System.out.println(newInstance instanceof jvm.testloadclass.TestClassLoader);

    }
}
