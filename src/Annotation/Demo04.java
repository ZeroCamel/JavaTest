package Annotation;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @program: JavaTest
 * @description: ${Java泛型反射}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-25 21:46
 **/
public class Demo04 {

    public void test01(Map<String,Student> map, List<Student> list)
    {
        System.out.println("Demo04.test01()");
    }

    public Map<Integer,Student> test02()
    {
        System.out.println("Demo04.test02()");
        return null;
    }

    public static void main(String[] args)
    {
        try {
            // 获得指定方法参数信息
            Method test01 = Demo04.class.getMethod("test01", Map.class, List.class);
            Type[] types = test01.getGenericParameterTypes();
            for (Type type:types)
            {
                System.out.println("#"+type);
                if (type instanceof ParameterizedType)
                {
                    Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                    for (Type type1:actualTypeArguments)
                    {
                        System.out.println("泛型类型"+type1);
                    }
                }
            }

            // 获得指定方法返回值类型
            Method test02 = Demo04.class.getMethod("test02", null);
            Type genericReturnType = test02.getGenericReturnType();
            if (genericReturnType instanceof ParameterizedType)
            {
                Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
                for (Type type:actualTypeArguments)
                {
                    System.out.println("返回值，返回类型："+type);
                }
            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
