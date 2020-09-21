package oceanhappygame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${浅海航行的船}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 16:03
 **/
public class Boat implements Swimmer {

    protected String name;

    public Boat(String name)
    {
        this.name = name;
    }

    @Override
    public void swim() {
        out.printf("船在水面 %s 航行%n",name);
    }
}
