package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: JavaTest
 * @description: ${自定义注解}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-24 22:40
 **/
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    // 参数 参数值 默认值
    String studentName() default "";
    int age() default 0;
    int id() default -1;
    String[] schools() default {};
}
