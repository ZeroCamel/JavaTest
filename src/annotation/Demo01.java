package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: JavaTest
 * @description: ${利用反射获取注解}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-24 22:44
 **/
public class Demo01 {
    public static void main(String[] args)
    {
        try {

            // 获取Class 1 方法一
            Class<?> aClass = Class.forName("annotation.Student");

            // 获取类名
            String name = aClass.getName();
            System.out.println(name);
            System.out.println(aClass.hashCode());


            // 获取注解
            Annotation[] annotations = aClass.getAnnotations();
            for (Annotation a:annotations)
            {
                System.out.println(a);

                // 取得注解的值
                TableNameAnno a1 = (TableNameAnno) a;
                System.out.println(a1.value());
            }

            // 获得属性的值
            try {
                Field studentName = aClass.getDeclaredField("studentName");
                Annotation[] nameAnnotations = studentName.getAnnotations();
                for (Annotation a : nameAnnotations)
                {
                    System.out.println(a);
                }

                TableFieldAnno fieldAnno = studentName.getAnnotation(TableFieldAnno.class);
                System.out.println(fieldAnno.columnName()+"--"+fieldAnno.type()+"--"+fieldAnno.length());

                // 获取类加载器
                ClassLoader classLoader = aClass.getClassLoader();
                System.out.println(classLoader);


            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            // 获取Class 方法二
            Class<String> stringClass = String.class;
            String path = "annotation.Student";
            System.out.println(stringClass == path.getClass());

            // 获取方法的注解
            Method setAge = aClass.getMethod("setAge", int.class);
            MyAnnotation annotation = setAge.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.age()+"--"+annotation.id()+"--"+annotation.schools()+"--"+annotation.studentName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
