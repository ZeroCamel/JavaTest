package designpattern.behavior;

/**
 * @author zerocamel
 * @version V1.0
 * @Title: 观察者
 * @Description:
 * 1 观察者的行为定义接口实现
 * 2 也可以使用抽象类
 * 3 由实际订阅者继承 可以有多个订阅者
 * @date 2021/8/18 10:06
 */
public interface IObserve {
    /**
     * 观察者更新发布者的消息
     */
    void update(ISubject subject);
}
