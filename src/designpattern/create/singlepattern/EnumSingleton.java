package designpattern.create.singlepattern;

/**
 * @program: JavaTest
 * @description: ${枚举单例 饿汉式单例实现 不可以用反射来创建枚举类型}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-17 22:14
 **/
public enum EnumSingleton {
    INSTANCE;
    private Object data;
    public Object getData(){
        return data;
    }
    public void setData(){
        this.data = data;
    }
    public static EnumSingleton getInstance()
    {
        return INSTANCE;
    }
}
