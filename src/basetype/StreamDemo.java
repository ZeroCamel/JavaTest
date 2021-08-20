package basetype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamDemo API
 * 1、中间方法 filter-过滤 map-映射
 * 2、终点方法 collect sum count
 * 3、管道流 顺序流 并行流 对比Hadoop Map reduce
 */
public class StreamDemo {
    public static void main(String[] args) {
        Person a = new Person(1, "a");
        Person a1 = new Person(2, "a");
        Person a2 = new Person(3, "a");
        Person a3 = new Person(4, "a");
        Person a4 = new Person(5, "a");

        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(a);
        peoples.add(a1);
        peoples.add(a2);
        peoples.add(a3);
        peoples.add(a4);

        // 流对象
        Stream<Person> personStream = peoples.stream().filter(p -> p.age < 3);
        List<Person> collects = peoples.stream().filter(p -> p.age > 3).collect(Collectors.toList());
        for (Person p : collects) {
            System.out.println(p.age);
        }

        peoples.stream().filter(p -> p.age == 2).map(new Function<Person, Adult>() {
            @Override
            public Adult apply(Person person) {
                return new Adult(person.age, person.name);
            }
        }).sorted().count();

        List<String> nameStr = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");
        // 双冒号 方法引用
        List<String> stringList = nameStr.stream().filter(l -> l.startsWith("L")).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(stringList);


    }
}

class Person {
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int age;
    public String name;
}

class Adult {
    public Adult(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int age;
    public String name;
}
