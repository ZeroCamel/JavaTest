package designpattern;

/**
 * @program: JavaTest
 * @description: 单例模式-一共有8种
 *
 * @author: zeroCamel
 * @create: 2020-10-13 09:50
 **/
public class SingleDemo {
    /**
     * volatile 关键词防止指令重排 保证线程的可见性 将缓存中的变化即时刷新到主存
     * 使得其他内存失效 必须从主存获取 避免重复创建实例
     */
    private static volatile SingleDemo singleDemo = null;

    /**
     * 构造器私有 不然直接NEW可以创建
     */
    private SingleDemo()
    {

    }

    /**
     * 静态方法实例 通过类点可以直接调用
     * @return
     */
    public static SingleDemo getInstance()
    {
        /**
         * 多线程竞争第一重判断 多个线程 如果为空 不需要尝试获取锁 避免锁的升级开销
         */
        if (null == singleDemo)
        {
            /**
             * 临界代码区域
             */
            synchronized (SingleDemo.class)
            {
                /**
                 * 多线程竞争第二重判断 假设两个线程同时通过第一个IF A线程获取锁之后 判断实例变量为空 创建了实例
                 * 执行完毕释放了锁 B获取锁之后 如果没有判断 会再次创建实例
                 */
                if (null == singleDemo)
                {
                    /**
                     * 实例化非原子性 需要三步
                     * 1、开辟内存分配给这个对象
                     * 2、初始化对象
                     * 3、将内存地址分配给内存中的变量值
                     *
                     * 第2步 第3步 重排序 可能会导致线程返回没有初始化的内存
                     */
                    singleDemo = new SingleDemo();
                }
            }
        }
        return singleDemo;
    }
}
