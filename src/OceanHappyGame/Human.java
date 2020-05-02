package OceanHappyGame;

/**
 * @program: JavaTest
 * @description: ${
 * 1、The Human isn't a fish
 * 2、默认操作游泳接口 但是并不是所有人都会游泳 有局限性}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 13:38
 **/
public class Human {
    private String name;

    public Human(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

//    @Override
//    public void swim() {
//        out.printf("人类 %s 游泳%n",name);
//    }

}
