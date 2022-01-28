package designpattern.create.singlepattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: JavaTest
 * @description: ${容器式单例 适合大量创建单例的场景}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 23:43
 **/
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<>();
    public static Object getBean(String className)
    {
        synchronized (ioc)
        {
            if (!ioc.containsKey(className))
            {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
