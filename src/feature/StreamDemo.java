package feature;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-09-22 21:57
 **/
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;i<100;i++)
        {
            arrayList.add(i);
        }

        System.out.println(arrayList.size());

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList.parallelStream().forEach(e->{
            arrayList1.add(e);
        });
        System.out.println(arrayList1.size());
        Collections.sort(arrayList1);
        for (Integer int1:arrayList1
                ) {
            System.out.println(int1);
        }

        StringBuilder stringBuilder = new StringBuilder();
    }
}
