package threadandparallel.connectionpool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaTest
 * @description: ${数据库底层连接驱动 动态代理 构造一个Conection}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-11 12:06
 **/
public class ConnectionDriver {
    static class ConnectionHandle implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    /**
     * 创建一个Connection的代理，在commit时休眠100毫秒
     *
     * @return
     */
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class<?>[]{Connection.class},
                new ConnectionHandle());
    }
}
