package demo;

import java.util.Scanner;

/**
 * @program: JavaTest
 * @description: ${JAVA 提供的标准API操作}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-18 19:42
 **/
public class ApiClass {
    public void guessGame()
    {

        /*二、Math.Random*/
        int maxInt = 5;
        int mulInt = 10;
        for (int number=0;number!=maxInt;number=(int)(Math.random()*mulInt))
        {
            System.out.println(number);
        }

        //system.in 输入流
        //c# console.read()
        Scanner scanner = new Scanner(System.in);
        int number = (int) (Math.random()*mulInt);
        int guess;

        do {
            System.out.print("猜数字（0-9）：");
            guess = scanner.nextInt();
        } while(guess != number);

        System.out.println("猜中了... XD");
    }
}
