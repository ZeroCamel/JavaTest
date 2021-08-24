package designpattern.behavior;

/**
 * @author zerocamel
 * @version V1.0
 * @Title:
 * @Description:
 * @date 2021/8/24 16:07
 */
public class ObserverB implements IObserve {
    @Override
    public void update(ISubject subject) {
        if (subject instanceof NewsPaperSubject && ((NewsPaperSubject) subject).State == 0 && ((NewsPaperSubject) subject).State >= 2) {
            System.out.println("B订阅者 接收到消息...");
        }
    }
}
