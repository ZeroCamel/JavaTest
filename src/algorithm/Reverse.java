package algorithm;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-06-13 10:28
 **/
public class Reverse {

    public static void main(String[] args) {
        String str = "abcdef";
        String reverResult = reverseStr(str, 1);
        String reverStr = reverseLeftWord(str, 2);
        System.out.println(reverResult);
        System.out.println(reverStr2(str));
        System.out.println(reverStr);

        String reverseStr = modeStrLeftWord2(str, 2);
        System.out.println(reverseStr);

        String strCom = "abc";
        if (strCom.equals("abc")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
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
     * @param s
     * @param n
     * @return
     */
    public static String modeStrLeftWord(String s, int n) {
        String reverStr = "";
        for (int i = n; i < s.length() + n; i++) {
            reverStr += s.charAt(i % s.length());
        }
        return  reverStr;
    }

    /**
     * 使用StringBuilder 避免了频繁的内存分配
     * @param s
     * @param n
     * @return
     */
    public static String modeStrLeftWord2(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            stringBuilder.append(s.charAt(i % s.length()));
        }
        return  stringBuilder.toString();
    }
}
