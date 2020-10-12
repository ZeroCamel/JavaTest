package inheritandpoly;

/**
 * @program: JavaTest
 * @description: 创建对象时构造器的调用顺序是：先初始化静态成员 然后调用父类构造器 再初始化非静态成员
 * @author: zeroCamel
 * @create: 2020-10-10 14:29
 **/
public class ExecuteResult {

    public static void main(String[] args) {
        A a = new B();
        a = new B();
    }

}
class  A{
    static {
        System.out.println("1");
    }

    public A()
    {
        System.out.println("2");
    }
}
class B extends A{
    static {
        System.out.println("a");
    }

    public B()
    {
        System.out.println("b");
    }
}