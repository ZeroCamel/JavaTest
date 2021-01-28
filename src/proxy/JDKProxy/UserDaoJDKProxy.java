package proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: JavaTest
 * @description: ${创建代理对象}
 * @author: Mr.ZeroCamel
 * @create: 2020-10-12 20:38
 **/
public class UserDaoJDKProxy implements InvocationHandler {
    /**
     * 通过有参构造器传递代理对象
     */
    private Object object;
    public UserDaoJDKProxy(Object object)
    {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象方法执行："+method.getName()+";参数:"+ Arrays.toString(args));

        Object res = method.invoke(object, args);

        System.out.println("代理方法执行之后...");
        return res;
    }
}
