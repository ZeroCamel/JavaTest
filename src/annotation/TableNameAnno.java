package annotation;

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
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TableNameAnno {
    // 参数 参数值 默认值
    String value() default "";
}
