package threadandparallel;

/**
 * @program: JavaTest
 * @description: 静态代理-线程实现Runnable接口线程代理实现类
 * @author: zeroCamel
 * @create: 2020-08-19 14:28
 **/
public class StaticProxy {

}

/**
 * 真实接口-服务
 */
interface  Marry{
    public void marry();
}

/**
 * 真实角色-组件
 */
class you implements Marry{
    @Override
    public void marry() {
        System.out.println("i am marry");
    }
}

/**
 * 代理角色 继承服务
 */
class my implements Marry{

    /**
     * 真实角色
     */
    private you you;

    public my(you you) {
        this.you = you;
    }

    /**
     * 代理实现
     */
    @Override
    public void marry() {
        before();
        this.you.marry();
        after();
    }

    /**
     *
     */
    public void before()
    {
        System.out.println("准备...");
    }

    /**
     *
     */
    public void after()
    {
        System.out.println("结束...");
    }

}