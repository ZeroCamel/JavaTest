package inheritandpoly;

/**
 * @program: JavaTest
 * @description: 嵌套类 内部类 静态内部类
 * 内部类分为成员内部类、局部内部类 匿名内部类
 * @author: zeroCamel
 * @create: 2020-10-10 15:49
 **/
public class Outer {
    private int size;

    /**
     *  1、内部类可以直接访问外部类的属性和方法
     */
    public class Inner{
        public void doStuff(){
            size++;
            testInner();
        }
    }

    public static class Inner1{
        public void doStuff1()
        {
            System.out.println("静态内部类...");
        }
    }


    public void testInner()
    {
        Inner inner = new Inner();
        inner.doStuff();


    }
}
