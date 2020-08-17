package Algorithm;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-06-13 10:28
 **/
public class Reverse {
    public static String reverseStr(String originStr,int length)
    {
        if (length == originStr.length()){
            return originStr;
        }
        return reverseStr(originStr.substring(1)+originStr.charAt(0),length+1);
    }
}
