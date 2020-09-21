package dynamiccompile;

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

        String code = "public class test{\n" +
                "    public static void main(String[] args)\n" +
                "    {\n" +
                "        System.out.println(\"Hello,world\");\n" +
                "    }\n" +
                "}";
        try {

            String path = "src/dynamiccompile/testClass/test.java";
            File file = new File(path);
            if (!file.exists())
            {
                // 绝对路径
                System.out.println(file.getAbsoluteFile());
                // 相对路径
                System.out.println(file.getPath());
                // 父目录
                System.out.println(file.getParent());
                // 当前应用路径
                System.out.println(System.getProperty("user.dir"));

                // 判断父目录是否存在
                if (!file.getParentFile().exists())
                {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            byte[] bytes = code.getBytes();
            fileOutputStream.write(bytes);

            // 动态编译
            JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
            int run = systemJavaCompiler.run(null, null, null, path);
            System.out.println(run == 0 ? "success" : "fail");

            // 打印输出
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("java -cp "+file.getParent()+" test");
            InputStream inputStream = process.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info = "";
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println(info);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
