package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @program: JavaTest
 * @description: ${文件操作类}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-04 14:26
 **/
public class FileUtil {

    public static String readFile(String name) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();
        // JDK7之后自当尝试关闭资源 try with resources
        try(Scanner scanner = new Scanner(new FileInputStream(name)))
        {
            while(scanner.hasNext())
            {
                builder.append(scanner.nextLine());
                builder.append("\n");
            }
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return builder.toString();
    }

}
