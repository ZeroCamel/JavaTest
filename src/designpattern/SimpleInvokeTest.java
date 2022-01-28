package designpattern;

import designpattern.behavior.NewsPaperSubject;
import designpattern.behavior.ObserverA;
import designpattern.behavior.ObserverB;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-10-14 13:47
 **/
public class SimpleInvokeTest {
    public static void main(String[] args) {
        // SingleDemo.getInstance();
        NewsPaperSubject newsPaperSubject = new NewsPaperSubject();
        newsPaperSubject.SendIssue();

        System.out.println("订阅报纸");
        ObserverA observerA = new ObserverA();
        ObserverB observerB = new ObserverB();
        System.out.println("A订阅一份报纸");
        newsPaperSubject.Attach(observerA);
        System.out.println("B订阅一份报纸");
        newsPaperSubject.Attach(observerB);

        System.out.println("发布消息");
        newsPaperSubject.SendIssue();

        System.out.println("取消订阅者B");
        newsPaperSubject.Detach(observerB);

        newsPaperSubject.SendIssue();
    }
}
