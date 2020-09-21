package basetype;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${构造函数 this 的执行语义}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-25 18:55
 **/
public class Some {
    public int x;

    public Some next;

    public Some()
    {
        this(10);
        out.println("Some()");
    }

    public Some(int x)
    {
        //x = x;
        this.x = x;
        out.println("Some(int x)");
    }

    String ToString()
    {
        return "some instance";
    }

    @Override
    public int hashCode()
    {
        return 0;
    }
}
