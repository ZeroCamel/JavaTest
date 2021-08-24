package designpattern.behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zerocamel
 * @version V1.0
 * @Title:报社 具体发布者类
 * @Description:
 * @date 2021/8/24 15:46
 */
public class NewsPaperSubject implements ISubject {
    public int State;
    /**
     * 报纸订阅人集合
     */
    public List<IObserve> newsPaperObservers = new ArrayList<>();

    @Override
    public void Attach(IObserve observe) {
        System.out.println("提示：订阅一份报纸!");
        newsPaperObservers.add(observe);
    }

    @Override
    public void Detach(IObserve observe) {
        newsPaperObservers.remove(observe);
        System.out.println("提示：取消报纸订阅!");
    }

    @Override
    public void Notify() {
        System.out.println("发送通知...");
        System.out.println();
        for (IObserve observe : newsPaperObservers) {
            observe.update(this);
        }
    }

    /**
     * 发布消息
     */
    public void SendIssue() {
        Random random = new Random();
        int nextInt = random.nextInt(5);
        System.out.println("发布者状态:"+nextInt);
        this.State = nextInt;
        Notify();
    }
}
