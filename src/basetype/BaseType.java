package basetype;

/**
 * @program: JavaTest
 * @description: ${基本数据类型注意点}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-18 19:37
 **/
public class BaseType {
    /**
    * @Description: ${int byte 互转
     * 正数的原码反码补码都一致
     * 负数的反码是除符号位按位取反
     * 负数的补码是反码加1
     * java中变量存储是按补码保存的
     * }$
    * @Param: []
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/4/18
    */
    public static void dataConvert()
    {
        /*一、JAVA数值运算 原码 反码 补码*/
        /*编译成功 精度损失*/

        byte a = 100;
        byte b = 50;
        byte c = (byte) (a+b);
        System.out.println(c);

        /*C# 编译失败 强制类型转换失败*/
        // sbyte a = 100;
        // sbyte b = 50;
        // sbyte c = Convert.ToSByte(a+b);
        // Console.WriteLine(c);

        int x = 100;
        int y = 120;
        Integer wx = x;
        Integer wy = y;
        System.out.println(x==y);
        // 比较引用对象的实质内容是否相同
        System.out.println(wx.equals(wy));

        String[] strs= new String[5];

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aaa");
        stringBuffer.append("bbb");
        System.out.println(stringBuffer.toString());
    }

    public static void main(String[] args) {
        dataConvert();
    }
}
