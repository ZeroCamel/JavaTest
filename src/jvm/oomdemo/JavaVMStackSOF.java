package jvm.oomdemo;

/**
 * @program: JavaTest
 * @description: ${虚拟机栈和本地方法栈测试}
 * 对于不同版本的JAVA虚拟机和不同的操作平台
 * 栈容量最小值可能会有所限制 取决于操作系统内存分页的大小
 * 32 windows JDK6 128K 1595
 * 64 windows JDK11 180K
 * Linux 228k
 * @author: Mr.ZeroCamel
 * @create: 2021-08-22 10:06
 **/
public class JavaVMStackSOF {
    private int stackLength = 1;

    /**
     * 递归调用
     */
    public void stackLeak()
    {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try{
            javaVMStackSOF.stackLeak();
        } catch (Throwable e)
        {
            System.out.println("stack length:"+javaVMStackSOF.stackLength);
            throw e;
        }

    }
}
