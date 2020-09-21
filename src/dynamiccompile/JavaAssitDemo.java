package dynamiccompile;

import javassist.*;

/**
 * @program: JavaTest
 * @description: 测试使用JavaAssist
 * It is a class library for editing bytecodes in Java;
 * it enables Java programs to define a new class at runtime and to modify a class file
 * when the JVM loads it. Unlike other similar bytecode editors,
 * Javassist provides two levels of API: source level and bytecode level.
 * If the users use the source-level API, they can edit a class file without knowledge of the specifications of the Java bytecode.
 * The whole API is designed with only the vocabulary of the Java language.
 * You can even specify inserted bytecode in the form of source text; Javassist compiles it on the fly.
 * On the other hand, the bytecode-level API allows the users to directly edit a class file as other editors.
 * @author: zeroCamel
 * @create: 2020-08-26 11:32
 **/
public class JavaAssitDemo {
    public static void main(String[] args) throws Exception {
        // CtClass compile runtime
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("Emp");

        // 创建属性 法一
        CtField ctField = CtField.make("private int empno;", ctClass);
        CtField ctField1 = CtField.make("private String ename;", ctClass);
        // 创建属性 法二
        CtField ctField2 = new CtField(CtClass.intType, "empno", ctClass);
        ctField2.setModifiers(Modifier.PRIVATE);

        ctClass.addField(ctField2);
        ctClass.addField(ctField);
        ctClass.addField(ctField1);

        // 创建方法
        CtMethod ctMethod = CtMethod.make("public int getEmpno(){return empno;}", ctClass);
        CtMethod ctMethod1 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", ctClass);

//        CtMethod add = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, ctClass);
//        ctClass.addMethod(CtNewMethod.getter("getSalary",ctField));

        ctClass.addMethod(ctMethod);
        ctClass.addMethod(ctMethod1);

        // 创建构造器
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{CtClass.intType, classPool.get("java.lang.String")}, ctClass);
        ctConstructor.setBody("{this.empno=empno;this.ename=ename;}");
        ctClass.addConstructor(ctConstructor);

        ctClass.writeFile("src/dynamiccompile");

    }
}
