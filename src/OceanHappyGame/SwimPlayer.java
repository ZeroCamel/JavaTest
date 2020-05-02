package OceanHappyGame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${游泳选手}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 15:17
 **/
public class SwimPlayer extends Human implements Swimmer {
    public SwimPlayer(String name) {
        super(name);
    }

    @Override
    public void swim() {
        out.printf("游泳选手 %s 游泳%n",this.getName());
    }
}
