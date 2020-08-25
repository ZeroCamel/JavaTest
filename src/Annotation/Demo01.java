package Annotation;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-24 22:44
 **/
public class Demo01 {
    public static void main(String[] args)
    {
        try {

            // 获取Class 1 副本 引用
            Class<?> aClass = Class.forName("Annotation.Student");

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

            // 获取Class
            Class<String> stringClass = String.class;
            String path = "Annotation.Student";
            System.out.println(stringClass == path.getClass());




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
