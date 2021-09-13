
package jvm.tools;

import java.util.ArrayList;

/**
 * @program: JavaTest
 * @description: ${
 * 内存标签 jstat
 * JVM 参数 -Xms100m -Xmx100M -XX:UseSerialGC
 * }
 * @author: Mr.ZeroCamel
 * @create: 2021-09-13 21:06
 **/
public class JCONSOLE_TestCase {
    static class OOMObject{
        public byte[] placeHolder = new byte[64*1024];
    }
    public static void fillHeap(int num) throws InterruptedException{
        ArrayList<OOMObject> oomObjects = new ArrayList<>();
        for (int i = 0;i<num;i++)
        {
            Thread.sleep(50);
            oomObjects.add(new OOMObject());
        }
        System.gc();
    }
    public static void main(String[] args) throws InterruptedException {
        fillHeap(10000);
    }

}
