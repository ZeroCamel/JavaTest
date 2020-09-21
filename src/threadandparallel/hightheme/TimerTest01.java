package threadandparallel.hightheme;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-21 21:16
 **/
public class TimerTest01 {
    public static void main(String[] args)
    {
        Timer timer = new Timer();
//        // 执行一次
//        timer.schedule(new MyTimer(),1000);
//        // 执行多次
//        timer.schedule(new MyTimer(),1000, 500);
        // 指定时间
        Calendar calendar = new GregorianCalendar(2099,12,31,21,00);
        timer.schedule(new MyTimer(),calendar.getTime(),200);

    }
}
class MyTimer extends TimerTask
{
    @Override
    public void run() {
        for (int i =0;i<12;i++)
        {
            System.out.println("凌晨6点叫醒我...");
        }
        System.out.println("end....");
    }
}