package algorithm;

import java.util.Locale;

/**
 * 珠宝和石头
 * 问题转化：
 * 两个字符串比对并且统计相同元素的个数
 *
 * @author zerocamel
 * @date 2021/4/8 17:11
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    /**
     * 方法一：暴力破解
     * jewels:aA stone:aAz
     * output 2
     *
     * @param jewels
     * @param stones
     * @return
     */
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        char[] jewelsArray = jewels.toCharArray();
        char[] stonesArray = stones.toCharArray();
        for (char cj : jewelsArray) {
            for (char st : stonesArray) {
                if (st == cj) {
                    count++;
                }
            }
        }
        return count;
    }
}
