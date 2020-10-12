package datastruct;

import datastruct.map.CusHashMap;
import datastruct.map.CusHashMapGeneric;

import java.util.ArrayList;

/**
 * @program: JavaTest
 * @description: 测试数据结构入口
 * @author: zeroCamel
 * @create: 2020-09-28 11:49
 **/
public class TestEntrance {
    public static void main(String[] args) {
        CusHashMap map = new CusHashMap();
        map.put(10,"1");
        map.put(20,"2");
        map.put(30,"3");
        map.put(20,"222");

        // 监测碰撞是否形成单链表
        map.put(53,"gg");
        map.put(69,"hh");
        map.put(85,"kk");

        System.out.println(map);
        System.out.println(map.get(69));

        CusHashMapGeneric<Integer,String> mapGeneric = new CusHashMapGeneric<>();
        mapGeneric.put(10,"1");
        mapGeneric.put(20,"2");
        mapGeneric.put(30,"3");
        mapGeneric.put(20,"222");

        // 监测碰撞是否形成单链表
        mapGeneric.put(53,"gg");
        mapGeneric.put(69,"hh");
        mapGeneric.put(85,"kk");


        System.out.println(map);
        System.out.println(map.get(69));

    }
}
