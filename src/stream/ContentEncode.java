package stream;


import java.io.UnsupportedEncodingException;

/**
 * @program: JavaTest
 * @description: 内容编码（字符串-字节）解码（字节-字符串）
 * @author: zeroCamel
 * @create: 2020-08-17 11:03
 **/
public class ContentEncode {

    public static void test01()
    {
        String msg="性命生命使命a";
        // 默认使用工程的字符集
        byte[] bytes = msg.getBytes();
        System.out.println(bytes.length);
        System.out.println(bytes);

        try {
            // 英文1 中文 2
            byte[] gbks = msg.getBytes("gbk");
            System.out.println(gbks.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            // 中英文 2
            byte[] bytes1 = msg.getBytes("utf-16le");
            System.out.println(bytes1.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 解码
        try {
            String string = new String(bytes, 0, bytes.length, "utf-8");
            System.out.println(string);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        /**
         * 乱码
         * 1、字节数不够
         * 2、字符集不统一
         */
        try {
            String string = new String(bytes, 0, bytes.length-2, "utf-8");
            System.out.println(string);

            String string1 = new String(bytes, 0, bytes.length, "gbk");
            System.out.println(string1);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
