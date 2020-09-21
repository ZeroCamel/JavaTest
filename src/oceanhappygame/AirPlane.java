package oceanhappygame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 15:24
 **/
public class AirPlane implements Flyer {

    protected String name;
    public AirPlane(String name)
    {
        this.name = name;
    }

    @Override
    public void fly() {
        out.printf("飞机 %s 在飞%n",name);
    }
}
