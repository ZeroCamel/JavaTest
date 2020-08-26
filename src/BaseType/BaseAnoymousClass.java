package BaseType;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 21:40
 **/
public abstract class BaseAnoymousClass implements InterOne {
    /**
     *
     */
    @Override
    public abstract void doSome();

    public void doService()
    {
        out.println("做一些服务");
    }
}
