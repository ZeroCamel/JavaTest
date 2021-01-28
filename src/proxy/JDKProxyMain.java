package proxy;

import proxy.JDKProxy.UserDao;
import proxy.JDKProxy.UserDaoImpl;
import proxy.JDKProxy.UserDaoJDKProxy;

import java.lang.reflect.Proxy;

/**
 * @program: JavaTest
 * @description: ${JDK动态代理}
 * @author: Mr.ZeroCamel
 * @create: 2020-10-12 20:34
 **/
public class JDKProxyMain {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};

        UserDao userDao = new UserDaoImpl();
        UserDao instance =(UserDao)Proxy.newProxyInstance(JDKProxyMain.class.getClassLoader(), interfaces, new UserDaoJDKProxy(userDao));
        int add = instance.add(1, 2);
        System.out.println(add);
    }
}
