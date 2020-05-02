package OceanHappyGame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${潜水艇
 * 1、属于一种船}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 13:44
 **/
public class Submarine extends Boat implements Swimmer {

//    private String name;
//
//    public Submarine(String name)
//    {
//        this.name = name;
//    }

    public Submarine(String name) {
        super(name);
    }


    @Override
    public void swim() {
        out.printf("潜水艇 %s 游泳%n",name);
    }
}
