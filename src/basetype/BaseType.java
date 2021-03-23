package basetype;

import javax.print.DocFlavor;

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
    public static void dataConvert() {
        /*一、JAVA数值运算 原码 反码 补码*/
        /*编译成功 精度损失*/

        byte a = 100;
        byte b = 50;
        byte c = (byte) (a + b);
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
        System.out.println(x == y);
        // 比较引用对象的实质内容是否相同
        System.out.println(wx.equals(wy));

        String[] strs = new String[5];

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aaa");
        stringBuffer.append("bbb");
        System.out.println(stringBuffer.toString());

    }

    public static void str()
    {
        String str1 = "计算机";
        String str2 = "计算机";
        System.out.println("str1==str2:" + (str1 == str2));

        String str3 = new String("计算机");
        System.out.println("str1==str3:" + (str1 == str3));
        System.out.println("str1==str3.intern():" + (str1 == str3.intern()));
        System.out.println("str2==str3.intern():" + (str2 == str3.intern()));

        String str4 = new String("计算机");
        System.out.println("str3==str4:" + (str3 == str4));
        System.out.println("str3.intern()==str4.intern():" + (str3.intern() == str4.intern()));


        String str5 = new StringBuilder("软件").append("工程").toString();
        System.out.println("str5.intern() == str5:" + (str5.intern() == str5));

        String str6 = new String(new StringBuilder("物联网").append("工程").toString());
        System.out.println("str6.intern() == str6:" + (str6.intern() == str6));

        String str7 = new String("物联网");
        System.out.println("str7.intern() == str7:" + (str7.intern() == str7));

    }

    public static void str1()
    {
        String s = new String("1");

        s.intern();

        String s2 = "1";

        System.out.println(s == s2);


        String s3 = new String("1") + new String("1");

        s3.intern();

        String s4 = "11";

        System.out.println(s3 == s4);
    }

    public static void str2()
    {
        String s2 = new String("abc");
        String s1 = "abc";
        String s3 = s2.intern();

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
    }

    public static  void str3()
    {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);


        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();


        System.out.println(s3 == s4);
    }

    public  static  void str4()
    {
        String s = new String("hhh");
        char c = s.charAt(1);
        System.out.println(c);

        int hhc = s.compareTo("hhc");
        System.out.println(hhc);



    }

    public static void main(String[] args) {
        str4();
    }
}
