package threadandparallel.connectionpool;

/**
 * @program: JavaTest
 * @description: ${自定义线程池}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-11 18:47
 **/
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();
}
