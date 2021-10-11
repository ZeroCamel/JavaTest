package threadandparallel.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: JavaTest
 * @description: ${模拟数据库连接客户端}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-11 12:34
 **/
public class ConnectionPoolTest {
    static ConnectionPoolDemo pool = new ConnectionPoolDemo(10);
    /**
     * 1.5引入 CyclicBarrier Semaphore concurrentHashMap BlockingQueue
     * countdownlatch 使得一个线程等待其他线程各自执行完毕之后再执行 计数递减
     * 保证所有ConnectionRunner能够同时开始
     */
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                // 等待
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {
                Connection connection = null;
                try {
                    // 从线程池中获取连接 如果1000ms内无法获取到，将会返回null
                    // 分别统计连接获取的数量GOT和为获取的数量
                    connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            // 开始计数
            end.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread");
            thread.start();

        }
        // 开始计数
        start.countDown();
        // 等待
        end.await();
        System.out.println("Total invoke:" + (threadCount * count));
        System.out.println("Got connection:" + got);
        System.out.println("not got connection:" + notGot);
    }
}
