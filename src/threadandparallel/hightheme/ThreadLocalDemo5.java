package threadandparallel.hightheme;

import threadandparallel.threadstate.SleepUtils;

/**
 * @author zerocamel
 * @version V1.0
 * @Title:Profile 调用耗时统计
 * @Description:
 * @date 2021/9/9
 */
public class ThreadLocalDemo5 {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(()->System.currentTimeMillis());

    public static final void begin()
    {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end()
    {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) {
        ThreadLocalDemo5.begin();
        SleepUtils.second(1);
        System.out.println("Cost: "+ThreadLocalDemo5.end()+" mills");
    }
}
