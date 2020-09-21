package threadandparallel.threadsafe;

/**
 * @program: JavaTest
 * @description: 模拟银行取款
 * 线程不安全情况2:
 *   判断存款取款操作非原子性
 *   线程推进顺序不当
 *
 * 确保锁定资源是对的
 *
 * @author: zeroCamel
 * @create: 2020-08-20 11:45
 **/
public class drawMoney {
    public static void main(String[] args)
    {
        Account account = new Account(10000, "a");
        OpAccount account1 = new OpAccount(account, 80, "b");
        OpAccount account2 = new OpAccount(account, 90, "c");

        account1.start();
        account2.start();
    }
}
class Account{
    int actualMoney;
    String name;

    public Account(int actualMoney, String name) {
        this.actualMoney = actualMoney;
        this.name = name;
    }
}
class OpAccount extends Thread {

    /**
     * 共享资源
     */
    Account account;

    int drawingMoney;
    int packMoney;

    public OpAccount(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        drawSomeMoney();
    }

    /**
     * 提款机
     * synchronized 加在同步方法上失效
     *
     */
    public void drawSomeMoney()
    {
        /**
         * 预先判断 再尝试获取锁
         */
        if (account.actualMoney<0)
        {
            return;
        }

        synchronized (account)
        {
            if (account.actualMoney-drawingMoney<0)
            {
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.actualMoney-=drawingMoney;
            packMoney+=drawingMoney;

            System.out.println(this.getName()+"-->账户余额为"+account.actualMoney);
            System.out.println(this.getName()+"-->取款总额为"+packMoney);
        }
    }
}

