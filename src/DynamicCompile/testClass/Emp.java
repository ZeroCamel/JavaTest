package dynamiccompile.testClass;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-08-26 11:44
 **/
public class Emp {
    private int empno;
    private String ename;

    public Emp() {
    }

    public void sayHello(int a)
    {
        System.out.println("hello "+a);
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
