package OceanHappyGame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${
 * 海上飞机
 * 1、有的飞机只会飞 需设计AirPlan}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 14:24
 **/
public class SeaPlane extends AirPlane implements Swimmer {

    public SeaPlane(String name) {
        super(name);
    }

//    public String name;
//
//    public SeaPlane(String name)
//    {
//        this.name = name;
//    }

    @Override
    public void fly() {
        out.println("海上");
        super.fly();
    }

    @Override
    public void swim() {
        out.printf("海上飞机 %s 在游泳%n",name);
    }
}
