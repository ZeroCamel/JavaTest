package threadandparallel.connectionpool;


/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-11 18:45
 **/
public class DefultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    public DefultThreadPool()
    {

    }

    private void initializeWorkers(int num)
    {
        for (int i = 0; i < num; i++) {

        }
    }

    @Override
    public void execute(Job job) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void addWorkers(int num) {

    }

    @Override
    public void removeWorker(int num) {

    }

    @Override
    public int getJobSize() {
        return 0;
    }
}
