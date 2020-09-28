package inheritandpoly;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-25 23:30
 **/
public class Magician extends BaseRole {
    public void cure()
    {

    }


    @Override
    public String toString() {
        return "剑士" + super.toString();
    }


    @Override
    public void fight()
    {
        out.println("魔法攻击");
    }
}
