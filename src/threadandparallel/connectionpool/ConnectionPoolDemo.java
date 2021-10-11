package threadandparallel.connectionpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @program: JavaTest
 * @description: ${模拟连接池-双向队列维护连接池}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-11 12:03
 **/
public class ConnectionPoolDemo {


    /**
     * 共享变量
     */
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPoolDemo(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());

            }
        }
    }

    /**
     * 生产者模式
     *
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            // 加锁
            synchronized (pool) {
                // 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 在mills毫秒内无法获取连接 将会返回Null
     *
     * @param mills
     * @return
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }

        }
    }
}
