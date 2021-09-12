package jvm.tools;


/**
 * @program: JavaTest
 * @description: ${JHSDB工具测试
 * 执行命令参数 -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 * 1 jps -lv
 * 2 java -cp .\sa-jdi.jar sun.jvm.hotspot.HSDB
 * }
 * @author: Mr.ZeroCamel
 * @create: 2021-09-12 22:15
 **/
public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceHolder = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder{}

    public static void main(String[] args) {
       Test test1 = new Test();
       test1.foo();
    }
}
