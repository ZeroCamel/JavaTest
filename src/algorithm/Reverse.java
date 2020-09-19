package algorithm;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-06-13 10:28
 **/
public class Reverse {

    public static void main(String[] args) {
        String str = "abcdefghijkilmf";
        String reverResult = reverseStr(str,1);
        System.out.println(reverResult);
        System.out.println(reverStr2(str));

        String strCom = "abc";
        if (strCom == "abc")
        {
            System.out.println("true");
        } else
        {
            System.out.println("false");
        }
    }

    public static String reverseStr(String originStr,int length)
    {
        if (length == originStr.length()){
            return originStr;
        }
        return reverseStr(originStr.substring(1)+originStr.charAt(0),length+1);
    }

    public static String reverStr2(String origin)
    {
        int length = origin.length();
        int loopCnt = origin.length()/2;
        char[] array = origin.toCharArray();
        for (int i =0;i<loopCnt;i++)
        {
            int afterIndex = length-1-i;
            char temp = array[i];
            array[i] = array[afterIndex];
            array[afterIndex] = temp;
        }

        String curStr = new String(array);

        return curStr;
    }
}
