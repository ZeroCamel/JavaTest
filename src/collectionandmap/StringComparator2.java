package collectionandmap;

import java.util.Comparator;

/**
 * @program: JavaTest
 * @description: ${泛型简化版本Comparator
 * 外比较器}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-04 23:25
 **/
public class StringComparator2 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return -o1.compareTo(o2);
    }
}
