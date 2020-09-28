package basetype;

import java.util.LinkedList;

/**
 * @program: JavaTest
 * @description: ${整型}
 * @author: Mr.ZeroCamel
 * @create: 2020-09-15 07:56
 **/
public class IntegerType {
    public static void main(String[] args) {
        Integer int1 = 3;
        int int2 = 3;
        Integer int3 = new Integer(3);
        Integer int4 = Integer.valueOf(3);

        // true
        System.out.println(int1 == int2);
        // false
        System.out.println(int1 == int3);
        // true
        System.out.println(int1 == int4);
        // true
        System.out.println(int2 == int3);
        // true
        System.out.println(int2 ==int4);
        // false
        System.out.println(int3 == int4);
        // true
        System.out.println(int1.equals(int2));

        LinkedList<String> objects = new LinkedList<>();
        objects.add("111");
        objects.add(1,"2222");
        System.out.println(objects.get(0));

    }

}
