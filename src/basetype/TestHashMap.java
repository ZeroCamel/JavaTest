package basetype;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: JavaTest
 * @description: 测试Map的常用方法
 * @author: zeroCamel
 * @create: 2020-09-28 09:27
 **/
public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>(1000);
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.put(4,"4");

        System.out.println(map.get(1));
        System.out.println(map.size());
        System.out.println(map.containsKey(5));
        System.out.println(map.containsValue("3"));

        for (Integer i:map.keySet())
        {
            System.out.println(i);
        }

        for (Map.Entry<Integer,String> str:map.entrySet())
        {
            System.out.println(str.getKey()+"-"+str.getValue());
        }

        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });

        Map<Integer,String> newMap = new HashMap<>(1000);
        newMap.put(5,"5");
        newMap.put(6,"6");
        newMap.put(7,"7");

        map.putAll(newMap);
        System.out.println(map);

        Employee employee = new Employee(1001, "a", 10000);
        Employee employee2 = new Employee(1001, "b", 10000);
        Employee employee3 = new Employee(1001, "c", 10000);

        Map<Integer, Employee> empMap = new HashMap<>(1000);
        empMap.put(1001,employee);
        empMap.put(1002,employee2);
        empMap.put(1003,employee3);


    }

    /**
     * 计算HashCode
     * @param h
     * @param length
     * @return
     */
    public static int myHash(int h,int length)
    {
        // 按位取余数
        System.out.println(h&(length-1));
        // 直接取余数
        System.out.println(h%length);
        return h&(length-1);


    }

}

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
