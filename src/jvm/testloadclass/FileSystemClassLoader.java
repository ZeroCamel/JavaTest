package jvm.testloadclass;

import java.io.*;

/**
 * @program: JavaTest
 * @description: 自定义文件系统加载器
 * @author: zeroCamel
 * @create: 2020-08-27 09:21
 **/
public class FileSystemClassLoader extends ClassLoader {
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 1、判断是否已经加载 加载直接返回
        // 2、如果没有加载 使用父加载器加载 加载成功返回
        // 3、如果父类没有加载 定义类加载器
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass != null) {
            return loadedClass;
        } else {
//            ClassLoader parent = this.getParent();
//            loadedClass = parent.loadClass(name);
//            if (loadedClass!=null)
//            {
//                return loadedClass;
//            }
//            else
//            {
                byte[] classDate = getClassDate(name);
                if (classDate == null)
                {
                    throw new ClassNotFoundException();
                }
                else
                {
                    loadedClass = defineClass(name,classDate,0,classDate.length);
                }
//            }
        }

        return loadedClass;
    }

    /**
     * 将文件转为字节数组流
     * @param name
     * @return
     */
    private byte[] getClassDate(String name) {

        String path = rootDir + "/"+ name.replace('.', '/') + ".class";

        File file = new File(path);

        InputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream =null;
        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len=0;
            while ((len=fileInputStream.read(buffer))!=-1)
            {
                byteArrayOutputStream.write(buffer,0,len);
            }

            byteArrayOutputStream.flush();

            byte[] bytes = byteArrayOutputStream.toByteArray();

            return bytes;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null)
            {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream!=null)
            {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return  null;
    }
}
