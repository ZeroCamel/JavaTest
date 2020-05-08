package CollectionAndMap;

import java.util.Comparator;

/**
 * @program: JavaTest
 * @description: ${操作Comparator 排序结果取反}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-04 23:13
 **/
public class StringComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        String str1 = (String)o1;
        String str2 = (String)o2;

        return -str1.compareTo(str2);
    }
}
