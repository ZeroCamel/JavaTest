package BaseType;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 11:21
 **/
public class Other extends Some {
    public Other()
    {
      super(10);
      out.println("Other()");
    }
    public Other(int y)
    {
        out.println("Other(int y)");
    }
}
