package basetype;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 21:29
 **/
public class SomeOtherImpl implements InterOne,InterTwo {
    @Override
    public void doSome() {
        out.println("做一些事");
    }

    @Override
    public void doOther() {
        out.println("做其他事");
    }
}
