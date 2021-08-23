package basetype;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-09-28 15:25
 **/
public class TestHashSet {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("aa");
        hashSet.add("bb");
        hashSet.add("cc");
        hashSet.add("aa");
        System.out.println(hashSet);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String transformDate=simpleDateFormat.format(new Date());
        System.out.println(transformDate);

        while (true)
        {
            break;
        }
    }
}
