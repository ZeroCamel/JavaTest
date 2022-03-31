package annotation;

import java.lang.annotation.Annotation;

/**
 * <p>
 * Repeatable注解使用
 * </p>
 *
 * @package: annotation
 * @description: Repeatable注解使用
 * @author: zjf
 * @date: Created in 2022/3/31 9:57
 * @copyright: Copyright (c)2022
 * @version: V1.0
 * @modified: zjf
 **/
@Person(role = "father")
@Person(role = "son")
public class Man {
    String name;

    public static void main(String[] args) {
        Annotation[] annotations = Man.class.getAnnotations();
        System.out.println(annotations.length);
        Persons p1 = (Persons) annotations[0];
        for (Person p : p1.value()) {
            System.out.println(p.role());
        }
    }
}
