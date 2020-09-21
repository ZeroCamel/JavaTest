package oceanhappygame;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${
 * 游泳这个行为可以被任何东西拥有，
 * 而不是某种东西专属
 * 1、游泳又分为两大类 深海潜行 浅海游泳
 * 方案
 * 1、可以重新定义接口继承此接口
 * 2、也可以增加默认实现}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 13:31
 **/
public interface Swimmer {
    public abstract void swim();


    /**
     * 默认实现
     */
    default void newFunction()
    {
        out.println("新的游泳方式");
    }
}
