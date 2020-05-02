import ClientQueueManage.Client;
import ClientQueueManage.ClientEvent;
import ClientQueueManage.ClientListener;
import ClientQueueManage.ClientQueue;
import InheritAndPoly.BaseRole;
import InheritAndPoly.Magician;
import InheritAndPoly.SwordsMan;
import OceanHappyGame.*;
import demo.*;

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

        out.println("基本类型");
        ApiClass apiClass = new ApiClass();
        apiClass.sum(1,2,3);

        BaseType baseType = new BaseType();
        baseType.dataConvert();

        Some s = new Some(10);
        out.println(s);
        out.println(s.x);

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
        ClientQueue clientQueue =new ClientQueue();
        clientQueue.addClientsListeners(new ClientListener() {

            @Override
            public void clientAdded(ClientEvent event) {
                out.printf("%s 从 %s 联机%n",event.getName(),event.getIp());
            }

            @Override
            public void clientRemoved(ClientEvent event) {
                out.printf("%s 从 %s 脱机%n",event.getName(),event.getIp());
            }
        });

        Client c1 = new Client("127.0.0.1","Caterpillar");
        Client c2 = new Client("192.168.0.2","Justin");
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
            public void doService()
            {

            }
        };

        baseAnoymousClass.doService();
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

    /**
    * @Description: ${
     * 接口多态
     * }$
    * @Param: [swimmer]
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/5/2
    */
    public static void doSwim(Swimmer swimmer)
    {
        swimmer.swim();
    }
}
