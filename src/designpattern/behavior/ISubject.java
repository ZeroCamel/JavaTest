package designpattern.behavior;

/**
 * @author zerocamel
 * @version V1.0
 * @Title: 发布者
 * @Description:
 * 1 发布者行为定义接口实现
 * 2 发布者可以是一个实体类
 * 3 由实际发布者继承
 * 4 多个发布者如何实现？
 * @date 2021/8/18 10:10
 */
public interface ISubject {
    /**
     * 订阅
     * @param observe
     */
    void Attach(IObserve observe);

    /**
     * 移除
     * @param observe
     */
    void Detach(IObserve observe);

    /**
     * 通知
     */
    void Notify();
}
