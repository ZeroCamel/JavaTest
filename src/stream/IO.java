package stream;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

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

    // region 节点流：文件输入输出节点流

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

    // region 节点流：字节数组流

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

    // region 处理流

    /**
     * 缓冲流-直接嵌套缓冲 默认是8K
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void dumpBuffer(InputStream src, OutputStream dest) throws IOException {
        try (InputStream input = new BufferedInputStream(src);
             OutputStream output = new BufferedOutputStream(dest)){
            byte[] data = new byte[1024*10];
            int length =-1;
            while ((length = input.read(data)) !=-1) {
                output.write(data, 0, length);
            }

        }
    }

    /**
     * 字符缓冲流BufferdReader
     */
    public static void dumpBuffer02()
    {
        File file = new File(PRE_PATH + "/1.txt");
        File file1 = new File(PRE_PATH+"/3.txt");
        try (FileReader fileReader = new FileReader(file);FileWriter fileWriter =new FileWriter(file1)) {
            char[] flush = new char[1024];
            int len =-1;
            while ((len=fileReader.read(flush))!=-1)
            {
                fileWriter.write(flush,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * BufferedReader
     * 逐行读取字符流
     */
    public static void dumpBuffer03()
    {
        File file = new File(PRE_PATH + "/input.png");
        File file1 = new File(PRE_PATH+"/input-test.png");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file1))) {
            String line =null;
            while ((line=fileReader.readLine())!=null)
            {
                fileWriter.write(line);
            }
            fileWriter.newLine();
            fileWriter.write("hhhhh");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲流-InputStreamReader-OutputStreamWriter
     * System.in System.out
     */
    public static void inputStreamReader()
    {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String msg = "";
            String strExit = "exit";
            while (!msg.equals(strExit))
            {
               msg = bufferedReader.readLine();
               bufferedWriter.write(msg);
               bufferedWriter.newLine();

               // 强制刷新
               bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 转换流-InputStreamReader-OutputStreamWriter
     * 网络流-转换流-缓冲流
     * 字符编码
     * 1、字节数不足
     * 2、字符编码不统一
     */
    public static void inputStreamReader02()
    {
        String url = PRE_PATH+"/baidu.html";
        try (BufferedReader inputStream =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("https://www.baidu.com").openStream(),"utf-8"));
            BufferedWriter bufferedWriter =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(url),"utf-8")))
        {
            int temp = -1;
            while ((temp=inputStream.read())!=-1)
            {
                System.out.print((char)temp);
                bufferedWriter.write((char)temp);
            }
            bufferedWriter.flush();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 特殊流 DataInputStreamReader DataOutputStreamWriter
     * 既保留了数据又保留了数据类型
     *
     */
    public static void dataInputStream()
    {
        // 选择数据流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(byteArrayOutputStream));
        try {
            // 操作数据类型 写入
            dataOutputStream.writeUTF("如果我是我");
            dataOutputStream.writeInt(11);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeChar('a');

            dataOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取数据流
        byte[] bytes = byteArrayOutputStream.toByteArray();

        // 读取
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(byteArrayInputStream));
        try {
            String readUTF = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            System.out.println(readUTF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象流-序列化、反序列 ObjectOutputStream ObjectInputStream
     * Only objects that support the java.io.Serializable interface can be written to streams
     */
    public static void objectInStream()
    {
        ByteArrayInputStream byteArrayInputStream = null;
        // 选择数据流 序列化
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream dataInputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            // 操作数据类型 写入
            dataInputStream.writeUTF("如果我是我");
            dataInputStream.writeInt(11);
            dataInputStream.writeBoolean(true);
            dataInputStream.writeChar('a');

            dataInputStream.writeObject(new Date());
            dataInputStream.writeObject("你是不是傻");
            dataInputStream.writeObject(new Employee("我",100.00));

            dataInputStream.flush();

            byte[] bytes = byteArrayOutputStream.toByteArray();

            byteArrayInputStream = new ByteArrayInputStream(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取 反序列
        try {ObjectInputStream dataInputStream1 = new ObjectInputStream(byteArrayInputStream);

            readObjectData(dataInputStream1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化反序列化至文件
     */
    public static void objectInStream01()
    {
        // 获取数据源 选择数据流 序列化
        try (ObjectOutputStream dataOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(PRE_PATH + "/object.txt")))) {

            // 操作数据 写入
            dataOutputStream.writeUTF("如果我是我ceshi");
            dataOutputStream.writeInt(121);
            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeChar('b');

            dataOutputStream.writeObject(new Date());
            dataOutputStream.writeObject("测试输出到文件");
            dataOutputStream.writeObject(new Employee("你",1100.00));

            dataOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(PRE_PATH + "/object.txt")))) {

            readObjectData(objectInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void readObjectData(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        String readUTF = objectInputStream.readUTF();
        Object readInt = objectInputStream.readInt();
        System.out.println(readUTF);
        boolean b = objectInputStream.readBoolean();
        char readChar = objectInputStream.readChar();
        Object o = objectInputStream.readObject();
        Object o1 = objectInputStream.readObject();
        Object o3 = objectInputStream.readObject();

        if (o instanceof String)
        {
            String o2 = (String) o;
            System.out.println(o2);
        }

        if (o3 instanceof Employee)
        {
            Employee o2 = (Employee) o3;
            System.out.println(o2);
        }
    }


    /**
     * 打印流
     */
    public static void printDemo()
    {
        PrintStream in = System.out;
        in.println("打印流");
        in.println(true);

        try (PrintStream printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(PRE_PATH + "/print.txt")))) {
            printStream.println("打印流");
            printStream.println(true);

            // 重定向输出端
            System.setOut(printStream);
            System.out.println("重定向输出端");

            System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
            System.out.println("重定向为控制台");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * PrintWriter
     */
    public static void printDemo01()
    {
        try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream("printWriter.txt")))) {
            printWriter.println("对滴对滴");
            printWriter.println(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * RandomAccessFile 随机读取和写入流
     * 起始位置
     * 实际大小
     */
    public static void randomAccessFile(File file,int startPoint,int actualSize,int i)
    {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
             RandomAccessFile randomAccessFile1= new RandomAccessFile(new File(PRE_PATH+"/"+i+"split.txt"),"rw")) {

            // 随机读取
            randomAccessFile.seek(startPoint);

            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len=randomAccessFile.read(bytes))!=-1)
            {
                if (actualSize>len)
                {
                    System.out.println(new String(bytes,0,len));
                    randomAccessFile1.write(bytes,0,len);
                    actualSize-=len;

                }
                else
                {
                    System.out.println(new String(bytes,0,actualSize));
                    randomAccessFile1.write(bytes,0,actualSize);
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void splitFile()
    {
        File file = new File(PRE_PATH + "/Member.java");
        int blockSize = 1024;
        long len = file.length();
        int size =(int)Math.ceil(len*1.0/blockSize);
        System.out.println(size);

        int startPoint=0;
        int actualSize;
        for (int i=0;i<size;i++)
        {
            startPoint = i*blockSize;
            if (i==size-1)
            {
                actualSize = (int) len;
            }
            else
            {
                actualSize = blockSize;
                len-=actualSize;
            }
            System.out.println("快："+i+",开始位置："+startPoint+",快大小："+actualSize);

            randomAccessFile(file,startPoint,actualSize,i);
        }
    }

    /**
     * 序列流-合并文件
     * 输入流遍历读取
     */
    public void merge()
    {
        try {
        // 追加文件
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("",true));
        //for 循环读取
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""));

        byte[] bytes= new byte[1024];
        int len = -1;
        while ((len=bufferedInputStream.read(bytes))!=-1)
        {
            bufferedOutputStream.write(bytes,0,len);
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // endregion

}

class Employee implements Serializable{
    private String name;
    /**
     * 透明-不需要序列化
     */
    private transient double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emloyee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}