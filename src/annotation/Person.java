package annotation;

import java.lang.annotation.Repeatable;

/**
 * <p>
 * 演示Repeatable注解
 * </p>
 *
 * @package: annotation
 * @description: 演示Repeatable注解
 * @author: zjf
 * @date: Created in 2022/3/31 9:54
 * @copyright: Copyright (c)2022
 * @version: V1.0
 * @modified: zjf
 **/
@Repeatable(Persons.class)
public @interface Person {
    String role() default "";
}
