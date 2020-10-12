package inheritandpoly;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-10-10 16:12
 **/
public class TestInnerClass {
    public static void main(String[] args) {

    }
}
class Person{

    String name = "韩梅梅";
    int age;

    /**
     * 成员内部类
     */
    class Bird{
        String name = "黄鹂";
        int id;
        public Bird()
        {

        }

        public void setName(String name)
        {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }

        public void info()
        {
            show();
        }
    }

    /**
     * 静态成员内部类
     */
    static class Dog{

    }

    public void show()
    {
        System.out.println("我是show()方法");
    }

    public void method1(){
        /**
         * 局部内部类
         */
        class A{


        }
    }

}
