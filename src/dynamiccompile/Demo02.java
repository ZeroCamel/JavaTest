package dynamiccompile;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @program: JavaTest
 * @description: 反射运行已经编译好的类
 * @author: zeroCamel
 * @create: 2020-08-26 09:40
 **/
public class Demo02 {
    public static void main(String[] args)
    {
        File file = new File("src/dynamiccompile/testClass/");
        try {
            URL url = new URL("file:/" + file.getAbsolutePath());
            URL[] urls = new URL[]{url};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class<?> aClass = urlClassLoader.loadClass("test");
            Method main = aClass.getMethod("main", String[].class);
            /**
             * 需要强制转换 可变参数JDK5.0之后才有
             * 如果不加 new String[]{} 会转化为 main(String[] a,String[] b)
             */
            main.invoke(null,(Object) new String[]{});


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
