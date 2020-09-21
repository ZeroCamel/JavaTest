package oceanhappygame;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 11:34
 **/
public abstract class BaseFish implements Swimmer{

    protected String name;

    public BaseFish(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return  name;
    }

    /**
     *
     */
    @Override
    public abstract void swim();
}
