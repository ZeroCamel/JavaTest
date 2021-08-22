package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2021-01-28 23:21
 **/
public class MemoryDemo {
    public static void main(String[] args) {
        List<demo> lst = new ArrayList<>();
        while (true)
        {
            lst.add(new demo());
        }

    }
}
class demo{

}