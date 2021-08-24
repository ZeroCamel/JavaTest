package designpattern.behavior;

/**
 * @author zerocamel
 * @version V1.0
 * @Title:
 * @Description:
 * @date 2021/8/24 11:27
 */
public class ObserverA implements IObserve {
    @Override
    public void update(ISubject subject) {
        if (subject instanceof NewsPaperSubject && ((NewsPaperSubject) subject).State < 3) {
            System.out.println("A订阅者 接收到消息...");
        }
    }
}
