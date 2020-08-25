package DynamicCompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-25 22:32
 **/
public class Demo01 {
    public static void main(String[] args) throws FileNotFoundException {

        String code ="public class test{\n" +
                "    public static void main(String[] args)\n" +
                "    {\n" +
                "        System.out.println(\"Hello,world\");\n" +
                "    }\n" +
                "}";
        try {

            String path = "D:/Code/JavaTest/src/DynamicCompile/testclass/test.java";

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            byte[] bytes = code.getBytes();
            fileOutputStream.write(bytes);

            File file = new File(path);
            if (file.exists())
            {
                // 动态编译
                JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
                int run = systemJavaCompiler.run(null, null, null, path);
                System.out.println(run==0?"success":"fail");

                // 打印输出
                Runtime runtime = Runtime.getRuntime();
                Process process = runtime.exec("java -cp D:/Code/JavaTest/src/DynamicCompile/testclass test");
                InputStream inputStream = process.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String info ="";
                while ((info=bufferedReader.readLine())!=null)
                {
                    System.out.println(info);
                }


            } else {
                System.out.println("写出输出流失败.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
