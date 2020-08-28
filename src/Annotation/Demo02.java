package Annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: JavaTest
 * @description: 利用反射，获取类的信息
 * @author: zeroCamel
 * @create: 2020-08-25 16:08
 **/
@SuppressWarnings("all")
public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 获取Class 1 副本 引用
        Class<?> aClass = Class.forName("Annotation.Student");

        // 获取-公共属性信息
        Field[] fields = aClass.getFields();
        // 获取-所有的属性 包含公共的、私有的、受保护的
        Field[] declaredFields = aClass.getDeclaredFields();

        // 获取方法信息
        Method[] methods = aClass.getMethods();
        aClass.getDeclaredMethod("getStudentName",null);
        Method setId = aClass.getDeclaredMethod("setId", Integer.class);

        // 获取构造器
        Constructor<?>[] constructors = aClass.getConstructors();
        aClass.getConstructor(Integer.class,String.class,Integer.class);


        System.out.println(fields.length);
    }
}
