package jvm.engine;

/**
 * @program: JavaTest
 * @description: ${字段没有多态性}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-08 22:55
 **/
public class FieldHasNotPolymorphic {
    static class Father{
        public int money = 1;
        public Father()
        {
            money = 2;
            showMeTheMoney();
        }
        public void showMeTheMoney()
        {
            System.out.println("I am father, i hava $"+money);
        }
    }

    static class Son extends Father{
        public int money = 3;
        public Son()
        {
            money = 4;
            showMeTheMoney();
        }

        @Override
        public void showMeTheMoney()
        {
            System.out.println("I am Son, i hava $"+money);
        }
    }

    public static void main(String[] args) {
        Father son = new Son();
        System.out.println("This guy has $"+son.money);
    }
}
