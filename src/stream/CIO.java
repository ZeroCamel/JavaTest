package stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Collection;
import java.util.List;

/**
 * @program: JavaTest
 * @description: ${Commons.IO
 * Commons IO is a library of utilities to assist with developing IO functionality.
 * }
 * @author: Mr.ZeroCamel
 * @create: 2020-08-18 22:49
 **/
public class CIO {

    private static final String PRE_PATH = "src/Stream/file";

    /**
     * 相关文件统计
     */
    public static void fileStatistic() {
        // 统计文件的大小
        File file = new File(PRE_PATH + "/1.txt");
        long sizeOf = FileUtils.sizeOf(file);
        System.out.println((int) sizeOf);
        // 统计目录的大小
        long sizeOfDirectory = FileUtils.sizeOfDirectory(new File(PRE_PATH));
        System.out.println((int) sizeOfDirectory);

        // 列出子文件 不为空
        Collection<File> fileCollection = FileUtils.listFiles(new File(PRE_PATH + "/dir"), EmptyFileFilter.NOT_EMPTY, null);
        System.out.println(fileCollection);

        fileCollection = FileUtils.listFiles(new File(PRE_PATH + "/dir"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        System.out.println(fileCollection);

        // 文件后缀过滤
        fileCollection = FileUtils.listFiles(new File(PRE_PATH + "/dir"), new SuffixFileFilter("txt"), DirectoryFileFilter.INSTANCE);
        System.out.println(fileCollection);

        // 过滤器可以与或关系
        fileCollection = FileUtils.listFiles(new File(PRE_PATH + "/dir"), FileFilterUtils.or(new SuffixFileFilter("txt"), new SuffixFileFilter(".java"), EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
        System.out.println(fileCollection);

    }

    /**
     * 读取文件
     */
    public static void readFileByFileUtils() {
        try {

            // 读取文件至字符串
            String readFileToString = FileUtils.readFileToString(new File(PRE_PATH + "/1.txt"), "utf-8");
            System.out.println(readFileToString);
            // 读取文件至字节数组
            byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(PRE_PATH + "/1.txt"));
            System.out.println(readFileToByteArray.length);

            // 读取行
            List<String> stringList = FileUtils.readLines(new File(PRE_PATH + "/1.txt"), "utf-8");
            System.out.println(stringList);
            // 迭代器
            LineIterator lineIterator = FileUtils.lineIterator(new File(PRE_PATH + "/1.txt"), "utf-8");
            while (lineIterator.hasNext()) {
                System.out.println(lineIterator.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写出内容
     */
    public static void writeFileByFileUtils() {
        try {

            FileUtils.write(new File(PRE_PATH + "/fileUtilsOutput.txt"), "测试写出文件", "utf-8", true);
            FileUtils.writeStringToFile(new File(PRE_PATH + "/fileUtilsOutput.txt"), "测试写出文件", "utf-8", true);
            FileUtils.writeByteArrayToFile(new File(PRE_PATH + "/2.txt"), "测试字节数组输出".getBytes("utf-8"), true);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文件
     */
    public static void copyFileByFileUtils() {
        try {
            // 复制文件
            FileUtils.copyFile(new File(PRE_PATH + "/output2.png"), new File(PRE_PATH + "/output2-copy.png"));
            // 复制文件到目录
            FileUtils.copyFileToDirectory(new File(PRE_PATH + "/output2.png"), new File(PRE_PATH + "/dir/"));
            // 复制目录
            FileUtils.copyDirectory(new File(PRE_PATH + "/dir"), new File(PRE_PATH + "/dir2"));
            // 复制目录到目录
            FileUtils.copyDirectoryToDirectory(new File(PRE_PATH + "/dir"), new File(PRE_PATH + "/dir2"));

            FileUtils.copyURLToFile(new URL(""), new File(""));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
