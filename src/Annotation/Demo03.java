package Annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: JavaTest
 * @description: 反射动态操作
 * @author: zeroCamel
 * @create: 2020-08-25 16:27
 **/
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获取Class 默认动态调用无参构造初始化
        Class<?> aClass = Class.forName("Annotation.Student");
        Object o = aClass.newInstance();
        System.out.println(o);

        // 构造器初始化 可以动态调用指定构造函数初始化
        Constructor constructor = aClass.getConstructor(Integer.class, String.class, Integer.class);
        Student newInstance = (Student) constructor.newInstance(1001, "zhangsan", 11);
        System.out.println(newInstance.getStudentName());

        // 动态调用普通方法
        Method setId = aClass.getDeclaredMethod("setId", Integer.class);
        // 如果是静态方法 第一个参数可以为null
        setId.invoke(newInstance,111);
        System.out.println(newInstance.getId());

        // 动态操作属性
        Field declaredField = aClass.getDeclaredField("studentName");
        // 禁止代码安全检查 忽略private属性
        declaredField.setAccessible(true);
        declaredField.set(newInstance,"李思淼");
        declaredField.get(newInstance);
        System.out.println(newInstance.getStudentName());

    }

}
