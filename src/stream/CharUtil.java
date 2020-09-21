package stream;

import java.io.*;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-17 14:40
 **/
public class CharUtil {
    public static void dump(Reader src, Writer dest) throws IOException{
        try(Reader input =src;Writer output = dest) {
            char[] data = new char[1024];
            int length=0;
            while ((length=input.read(data))!=-1)
            {
                output.write(data,0,length);
            }
        }
    }

    /**
    * @Description: ${使用字符处理装饰器对串流字节数据进行打包处理}$
    * @Param: [src, dest, charset]
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/5/17
    */
    public static void dump1(InputStream src, OutputStream dest,String charset) throws IOException {
        dump(
                new InputStreamReader(src,charset),
                new OutputStreamWriter(dest,charset)
        );
    }

    public static void dump(InputStream src, OutputStream dest, String property) {
        dump(src,dest,System.getProperty("file.encoding"));
    }
}
