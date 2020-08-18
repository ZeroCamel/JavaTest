package Stream;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: JavaTest
 * @description: 注意文件路径的书写规则
 * 1、d:\code\app\demo\q.txt
 * @author: zeroCamel
 * @create: 2020-08-17 09:22
 **/
public class FileDemo {

    /**
     * 名称分隔符 \  /
     */
    public static void test01()
    {
        // 绝对路径-存在盘符 反之 相对路径 windows平台会自动转义
        String path = "E:\\GitBlit\\JavaTest\\src\\Stream\\file\\bak.txt";
        System.out.println(path);
        System.out.println(File.separatorChar);

        // 使用 /
        String path1 = "E:/GitBlit/JavaTest/src/Stream/file/bak.txt";
        System.out.println(path1);

        // 常量拼接
        String path2 = "E:"+File.separatorChar+"GitBlit";

    }

    /**
     * File 构造器
     * 可以构建一个不存在的路径
     */
    public static void  test02()
    {
        String path1 = "E:/GitBlit/JavaTest/src/Stream/file/bak.txt";
        File file = new File(path1);
        System.out.println(file);
        // 文件的长度
        System.out.println(file.length());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());


        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());

        System.out.println("-----");

        file = new File("E:/GitBlit/JavaTest/src/Stream","file/bak.txt");
        System.out.println(file);
        System.out.println(file.getPath());


        System.out.println("-----");

        file = new File(new File("E:/GitBlit/JavaTest/src/Stream"),"file/bak.txt");
        System.out.println(file);


        System.out.println("-----");


        file = new File("src/Stream/file/bak.txt");


        System.out.println("-------");

        System.out.println(System.getProperty("user.dir"));

    }

    /**
     * 文件状态
     */
    public static void test03()
    {
        String path1 = "E:/GitBlit/JavaTest/src/Stream/file/bak.txt";
        File file = new File(path1);

        if (file==null||!file.exists())
        {
            System.out.println("文件不存在");
        }
        else
        {
            if (file.isFile()){
                System.out.println("文件操作");
            }
            else
            {
                System.out.println("文件夹操作");
            }
        }
    }

    /**
     * 创建文件 删除文件
     */
    public static void test04()
    {
        String path1 = "E:/GitBlit/JavaTest/src/Stream/file/bak1.txt";
        File file = new File(path1);

        boolean b = false;
        try {
            b = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(b);

        boolean delete = file.delete();
        System.out.println(delete);

    }

    /**
     * 创建文件夹 删除文件夹
     * mkdir 创建目录
     * mkdirs 如果父目录不存在一同创建
     * list
     * listFiles
     * listRoot
     */
    public static void test05()
    {
        String path1 = "E:/GitBlit/JavaTest/src/Stream/file/";
        File file = new File(path1);

        boolean mkdir = file.mkdir();
        System.out.println(mkdir);

        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);

        String[] list = file.list();
        System.out.println(Arrays.toString(list));

        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));

        File[] listRoots = File.listRoots();
        System.out.println(Arrays.toString(listRoots));

    }

    /**
     * 递归打印子孙级目录和文件名称
     */
    public static void test06(File src,int deep)
    {
        for (int i=-1;i<deep;i++)
        {
            System.out.print("-");
        }
        System.out.println(src.getName());
        if (src==null||!src.exists())
        {
            return;
        }
        else if (src.isDirectory())
        {
            for (File s:src.listFiles())
            {
                test06(s,deep++);
            }
        }

    }

    /**
     * 文件夹大小
     */
    private static long LEN=0;
    public static void count(File src)
    {
        if (src!=null&&src.exists())
        {
            if (src.isFile())
            {
                LEN+=src.length();
            }
            else{
                for (File s:src.listFiles())
                {
                    count(s);
                }
            }
        }
    }

}
