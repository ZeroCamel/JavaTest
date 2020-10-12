package lock;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-10-10 10:04
 **/
public class SynchronizedTest {

    public synchronized void test1()
    {

    }

    public void test2()
    {
        synchronized (this)
        {

        }
    }

    public static void main(String[] args) {

    }
}
