package collectionandmap;

/**
 * @program: JavaTest
 * @description: ${排序收集的对象 内比较器}
 *
 *
 * (01) "Comparable"
 * 它是一个排序接口，只包含一个函数compareTo()。
 * 一个类实现了Comparable接口，就意味着“该类本身支持排序”，它可以直接通过Arrays.sort() 或 Collections.sort()进行排序。
 * (02) "Comparator"
 * 它是一个比较器接口，包括两个函数：compare() 和 equals()。
 * 一个类实现了Comparator接口，那么它就是一个“比较器”。其它的类，可以根据该比较器去排序。
 * 综上所述：Comparable是内部比较器，而Comparator是外部比较器。
 * 一个类本身实现了Comparable比较器，就意味着它本身支持排序；若它本身没实现Comparable，也可以通过外部比较器Comparator进行排序
 * Collections的sort方法自动进行排序 需要继承Comparable方法。
 *
 * @author: Mr.ZeroCamel
 * @create: 2020-05-04 22:57
 **/
public class Account implements Comparable {
    private String name;
    private String number;
    private int balance;

    public Account(String name,String number,int balance)
    {
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return String.format("Account(%s,%s,%d)",this.name,this.number,this.balance);
    }

    @Override
    public int compareTo(Object o)
    {
        Account other = (Account)o;
        return this.balance - other.balance;
    }
}
