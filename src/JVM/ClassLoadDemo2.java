package JVM;

/**
 * @program: JavaTest
 * @description: JVM类型加载
 * @author: zeroCamel
 * @create: 2020-08-26 15:41
 **/
public class ClassLoadDemo2 {

    public static void main(String[] args) throws ClassNotFoundException {

        // 线程上下文加载器
        System.out.println(Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("src/JVM/testClass"));
        System.out.println(Thread.currentThread().getContextClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        String path = "src/JVM/testClass";
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader(path);

        Class<?> aClass = fileSystemClassLoader.loadClass("JVM.testClass.TestClassLoader");
        Class<?> aClass1 = fileSystemClassLoader.loadClass("java.lang.String");

        System.out.println(aClass);
        // AppClassLoader
        System.out.println(aClass.getClassLoader());

        System.out.println(aClass1);
        // BootStrapLoader
        System.out.println(aClass1.getClassLoader());



    }
}
