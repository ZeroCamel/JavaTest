package algorithm;

import java.util.HashSet;
import java.util.Locale;

/**
 * 珠宝和石头
 * 问题转化：
 * 两个字符串比对并且统计相同元素的个数
 *
 * 反思：方法二时间复杂度低 但是在输入问题规模较小的情况下 反而法一会快些
 *
 * @author zerocamel
 * @date 2021/4/8 17:11
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

        System.out.println(numJewelsInStonesOpt("azs", "azssdbazs"));
    }

    /**
     * 方法一：暴力破解
     * jewels:aA stone:aAz
     * output 2
     * 时间复杂度：o(m*n)
     *
     * @param jewels
     * @param stones
     * @return
     */
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        if (jewels.equals("") && stones.equals("")) {
            return count;
        }
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

    /**
     * 方法二：使用HashMap数据结构
     * 时间复杂度：O(m+n)
     *
     * @param jewels
     * @param stones
     * @return
     */
    public static int numJewelsInStonesOpt(String jewels, String stones) {
        HashSet<Character> chars = new HashSet<Character>();

        int jewelsLen = jewels.length();
        int stoneLen = stones.length();

        for (int i = 0; i < jewelsLen; i++) {
            chars.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stoneLen; i++) {
            char sc = stones.charAt(i);
            if (chars.contains(sc)) {
                count++;
            }
        }

        return count;
    }
}
