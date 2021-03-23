package basetype;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
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

        DataFormat.LocalDateFormat();

    }

    public static void LocalDateFormat()
    {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        int monthValue = now.getMonthValue();
        System.out.println(monthValue);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfYear = now.getDayOfYear();
        System.out.println(dayOfYear);
        LocalDate localDate = now.minusDays(-1);
        System.out.println(localDate);
        LocalDate localDate1 = now.plusDays(-12);
        System.out.println(localDate1);
    }
}
