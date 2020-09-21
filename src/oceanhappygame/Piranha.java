package oceanhappygame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${食人鱼}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 12:14
 **/
public class Piranha extends BaseFish {

    public Piranha(String name) {
        super(name);
    }

    @Override
    public void swim() {
        out.printf("食人鱼 %s 游泳%n",name);
    }
}
