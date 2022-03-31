package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 演示Repeatable注解
 * </p>
 *
 * @package: annotation
 * @description: 演示Repeatable注解
 * @author: zjf
 * @date: Created in 2022/3/31 9:52
 * @copyright: Copyright (c)2022
 * @version: V1.0
 * @modified: zjf
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Persons {
    Person[] value();
}
