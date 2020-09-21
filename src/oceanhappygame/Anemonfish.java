package oceanhappygame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${小丑鱼}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 12:08
 **/
public class Anemonfish extends BaseFish {

    public Anemonfish(String name)
    {
        super(name);
    }

    @Override
    public void swim() {
      out.printf("小丑鱼 %s 游泳%n",this.name);
    }
}
