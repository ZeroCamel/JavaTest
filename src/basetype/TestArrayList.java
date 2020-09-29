package basetype;

import java.util.ArrayList;

/**
 * @program: JavaTest
 * @description: 测试List方法
 * @author: zeroCamel
 * @create: 2020-09-29 09:14
 **/
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        System.out.println(objects.size());

        objects.add("1");
        objects.add("2");
        objects.add("3");
        objects.add("4");
        objects.add("bb");
        objects.add("cc");
        objects.add("bb");
        objects.toArray();

        objects.set(2,"tt");
        System.out.println(objects);
        objects.add(2,"ttt");
        System.out.println(objects);

        System.out.println(objects.get(2));
        System.out.println(objects.indexOf("tt"));
        System.out.println(objects.lastIndexOf("bb"));

        ArrayList<String> objects1 = new ArrayList<>();
        objects1.add("1");
        objects1.add("2");
        objects1.add("3");
        objects1.add("7");
        objects1.add("8");

        objects.addAll(objects1);
        System.out.println(objects);
        objects.removeAll(objects1);
        System.out.println(objects);
        objects.retainAll(objects1);
        System.out.println(objects);


    }
}
