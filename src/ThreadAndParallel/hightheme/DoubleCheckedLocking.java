package ThreadAndParallel.hightheme;

/**
 * @program: JavaTest
 * @description: ${DCL单例模式--双重校验锁
 * 1、私有构造函数
 * 2、私有静态字段
 * 3、公共静态访问方法
 * }
 * @author: Mr.ZeroCamel
 * @create: 2020-08-22 23:04
 **/
public class DoubleCheckedLocking {

    private volatile static DoubleCheckedLocking doubleCheckedLocking =null;
    private DoubleCheckedLocking()
    {

    }

    public static DoubleCheckedLocking getInstance()
    {
        if (doubleCheckedLocking != null)
        {
            return doubleCheckedLocking;
        }

        synchronized (DoubleCheckedLocking.class)
        {
            // 可能会有网络延时
            if (doubleCheckedLocking == null)
            {
                // 创建对象包含的三个操作-非原子性
                // 1、创建内存空间
                // 2、初始化对象
                // 3、将引用对象地址指向变量
                // 第2步和第三步 非原子性操作 可能导致指令重排
                doubleCheckedLocking = new DoubleCheckedLocking();
            }
            return doubleCheckedLocking;
        }
    }


    public static void main(String[] args)
    {

    }
}
