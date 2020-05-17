package Stream;

import java.io.*;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-10 16:27
 **/
public class IO {
    public static void dump(InputStream src, OutputStream dest) throws IOException {
        try(InputStream input = src;OutputStream output = dest) {
            byte[] data = new byte[1024];
            int length = -1;
            while((length = input.read(data))!=1)
            {
                output.write(data, 0, length);
            }
        }
    }

    public static void dumpBuffer(InputStream src, OutputStream dest) throws IOException {
        try (InputStream input = new BufferedInputStream(src);
             OutputStream output = new BufferedOutputStream(dest)){
            byte[] data = new byte[1024];
            int length =-1;
            while ((length = input.read(data)) !=-1) {
                output.write(data, 0, length);
            }

        }
    }

}
