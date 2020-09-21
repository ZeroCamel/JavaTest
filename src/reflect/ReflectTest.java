package reflect;

import dynamiccompile.testClass.Emp;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: JavaTest
 * @description: 反射Demo
 * @author: zeroCamel
 * @create: 2020-08-27 16:07
 **/
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Emp emp = new Emp();
        Class<? extends Emp> aClass = emp.getClass();
        Class<Emp> empClass = Emp.class;
        Class<?> aClass1 = Class.forName("dynamiccompile.testClass.Emp");

        // jdk9 使用构造器
        Object o = aClass1.getConstructor().newInstance();
        System.out.println(o);
    }

}
