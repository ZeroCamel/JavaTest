package algorithm;

import java.util.ArrayList;

/**
 * @program: JavaTest
 * @description: ${旋转
 * 补充知识点：
 * 逻辑左右移
 * 算术左右移}
 * @author: Mr.ZeroCamel
 * @create: 2020-06-13 10:28
 **/
public class Reverse {

    public static void main(String[] args) {
//        String str = "abcdef";
//        String reverResult = reverseStr(str, 1);
//        String reverStr = reverseLeftWord(str, 2);
//        System.out.println(reverResult);
//        System.out.println(reverStr2(str));
//        System.out.println(reverStr);
//
//        String reverseStr = modeStrLeftWord2(str, 2);
//        System.out.println(reverseStr);
//
//        String strCom = "abc";
//        if (strCom.equals("abc")) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }

        // 整型序列反转
        int reverse = Integer.reverse(10);
        int intValue = reverseBits(10);
        String s = Integer.toString(100, 2);
        System.out.println(s + "\n");
        System.out.println(reverse + "-" + intValue);
        System.out.println(reverseBits2(10));

        // 20 逻辑左移=算术左移 相等于/2
        System.out.println(10 << 1);
        // -20
        System.out.println(-10 << 1);
        // 5 算术右移 相当于*2
        System.out.println(10 >> 1);
        // -5
        System.out.println(-10 >> 1);
        // 5 逻辑右移
        System.out.println(10 >>> 1);
        // 2147483643
        // 逻辑右移 负数-补码 无符号右移 低位溢出 高位补0 之后变为正数后运算
        // 1000-1010 1111-0101 1111-0110 右移一位 0111-1011 =》0111-1011 2^31-1-4
        System.out.println(-10 >>> 1);

    }

    public static String reverseStr(String originStr, int length) {
        if (length == originStr.length()) {
            return originStr;
        }
        return reverseStr(originStr.substring(1) + originStr.charAt(0), length + 1);
    }

    public static String reverStr2(String origin) {
        int length = origin.length();
        int loopCnt = origin.length() / 2;
        char[] array = origin.toCharArray();
        for (int i = 0; i < loopCnt; i++) {
            int afterIndex = length - 1 - i;
            char temp = array[i];
            array[i] = array[afterIndex];
            array[afterIndex] = temp;
        }

        String curStr = new String(array);

        return curStr;
    }

    /**
     * 剑指Offer 58 左旋转字符串
     * 测试用例：abcdef 2
     * 测试结果：cdefab
     * 思路：
     * 1、如果向左平移再插入 时间复杂度 O(n)+O(1) 为平移开销+临时存储变量开销
     * 2、新增一个数组分为位移段和平移段 直接直接放入 O(n)+O(n)
     * 3、递归
     * 执行用时 489ms
     *
     * @param s 传入字符串
     * @param n 左位移操作
     * @return 返回值
     */
    public static String reverseLeftWord(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char tempChar = chars[0];
            for (int j = 1; j < chars.length; j++) {
                chars[j - 1] = chars[j];
            }
            chars[chars.length - 1] = tempChar;
        }
        String revStr = new String(chars);
        return revStr;
    }

    /**
     * 递归写法
     * 执行用时 103ms
     *
     * @param s
     * @param n
     * @return
     */
    public static String recurseStrLeftWord(String s, int n) {
        if (n == 0) {
            return s;
        }
        return recurseStrLeftWord(s.substring(1) + s.charAt(0), n - 1);
    }

    /**
     * 截取字符串
     * 执行用时 0ms 内存 38.3
     *
     * @param s
     * @param n
     * @return
     */
    public static String subStrLeftWord(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 取余操作
     * 执行用时 68MS
     *
     * @param s
     * @param n
     * @return
     */
    public static String modeStrLeftWord(String s, int n) {
        String reverStr = "";
        for (int i = n; i < s.length() + n; i++) {
            reverStr += s.charAt(i % s.length());
        }
        return reverStr;
    }

    /**
     * 使用StringBuilder 避免了频繁的内存分配
     *
     * @param s
     * @param n
     * @return
     */
    public static String modeStrLeftWord2(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            stringBuilder.append(s.charAt(i % s.length()));
        }
        return stringBuilder.toString();
    }

    /**
     * Leetcode 190 颠倒二进制位
     * <p>
     * 思路一：拆分反转 int 4个字节 32位 拆分不补0 逐位运算
     * 思路二: 位运算分治 每两位为一组
     * 高8位有两种置换方法：
     *  1、最高八位 最低八位 并且 中间16位 分两组互换
     *  2、高16位 低16位 互换
     * @param i
     * @return
     */
    private static final int M8 = 0x00ff00ff;
    public static int reverseBits(int i) {

        // 1、一位 0101 奇偶互换 取出奇数位放在偶数位上 | 将偶数位放在奇数位上并取出
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        // 2、二位 奇偶互换 0011
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        // 3、四位 奇偶互换 00001111 低8位互换结束
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        // 4、八位 0xff00
        // i = (i << 24) | ((i & 0xff00) << 8) |
        //        ((i >>> 8) & 0xff00) | (i >>> 24);

        // i = (i & M8) << 8 | (i >>> 8) & M8;
        return i;
    }

    /**
     * 逐位颠倒
     * 思路：
     * 1、枚举二进制最后一位并进行左移运算
     * 2、左移之后右移取下一位 重复步骤一
     * 3、结束标识位移32并且输入参数为0
     * 注意 与或操作可以进行取值操作
     *
     * @param n
     * @return
     */
    public static int reverseBits2(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
