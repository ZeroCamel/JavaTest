package lambdaex;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-08-19 15:12
 **/
public class MyLove implements ILove,ILove2 {
    @Override
    public void lambda(int a) {
        System.out.println("z:"+a);
    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}

