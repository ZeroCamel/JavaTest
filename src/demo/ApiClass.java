package demo;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${JAVA 提供的标准API操作}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-18 19:42
 **/
public class ApiClass {

    /**
    * @Description: ${java.util.scanner}$
    * @Param: []
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/4/18
    */
    public void guessGame()
    {

        /*一、Math.Random*/
        int maxInt = 5;
        int mulInt = 10;
        for (int number=0;number!=maxInt;number=(int)(Math.random()*mulInt))
        {
            out.println(number);
        }

        /*
         system.in 输入流
         c# console.read()
        */
        Scanner scanner = new Scanner(System.in);
        int number = (int) (Math.random()*mulInt);
        int guess;

        do {
            out.print("猜数字（0-9）：");
            guess = scanner.nextInt();
        } while(guess != number);

        out.println("猜中了... XD");


    }

    /**
    * @Description: ${java.util.bigdecimal 浮点数误差}$
    * @Param: []
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/4/18
    */
    public void decimalInput()
    {
        /*java.util.bigdecimal
         ** 使用分数和指数来表示浮点数 */
        double a = 0.1;
        double b = 0.1;
        double c = 0.1;
        double e = 0.3;
        if ((a+b+c) == e)
        {
            out.println("等于0.3");
        }
        else
        {
            out.println("不等于0.3");
        }

        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("0.1");
        BigDecimal num3 = new BigDecimal("0.1");
        BigDecimal result = new BigDecimal("0.3");
        if (num1.add(num2).add(num3).equals(result))
        {
            out.println("等于0.3");
        }
        else
        {
            out.println("不等于0.3");
        }
    }

    /**
    * @Description: ${字符串常量和字符串池}$
    * @Param: []
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/4/18
    */
    public void stringConst()
    {
        String name1 = "Justin";
        String name2 = "Justin";
        String name3 = new String("Justin");
        String name4 = new String("Justin");
        out.println(name1 == name2);
        out.println(name1 == name3);
        out.println(name3 == name4);

        String strName = "Java";
        // 后台会反编译 string s1 = (new stringbuilder()).append(s).append("world").tostring();
        // 使用+会产生新的字符串
        // stringbuilder 高效 非线程安全 stringbuffer 后台有锁机制 是线程安全的
        String s1 = name1 + "World";
        out.println(s1);

    }

    /**
    * @Description: ${不定长度自变量}$
    * @Param: []
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/4/25
    */
    public void sum(int... numbers)
    {
        // 引用类型变量
        int sum =0;
        for(int number : numbers)
        {
            sum+=number;
        }
        out.println(sum);
    }
}
