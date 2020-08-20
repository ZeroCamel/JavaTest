import java.util.concurrent.ExecutionException;

/**
 * @program: JavaTest
 * @description: ${多线程}"
 * @author: Mr.ZeroCamel
 * @create: 2020-04-18 19:37
 **/
public class Main_Thread {
    /**
    * @Description: 
    * @Param: [args]
    * @return: void
    * @Author: Mr.Zhai
    * @Date: 2020/4/18
    */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        // 一条赛道 多个竞争者
//        Racer01 racer = new Racer01();
//        new Thread(racer,"hare").start();
//        new Thread(racer, "tortoise").start();

//        // Executors
//        Racer02 racer02 = new Racer02();
//        /**
//         * 避免使用Executors 使用 ThreadPoolExecutors 避免资源耗尽的风险
//         * 核心线程池大小 线程池的最大线程数 空闲时间 存活时间 等待执行队列长度 线程工厂 拒绝策略
//         */
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Future<Integer> submit = executorService.submit(racer02);
//        Future<Integer> submit1 = executorService.submit(racer02);
//
//        Integer integer = submit.get();
//        Integer integer1 = submit1.get();
//
//        System.out.println(integer);
//        System.out.println(integer1);
//
//        // 及时关闭
//        executorService.shutdownNow();

//        // 匿名内部类 必须借助接口或者父类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<20;i++)
//                {
//                    System.out.println("一边听歌...");
//                }
//            }
//        }).start();

//        // lambda 表达式 只关注方法体 只能是一个方法
//        new Thread(() -> {
//            for (int i=0;i<20;i++)
//            {
//                System.out.println("一边听歌...");
//            }
//        }).start();

//        // 有参数的Lambda 可以省略括号 如果是一个变量还可以省略变量类型
//        ILove iLove = t -> {
//            System.out.println("z:"+t);
//        };
//
//        iLove.lambda(4);
//
//        ILove iLove1 = t -> System.out.println("z:"+t);;
//
//        iLove1.lambda(55);
//
//        // lambda 两个参数
//        ILove2 iLove2 =(int a, int b) -> {
//            return a+b;
//        };
//        ILove2 iLove3 =(a, b) -> {
//            return a+b;
//        };
//        ILove2 iLove4 =(a, b) -> a+b;
//        int add = iLove4.add(10, 20);
//        System.out.println(add);
//
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(date.getTime());
//        long l = date.getTime() - 1000;
//        System.out.println(l);

//        //礼让线程
//        YieldDemo yieldDemo = new YieldDemo();
//        new Thread(yieldDemo,"a").start();
//        new Thread(yieldDemo,"b").start();
//        // lambda 表达式
//        new Thread(()->{
//            for (int i=0;i<100;i++)
//            {
//                System.out.println("lambda..."+i);
//            }
//        }).start();
//
//        for (int i=0;i<100;i++)
//        {
//            if (i%20==0)
//            {
//                Thread.yield();
//            }
//            System.out.println("main....");
//        }

//        // Join线程
//        // 子线程
//       Thread thread = new Thread(()->{
//            for (int i=0;i<100;i++)
//            {
//                System.out.println("lambda..."+i);
//            }
//        });
//
//       thread.start();
//       // 主线程
//       for (int i=0;i<100;i++)
//        {
//            if (i==20)
//            {
//                // 导致主线程阻塞 等待其他线程执行完毕之后再执行其他
//                thread.join();
//            }
//            System.out.println("main...."+i);
//        }
//        PriorityThread.test01();

//        DaemonThread.test01();

//        InfoThread.infoTest();

    }
}
