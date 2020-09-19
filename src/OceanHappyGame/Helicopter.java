package OceanHappyGame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${直升飞机}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 15:35
 **/
public class Helicopter extends AirPlane {

    public Helicopter(String name) {
        super(name);
    }

    @Override
    public void fly()
    {
        out.printf("飞机 %s 在飞%n",name);
    }
}
