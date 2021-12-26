package designpattern.create.singlepattern;

/**
 * @program: JavaTest
 * @description: ${饿汉}
 * @author: Mr.ZeroCamel
 * @create: 2021-12-26 20:16
 **/
public class HungrySingleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }

    static class Singleton1{
        private static final Singleton1 instance;
        static {
            instance = new Singleton1();
        }
        private Singleton1(){}
        public static Singleton1 getInstance()
        {
            return instance;
        }
    }

    static class Singleton{
        private static final Singleton instance = new Singleton();
        private Singleton() { }
        public static Singleton getInstance()
        {
            return instance;
        }
    }
}

