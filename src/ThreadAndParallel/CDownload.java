package ThreadAndParallel;

import java.util.concurrent.Callable;

/**
 * @program: JavaTest
 * @description: callable
 * @author: zeroCamel
 * @create: 2020-08-19 13:12
 **/
public class CDownload implements Callable<Boolean> {

    private String url;
    private String name;

    public  CDownload(String url,String name)
    {
        this.url= url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        return false;
    }
}
