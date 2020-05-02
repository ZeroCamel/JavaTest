package OceanHappyGame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${鲨鱼}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 12:11
 **/
public class Shark extends BaseFish {

    public Shark(String name)
    {
        super(name);
    }

    @Override
    public void swim() {
        out.printf("鲨鱼 %s 游泳%n",name);
    }

}
