package iInheritandpoly;

/**
 * @program: JavaTest
 * @description: ${角色}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-25 23:23
 **/
public abstract class BaseRole {
    // 语法细节 成员属性
    // 1、private 当前类所属 子类只能通过父类方法存取
    // 2、protected 相同包中的类可以直接存取
    protected String name;
    private int level;
    private int blood;

    public int getBlood()
    {
        return blood;
    }

    public void setBlood(int blood)
    {
        this.blood = blood;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    /**
    * @Description: ${
     * polymorphism 部署相同方法 执行不同的内容
     * 1、使用abstract标记强迫或提示子类实现该方法}$
    * @Param: []
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/4/25
    */
    public abstract void fight();

    @Override
    public String toString()
    {
        return String.format("剑士 （%s,%s）", this.name, name);
    }
}
