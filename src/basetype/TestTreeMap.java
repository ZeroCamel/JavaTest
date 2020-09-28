package basetype;

import java.util.Collections;
import java.util.TreeMap;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-09-28 14:37
 **/
public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(20,"a");
        treeMap.put(30,"b");
        treeMap.put(10,"c");

        for (Integer key:treeMap.keySet())
        {
            System.out.println(key+"---"+treeMap.get(key));
        }

        TreeMap<Emp, String> treeMap1 = new TreeMap<>();
        treeMap1.put(new Emp(100,"a",50000),"张三是个好小伙");
        treeMap1.put(new Emp(200,"a",5000),"李四工作不积极");
        treeMap1.put(new Emp(150,"a",5000),"王五工作还不错");

        for (Emp key:treeMap1.keySet())
        {
            System.out.println(key+"---"+treeMap1.get(key));
        }

    }
}
class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * 负数 小于 0 等于 正数 大于
     * @param o
     * @return
     */
    @Override
    public int compareTo(Emp o) {
        if (this.salary>o.salary)
        {
            return 1;
        }else if(this.salary<o.salary)
        {
            return -1;
        }else
        {
            if (this.id>o.id)
            {
                return 1;
            } else if(this.id<o.id)
            {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}