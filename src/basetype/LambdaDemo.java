package basetype;

/**
 * lambdaDemo
 */
public class LambdaDemo {
    interface Printer {
        void print(String val);
    }

    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
        String s = "i need to know something";

        // 传统的接口函数实现方式
//        Printer printer = new Printer() {
//            @Override
//            public void print(String val) {
//                System.out.println(val);
//            }
//        };

        // lambda表达式重构
        Printer printer = (String val) -> {
            System.out.println(val);
        };

        Printer printer1 = (val) -> {
            System.out.println(val);
        };

        Printer printer2 = val -> {
            System.out.println(val);
        };

        lambdaDemo.printSomething(s, printer);

        lambdaDemo.printSomething(s,val -> System.out.println(val));
    }
}
