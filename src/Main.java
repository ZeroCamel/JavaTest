import algorithm.FindArray;
import algorithm.Reverse;
import basetype.*;
import clientqueuemanage.Client;
import clientqueuemanage.ClientEvent;
import clientqueuemanage.ClientListener;
import clientqueuemanage.ClientQueue;
import collectionandmap.Account;
import collectionandmap.StringComparator;
import collectionandmap.Student;
import iInheritandpoly.BaseRole;
import iInheritandpoly.Magician;
import iInheritandpoly.SwordsMan;
import oceanhappygame.*;
import stream.CharUtil;
import stream.IO;
import threadandparallel.Hare;
import threadandparallel.Tortoise;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${JAVA 基础知识复习}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-18 19:37
 **/
public class Main {
    /**
    * @Description: 
    * @Param: [args]
    * @return: void
    * @Author: Mr.Zhai
    * @Date: 2020/4/18
    */
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,23,24,26,29,7,10,8};
        FindArray fa = new FindArray();
        fa.findKth(arr,3);

        out.println("基本类型");
        ApiClass apiClass = new ApiClass();
        apiClass.sum(1, 2, 3);

        BaseType baseType = new BaseType();
        baseType.dataConvert();

        Some s = new Some(10);
        out.println(s);
        out.println(s.x);

        //region 算法
        String reverStr = "abcdef";
        String strVer=Reverse.reverseStr(reverStr,reverStr.length());
        out.println(strVer);

        String revStr = "你好";
        try {
            byte[] revStr2= revStr.getBytes("GB2312");
            out.println(revStr2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //endregion

        //region 三大特性
        out.println("封装和继承");
        SwordsMan swordsMan = new SwordsMan();
        swordsMan.setName("Justin");
        swordsMan.setLevel(1);
        swordsMan.setBlood(200);

        Magician magician = new Magician();
        magician.setName("Monica");
        magician.setLevel(2);
        magician.setBlood(240);

        out.println("继承多态 不需要重载");
        showBlood(swordsMan);
        showBlood(magician);

        out.println("GC 孤岛对象");
        Some some = new Some(1);
        some.next = new Some(2);
        some.next.next = new Some(3);
        some.next.next.next = new Some(4);
        some = null;


        out.println("父子构造生成顺序：");
        out.println(new Other(10));

        out.println("接口多态");
        doSwim(new Anemonfish("尼莫"));
        doSwim(new Shark("兰尼"));
        // 架构调整导致的问题
        //doSwim(new Human("贾斯汀"));
        doSwim(new Submarine("黄色一号"));
        doSwim(new SeaPlane("空军零号"));
        doSwim(new FlyingBaseFish("飞鱼"));

        out.println("多人联机程序");
        ClientQueue clientQueue = new ClientQueue();
        clientQueue.addClientsListeners(new ClientListener() {

            @Override
            public void clientAdded(ClientEvent event) {
                out.printf("%s 从 %s 联机%n", event.getName(), event.getIp());
            }

            @Override
            public void clientRemoved(ClientEvent event) {
                out.printf("%s 从 %s 脱机%n", event.getName(), event.getIp());
            }
        });

        Client c1 = new Client("127.0.0.1", "Caterpillar");
        Client c2 = new Client("192.168.0.2", "Justin");
        clientQueue.add(c1);
        clientQueue.add(c2);

        clientQueue.remove(c1);
        clientQueue.remove(c2);

        out.println("接口");
        InterOne inter = new SomeOtherImpl();
        inter.doSome();
        InterTwo interTwo = (InterTwo) inter;
        interTwo.doOther();

        // 匿名内部类是一个对象，是继承或实现了抽象类和接口的子类对象
        BaseAnoymousClass baseAnoymousClass = new BaseAnoymousClass() {
            @Override
            public void doSome() {
                out.println("做一些事");
            }

            @Override
            public void doService() {

            }
        };
        baseAnoymousClass.doService();
        //endregion

        //region 异常堆栈
        // 可以使用fillInStackTrace() 装填堆栈
        // 将起点设为重抛异常的地方
        out.println("异常堆栈");
        try {
            c();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        // ClassCastException
        Object[] objs = {"Java", "7"};
        // Integer number = (Integer) objs[1];
        Integer number = Integer.parseInt((String) objs[1]);
        // Integer number1 =Integer.parseInt(args[0]);
        out.println(number);
        //endregion

        //region 集合
        out.println("Hash Set");
        Set words = new HashSet();
        words.add(new Student("Justin", "B835031"));
        words.add(new Student("Monica", "B835032"));
        words.add(new Student("Justin", "B835031"));
        out.println(words);
        forEach(words);

        // 排序收集的对象
        List accounts = Arrays.asList(
                new Account("Justin", "X1234", 1000),
                new Account("Monica", "X5678", 500),
                new Account("Irene", "X2468", 200)
        );

        Collections.sort(accounts);
        forEach(accounts);

        // Comparator
        List wordsList = Arrays.asList("B", "X", "A", "M", "F", "W", "O");
        // 内比较器
        Collections.sort(wordsList);
        forEach(wordsList);
        // 外比较器
        Collections.sort(wordsList, new StringComparator());
        forEach(wordsList);

        out.println("Hash Map");
        Map<String, String> messages = new HashMap<>();
        messages.put("Justin", "Hello,Justin的消息");
        messages.put("Monica", "给Monica的悄悄话!");
        messages.put("Irene", "Irene的可爱喵喵叫");

        // 显示键
        forEach(messages.keySet());
        // 显示值
        forEach(messages.values());

        Scanner scanner = new Scanner(in);
        out.println("取得谁的信息:");
        String message = messages.get(scanner.nextLine());
        out.println(message);
        out.println(messages);

        out.println("Tree Map");
        Map<String, String> messagess = new TreeMap<>();
        Map<String, String> messagess1 = new TreeMap<>(new StringComparator());
        messagess.put("Justin", "Hello,Justin的消息");
        messagess.put("Monica", "给Monica的悄悄话!");
        messagess.put("Irene", "Irene的可爱喵喵叫");

        // 继承自HashTable HashTable继承了Map接口
        Properties props = new Properties();
        props.setProperty("username", "justin");
        props.setProperty("password", "123456");
        out.println(props.getProperty("username"));
        out.println(props.getProperty("password"));

        try {
            props.load(new FileInputStream(args[0]));
            out.println(props.getProperty("cc.openhome.username"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion

        //region 输入和输出
        // 字节数据
        try {
            URL url = new URL(args[1]);
            InputStream src = url.openStream();
            OutputStream dest = new FileOutputStream(args[2]);

            //IO.dump(src, dest);
            IO.dumpBuffer(src, dest);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 字符数据
        FileReader reader = null;
        try {
            reader = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringWriter writer = new StringWriter();
        try {
            CharUtil.dump(reader, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(writer.toString());
        //endregion

        //region 线程与并行
        gameOfTortoiseAndHare();

        out.printf("Thread \n");
        Tortoise tortoise = new Tortoise(10);
        Hare hare = new Hare(10);
        Thread torThread = new Thread(tortoise);
        Thread hareThread = new Thread(hare);
        torThread.start();
        hareThread.start();

        // 1、Daemon进程
        // 等待被启动的所有线程都执行完run()方法才中止jvm
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true)
                {
                    out.println("Orz");
                }
            }
        };
        // 守护进程 等待所有非Daemon线程结束，jvm自动终止
        thread.setDaemon(true);
        thread.start();

        //2、安插线程
        out.println("主线程开始");
        Thread threadB = new Thread(){
          @Override
          public void run()
          {
              out.println("ThreadB 开始");
              for(int i=0;i<5;i++)
              {
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  out.println("ThreadB 执行");
              }
              out.println("ThreadB 结束");
          }
        };

        threadB.start();

        try {
            threadB.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        out.println("主线程Main 结束。。。");

        //endregion

    }

    /**
    * @Description: ${
     * 继承多态-定义静态方法
     * 1、展示所有角色的血量
     * 2、不需要在每个角色下面新建显示血量的方法
     * }$
    * @Param: [role]
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/5/1
    */
    public static void showBlood(BaseRole role)
    {
        out.printf("%s 血量 %d%n", role.getName(), role.getBlood());
    }

    /**
    * @Description: ${
     * 继承多态-提权
     * Pull up }$
    * @Param: [role]
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/5/1
    */
    public static void drawFight(BaseRole role)
    {
        out.println(role.getName());
        role.fight();
    }


    //region 接口多态

    /**
    * @Description: ${游泳}$
    * @Param: [swimmer]
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/5/2
    */
    public static void doSwim(Swimmer swimmer)
    {
        swimmer.swim();
    }

    /**
     * @Description: ${Collection 遍历}$
     * @Param: [iterable OR Collection]
     * @return: void
     * @Author: Mr.ZeroCamel
     * @Date: 2020/5/4
     */
    private static void forEach(Iterable iterable)
    {
        for (Object o:iterable)
        {
            out.println(o);
        }
    }

    private static void forEach2(Iterable<Map.Entry<String,String>> iterable)
    {
        // 增强式For循环
        for (Map.Entry<String,String> entry: iterable)
        {
            out.printf("(键 %s,值 %s)%n",entry.getKey(),entry.getValue());
        }
    }
    //endregion

    //region 异常堆栈
    public static String a()
    {
        String text = null;
        return text.toLowerCase();
    }

    public static void b()
    {
        a();
    }

    public static void c()
    {
        b();
    }
    //endregion

    /**
    * @Description: ${龟兔赛跑-单线程}$
    * @Param: []
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/5/17
    */
    public static void gameOfTortoiseAndHare()
    {
        boolean[] flags = {true,false};
        int totalStep =10;
        int tortoiseStep =0;
        int hareStep = 0;
        out.println("龟兔赛跑开始...");
        while(tortoiseStep<totalStep&&hareStep<totalStep)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tortoiseStep++;
            out.printf("乌龟跑了 %d步..%n",tortoiseStep);
            boolean isHareSleep = flags[(int)(Math.random()*10)%2];
            if (isHareSleep)
            {
                out.println("兔子睡着了...");
            } else {
                hareStep +=2;
                out.printf("兔子跑了 %d步...%n",hareStep);
            }
        }
    }

}
