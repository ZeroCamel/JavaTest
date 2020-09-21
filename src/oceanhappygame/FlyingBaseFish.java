package oceanhappygame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${飞鱼
 * 继承类和操作接口}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 14:30
 **/
public class FlyingBaseFish extends BaseFish implements Flyer {

    public FlyingBaseFish(String name) {
        super(name);
    }

    @Override
    public void fly() {
        out.println("飞鱼会飞");
    }

    @Override
    public void swim() {
        out.println("飞鱼游泳");
    }
}
