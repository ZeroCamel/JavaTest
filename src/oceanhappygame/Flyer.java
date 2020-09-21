package oceanhappygame;

/**
 * @program: JavaTest
 * @description: ${会飞的
 * 注意：接口 默认 public abstract can omit
 * 但是如果继承实现 必须写Public 默认不写式包权限 继承不可以缩小权限}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 14:23
 **/
public interface Flyer {

    // 枚举常数 默认public static final
    int STOP = 0;

    void fly();
}
