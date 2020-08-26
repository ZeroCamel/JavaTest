package DynamicCompile;

import com.sun.org.apache.xpath.internal.operations.Mod;
import javassist.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: JavaTest
 * @description: 测试使用JavaAssist
 * @create: 2020-08-26 11:32
 **/
public class JavaAssitDemo2 {
    public static void main(String[] args) throws Exception {
        JavaAssitDemo2.test03();
    }

    /**
     * 获取方法信息
     * @throws Exception
     */
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("DynamicCompile.testClass.Emp");

        byte[] bytes = ctClass.toBytecode();
        System.out.println(Arrays.toString(bytes));

        System.out.println(ctClass.getSimpleName());
        System.out.println(ctClass.getName());
        System.out.println(ctClass.getSuperclass());
        System.out.println(ctClass.getInterfaces());

    }

    /**
     * 反射调用
     * @throws Exception
     */
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("DynamicCompile.testClass.Emp");

        // 创建方法一 方法签名和方法体一并生成
//        CtMethod ctMethod = CtNewMethod.make("public int add(int a,int b){return a+b;}", ctClass);

        // 创建方法二 方法签名和方法体分开生成
        CtMethod add = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, ctClass);
        add.setModifiers(Modifier.PUBLIC);
        // 注意方法体中的参数指定
        add.setBody("{return $1+$2;}");

        ctClass.addMethod(add);

        // 通过反射调用生成新的方法
        Class<?> aClass = ctClass.toClass();
        Object newInstance = aClass.newInstance();
        Method add1 = aClass.getDeclaredMethod("add", int.class, int.class);
        Object invoke = add1.invoke(newInstance, 12, 12);
        System.out.println(invoke.toString());

    }

    /**
     * 修改方法信息
     * @throws Exception
     */
    public static void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("DynamicCompile.testClass.Emp");

        CtMethod sayHello = ctClass.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        // 方法增强
        sayHello.insertBefore("System.out.println($1);");
        sayHello.insertAt(9,"int b=3;System.out.println(b);");
        sayHello.insertAfter("System.out.println(\"end\");");

        // 通过反射调用生成新的方法
        Class<?> aClass = ctClass.toClass();
        Object newInstance = aClass.newInstance();
        Method add1 = aClass.getDeclaredMethod("sayHello", int.class);
        Object invoke = add1.invoke(newInstance, 12);
        System.out.println(invoke);

    }

    /**
     * 属性获取方法
     */
    public static void test04() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("DynamicCompile.testClass.Emp");

        CtField salary = new CtField(CtClass.intType, "salary", ctClass);
        salary.setModifiers(Modifier.PRIVATE);
        ctClass.addField(salary);

        ctClass.addMethod(CtNewMethod.getter("getSalary",salary));
        ctClass.addMethod(CtNewMethod.setter("setSalary",salary));

    }

    /**
     * 构造方法
     */
    public static void test05() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("DynamicCompile.testClass.Emp");

        CtConstructor[] constructors = ctClass.getConstructors();
        for (CtConstructor ct:constructors)
        {
            System.out.println(ct.getLongName());
        }

    }

    /**
     * 注解操作
     */



}
