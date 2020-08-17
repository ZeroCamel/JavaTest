package Stream;

import java.io.*;

/**
 * @program: JavaTest
 * @description: ${流操作步骤
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-10 16:27
 **/
public class IO {

    private static final String PRE_PATH="src/Stream/file";

    // region File数据源操作 JAVA->OS

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

    /**
     * 节点流
     * 文件字节输入流FileInputStream
     * 蚂蚁搬家-按字节挨个处理
     */
    public static void fileInputStOp()
    {
        // 创建源
        File file = new File("src/Stream/file/1.txt");
        System.out.println(file.getAbsoluteFile());
        // 选择流
        InputStream inputStream = null;
        try{
            // 读取流
            inputStream = new FileInputStream(file);
            System.out.println((char)inputStream.read());
            System.out.println((char)inputStream.read());

            int temp;
            while((temp=inputStream.read())!=-1)
            {
                System.out.println((char)temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // 释放资源
            try {
                if (inputStream!=null)
                {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件字节输入流分段处理
     * 利用缓存容器 一次读取指定长度
     */
    public static void byteArrayFileInStOp()
    {
        // 获取数据源
        File file = new File("src/Stream/file/1.txt");
        InputStream inputStream;
        try {
            // 选择数据源
            inputStream = new FileInputStream(file);
            // 读取数据源-三个字节缓冲 数组长度不定 正常1k
            byte[] flush = new byte[1024*10];
            int len=-1;
            while ((len=inputStream.read(flush))!=-1)
            {
                String s = new String(flush, 0, len);
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件字节输出流
     *
     */
    public static void fileOutStOp()
    {
        // 获取数据源
        File file = new File(PRE_PATH + "/2.txt");
        OutputStream os = null;
        try {
            // 选择数据流 判断是否追加
            os = new FileOutputStream(file,false);
            String s = "hello,i am jack";
            byte[] bytes = s.getBytes();
            // 操作数据源
            os.write(bytes);
            // 清空数据缓冲
            os.flush();
            System.out.println("写出数据源成功！！！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os!=null)
            {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件Copy
     * 先打开的后关闭
     */
    public static void fileCopyByFileInputStream()
    {
        // 获取数据源
        File input = new File(PRE_PATH + "/input.png");
        File output = new File(PRE_PATH + "/output_png.png");

        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream =null;
        try {
            // 选择数据流
            fileInputStream = new FileInputStream(input);
            fileOutputStream = new FileOutputStream(output);
            // 操作数据源
            byte[] flush = new byte[1024];
            int len=-1;
            while ((len=fileInputStream.read(flush))!=-1)
            {
                fileOutputStream.write(flush,0,len);
            }

            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null)
            {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream!=null)
            {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 字符文件输出流 仅适合字符文件
     * FileReader FileInputStream
     * FileWriter FileOutputStream
     */
    public static void fileInputStream()
    {
        File file = new File(PRE_PATH + "/1.txt");
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(file);
            // 字节数组-字符数组
            char[] flush = new char[1024];
            int len=-1;
            while ((len=fileReader.read(flush))!=-1)
            {
                String s = new String(flush, 0, len);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件字符输出流
     */
    public static void fileOutputStream()
    {
        File file = new File(PRE_PATH + "/2.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            String str= "This is a test text,测试输出字符流";

            //char[] chars = str.toCharArray();
            //fileWriter.write(chars,0,chars.length);

            fileWriter.write(str);
            fileWriter.append("dddd").append("ggggg");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWriter!=null)
            {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // endregion


    // region 字节数组流

    /**
     * ByteArrayInputStream
     * 不用关闭 关闭没有任何效果
     */
    public static void byArrayInputStream()
    {
        String str = "talk is cheap,show me code";
        byte[] bytes = str.getBytes();
        InputStream byteArrayInputStream;
        byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            byte[] bytes1 = new byte[5];
            int len=-1;
            while((len=byteArrayInputStream.read(bytes1))!=-1)
            {
                String s = new String(bytes1, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ByteArrayOutputStream
     * 创建源 内部维护
     * 选择流 不关联源
     * 操作
     * 释放内容 可以不用
     * 获取数据 toByteArray
     */
    public static void byArrayOutputStream()
    {
        // 创建源
        byte[] dest=null;

        // 选择流
        ByteArrayOutputStream outputStream;
        outputStream = new ByteArrayOutputStream();

        // 写出流
        String output ="show me the code";
        byte[] bytes = output.getBytes();
        outputStream.write(bytes,0,bytes.length);
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取数据
        byte[] array = outputStream.toByteArray();
        System.out.println(new String(array,0,array.length));
        System.out.println(new String(array,0,outputStream.size()));


    }

    /**
     * 对接流
     * 将图片转为字节数组再转为图片输出
     * 图片到程序FileInputStream
     * 程序到字节数组输出ByteArrayOutputStream
     */
    public static void imgConverAndOutput()
    {

        byte[] bytes= fileToByteArray("/input.png");
        System.out.println(bytes.length);
        byteArrayToFile(bytes,"/output2.png");
    }

    /**
     * 图片读取到字节数组
     * @param filePath
     */
    public static byte[] fileToByteArray(String filePath)
    {
        File file = new File(PRE_PATH + filePath);
        byte[] dest=null;

        FileInputStream fileInputStream =null;
        ByteArrayOutputStream byteArrayOutputStream= null;

        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=fileInputStream.read(flush))!=-1)
            {
                byteArrayOutputStream.write(flush,0,len);
            }

            byteArrayOutputStream.flush();

            return byteArrayOutputStream.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null)
            {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    /**
     * 字节数组写出到文件
     * @param src
     * @param filePath
     */
    public static void byteArrayToFile(byte[] src,String filePath)
    {

        File file = new File(PRE_PATH + filePath);
        FileOutputStream fileOutputStream=null;
        ByteArrayInputStream byteArrayInputStream = null;
        byteArrayInputStream = new ByteArrayInputStream(src);
        byte[] bytes = new byte[1024];
        int len =-1;
        try {
            fileOutputStream = new FileOutputStream(file);
            while ((len=byteArrayInputStream.read(bytes))!=-1)
            {
                fileOutputStream.write(bytes,0,len);
            }

            fileOutputStream.flush();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }finally {
            if(fileOutputStream!=null)
            {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }

    // endregion
}
