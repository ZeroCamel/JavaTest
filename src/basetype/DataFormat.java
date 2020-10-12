package basetype;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-10-10 14:36
 **/
public class DataFormat {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
    }
}
