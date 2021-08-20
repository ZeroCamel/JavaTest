package threadandparallel.asyncProgram;

//import javax.swing.plaf.synth.SynthOptionPaneUI;
//import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title: Executors
 * @Description:
 * 1 亲缘性线程池
 * @author zerocamel
 * @date 2021/7/8 9:39
 * @version V1.0
 */
public class AsyncDemo {
    public static void main(String[] args) {

        Integer a1=100;
        Integer a2=100;
        System.out.println(a1==a2);

        Integer a3=130;
        Integer a4=130;
        System.out.println(a3==a4);
        System.out.println(a3.equals(a4));

        int b1=100;
        Integer b2=100;
        System.out.println(b1==b2);
        System.out.println(b2.equals(b1));
        System.out.println(b2.intValue()==b1);

        Integer i1=new Integer(100);
        Integer i2=new Integer(100);

        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(i1.intValue()==i2.intValue());

        Integer a=6;
        Integer b=4;
        System.out.println((a&b)==b);

    }
//
//    public static void executorsDemo()
//    {
//        // 两个线程的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("爸爸：小红你去买瓶红酒!");
//            try {
//                System.out.println("小红出去买酒了，女孩子跑的比较慢，估计5s后才会回来...");
//                Thread.sleep(5000);
//                return "我买回来了！";
//            } catch (InterruptedException exception) {
//                System.out.println("小红路上遭遇了不测.");
//                return "来世再见";
//            }
//        }, executorService);
//
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("爸爸：小明你去买包烟!");
//            try {
//                System.out.println("小明出去买烟了，可能3s后才会回来...");
//                Thread.sleep(3000);
//                return "我买回来了!";
//            } catch (InterruptedException exception) {
//                System.out.println("小明路上遭遇了不测.");
//                return "这是我托人带回来的口信，我已经不在了！";
//            }
//        }, executorService);
//
//        System.out.println("爸爸：loading......");
//        System.out.println("爸爸：我觉得无聊 去了趟厕所...");
//        System.out.println("爸爸：loading.....");
//
//
//        future.thenAcceptAsync((e)->{
//            System.out.println("小红说:"+e);
//        });
//
//        future1.thenAcceptAsync((e)->{
//            System.out.println("小明说:"+e);
//        });
//    }
}
