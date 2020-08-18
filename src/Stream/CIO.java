package Stream;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @program: JavaTest
 * @description: ${Commons.IO
 * Commons IO is a library of utilities to assist with developing IO functionality.
 * }
 * @author: Mr.ZeroCamel
 * @create: 2020-08-18 22:49
 **/
public class CIO {

    private static final String PRE_PATH="src/Stream/file";

    public static void CIO_TEST01()
    {
        File file = new File(PRE_PATH + "/1.txt");
        long sizeOf = FileUtils.sizeOf(file);
        System.out.println((int)sizeOf);
    }
}
