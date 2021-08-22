package algorithm;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 停车系统-思考
 * 1、采用什么样的数据结构解决当前问题
 * 2、时间复杂度空间复杂度
 * <p>
 * 反思：HashTable 与 HashMap的区别
 */
public class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    private Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
    private Map mapStore = new HashMap<Integer, Integer>();

    // 将三个简单变量冗余在一个字段里
    int cnt;

    public int getBig() {
        return big;
    }

    public int getMedium() {
        return medium;
    }

    public int getSmall() {
        return small;
    }

    public Hashtable<Integer, Integer> getHashtable() {
        return hashtable;
    }
//    public ParkingSystem(int big, int medium, int small) {
//        this.big = big;
//        this.medium = medium;
//        this.small = small;
//    }

//    public ParkingSystem(int big, int medium, int small) {
//        this.hashtable.put(1, big);
//        this.hashtable.put(2, medium);
//        this.hashtable.put(3, small);
//    }

//    public ParkingSystem(int big, int medium, int small) {
//        mapStore.put(1, big);
//        mapStore.put(2, medium);
//        mapStore.put(3, small);
//    }

    public ParkingSystem(int big, int medium, int small) {
        for (int i = 0; i < 30; i++) {
            int cur = 0;
            if (i < 10) {
                cur = (big >> i) & 1;
            } else if (i < 20) {
                cur = (medium >> (i - 10)) & 1;
            } else if (i < 30) {
                cur = (small >> (i - 20)) & 1;
            }
            cnt += cur == 1 ? (1 << i) : 0;
        }
    }

    /**
     * 停车入库-法一
     * 简单变量控制
     *
     * @param carType
     * @return
     */
    public boolean addCar(int carType) {
        boolean flag = false;
        switch (carType) {
            case 1:
                if (big > 0) {
                    flag = true;
                    big--;
                }
                break;
            case 2:
                if (medium > 0) {
                    flag = true;
                    medium--;
                }
                break;
            case 3:
                if (small > 0) {
                    flag = true;
                    small--;
                }
                break;
        }
        return flag;
    }

    /**
     * HashTable
     *
     * @param carType
     */
    public boolean addCar2(int carType) {

        int flag = hashtable.get(carType) == null ? 0 : hashtable.get(carType);
        if (flag <= 0) {
            return false;
        }
        hashtable.put(carType, hashtable.get(carType) - 1);
        return true;
    }

    /**
     * HashMap
     *
     * @param carType
     * @return
     */
    public boolean addCar3(int carType) {
        if (mapStore.get(carType) != null && (int) mapStore.get(carType) > 0) {
            mapStore.put(carType, (int) mapStore.get(carType) - 1);
            return true;
        }
        return false;
    }

    /**
     * 二进制分段
     * 实际应用：ThreadPoolExecutor
     * int 一共有32位 停车位最多是2^32-1
     * 将其分区10位一组
     * 0-10 10-20 20-30
     * 将每个车库的大小转为二进制从右往左取出放在分区最高位
     *
     * @param carType
     * @return
     */
    public boolean addCar4(int carType) {
        int remainCnt = countOfType(carType);
        if (remainCnt > 0) {
            setCount(carType, remainCnt - 1);
            return true;
        }
        return false;
    }

    /**
     * 计算每种类型车库的大小
     *
     * @param ct
     * @return
     */
    public int countOfType(int ct) {
        int ans = 0;
        int start = --ct * 10, end = start + 10;
        for (int i = start; i < end; i++) {
            if (((cnt >> i) & 1) == 1) {
                ans += (1 << (i - start));
            }
        }
        return ans;
    }

    public void setCount(int ct, int pc) {
        int start = --ct * 10, end = start + 10;
        for (int i = start; i < end; i++) {
            if (((pc >> (i - start)) & 1) == 1) {
                cnt |= (1 << i);
            } else {
                cnt &= ~(1 << i);
            }
        }
    }
}
