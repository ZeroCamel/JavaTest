package basetype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import org.junit.platform.commons.util.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import lombok.Data;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: JavaTest
 * @description: ${基本数据类型注意点}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-18 19:37
 **/
public class BaseType {
    /**
     * @Description: ${int byte 互转
     * 正数的原码反码补码都一致
     * 负数的反码是除符号位按位取反
     * 负数的补码是反码加1
     * java中变量存储是按补码保存的
     * }$
     * @Param: []
     * @return: void
     * @Author: Mr.ZeroCamel
     * @Date: 2020/4/18
     */
    public static void dataConvert() {
        /*一、JAVA数值运算 原码 反码 补码*/
        /*编译成功 精度损失*/

        byte a = 100;
        byte b = 50;
        byte c = (byte) (a + b);
        System.out.println(c);

        /*C# 编译失败 强制类型转换失败*/
        // sbyte a = 100;
        // sbyte b = 50;
        // sbyte c = Convert.ToSByte(a+b);
        // Console.WriteLine(c);

        int x = 100;
        int y = 120;
        Integer wx = x;
        Integer wy = y;
        System.out.println(x == y);
        // 比较引用对象的实质内容是否相同
        System.out.println(wx.equals(wy));

        String[] strs = new String[5];

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aaa");
        stringBuffer.append("bbb");
        System.out.println(stringBuffer.toString());

    }

    public static void str() {
        String str1 = "计算机";
        String str2 = "计算机";
        System.out.println("str1==str2:" + (str1 == str2));

        String str3 = new String("计算机");
        System.out.println("str1==str3:" + (str1 == str3));
        System.out.println("str1==str3.intern():" + (str1 == str3.intern()));
        System.out.println("str2==str3.intern():" + (str2 == str3.intern()));

        String str4 = new String("计算机");
        System.out.println("str3==str4:" + (str3 == str4));
        System.out.println("str3.intern()==str4.intern():" + (str3.intern() == str4.intern()));


        String str5 = new StringBuilder("软件").append("工程").toString();
        System.out.println("str5.intern() == str5:" + (str5.intern() == str5));

        String str6 = new String(new StringBuilder("物联网").append("工程").toString());
        System.out.println("str6.intern() == str6:" + (str6.intern() == str6));

        String str7 = new String("物联网");
        System.out.println("str7.intern() == str7:" + (str7.intern() == str7));

    }

    public static void str1() {
        String s = new String("1");

        s.intern();

        String s2 = "1";

        System.out.println(s == s2);


        String s3 = new String("1") + new String("1");

        s3.intern();

        String s4 = "11";

        System.out.println(s3 == s4);
    }

    public static void str2() {
        String s2 = new String("abc");
        String s1 = "abc";
        String s3 = s2.intern();

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
    }

    public static void str3() {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();

        System.out.println(s3 == s4);
    }

    public static void str4() {
        String s = new String("hhh");
        char c = s.charAt(1);
        System.out.println(c);

        int hhc = s.compareTo("hhc");
        System.out.println(hhc);

    }

    /**
     * 形参和实参的区别
     * 1、形参如果在变量内部分配实体变量 执行完如果没有返回参数将自动销毁
     * 2、导致引用失败
     *
     * @param a
     * @return
     */
    public static void staticFun(List<String> a) {
        a = new ArrayList<String>();
        a.add("abc");
    }

    public static void str5() {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        String str3 = "he" + "llo";
        System.err.println(str1 == str2);
        System.err.println(str1 == str3);
    }

    /**
     * HashCode 散列码
     * 变量s与t HashCode 值一样
     */
    public static void hashCodeDemo() {
        String s = "ok";
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(s.hashCode() + "-" + stringBuilder.hashCode());
        String t = new String("ok");
        StringBuilder stringBuilder1 = new StringBuilder(t);
        System.out.println(t.hashCode() + "-" + stringBuilder1.hashCode());
    }

    public static void bigDecimal() {
        BigDecimal bigDecimal = new BigDecimal(0);
        BigDecimal bigDecimal1 = new BigDecimal(0.00);
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(add);
        System.out.println(bigDecimal.equals(bigDecimal1));
    }

    public static void hashMapTest() {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("0", "Integer");
        stringHashMap.put("1", "Long");
        stringHashMap.put("0", "String");

        for (Map.Entry<String, String> entry :
                stringHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-" + value);
        }
    }

    public static void hashSetTest() {
        HashSet<String> stringHashMap = new HashSet<>();
        stringHashMap.add("0");
        stringHashMap.add("1");
        stringHashMap.add("0");

        for (Iterator<String> it = stringHashMap.iterator(); it.hasNext(); ) {
            String next = it.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args) throws IOException {


//        Date date = new Date(0);
//        System.out.println(DateUtil.format(date,DatePattern.NORM_DATETIME_PATTERN));
//
//        double a = 1.222;
//        long longValue = new Double(a).longValue();
//        long c = 100;
//        Long d = 100L;
//        double v = d.doubleValue();

//        Integer aa = 1;
//        Long aLong = Long.valueOf(aa.toString());
//        System.out.println(aLong);
//
//        DecimalFormat format = new DecimalFormat();
//        format.setMaximumFractionDigits(0);
//        String format1 = format.format(0.3);
//        String format2 = format.format(0.7);
//        System.out.println(format1+":"+format2);
//
//        System.out.println(a + "-" + longValue + "-" + format1);
//        System.out.println(format.format((v+a)/2));

//        DecimalFormat percent = (DecimalFormat) NumberFormat.getPercentInstance();
//        // 保留2位有效数字
//        percent.setMaximumFractionDigits(2);
//        percent.setPositiveSuffix("%");
//        String ac = "0.04974";
//        System.out.println(Convert.toDouble(ac));
//        System.out.println(percent.format(Convert.toDouble(ac)));

//
//        try {
//            String date = dateToStamp(DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN));
//            String date1 = dateToStamp(DateUtil.format(Convert.toDate("2022-01-04"), DatePattern.NORM_DATETIME_PATTERN));
//            System.out.println(date);
//            System.out.println(date1);
//
//            String bl = "1|0";
//
//            ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
//            try {
//                Object eval = engine.eval(bl);
//                BigDecimal bigDecimal = new BigDecimal(0);
//                //不能省略，防止使用科学计数
//                if (eval instanceof Integer){
//                    bigDecimal = bigDecimal.add(new BigDecimal((Integer)eval));
//                }
//                //不能省略，防止使用科学计数
//                if (eval instanceof Double){
//                    bigDecimal = bigDecimal.add(new BigDecimal((Double)eval));
//                }
//                System.out.println(timestampToTime(bigDecimal,UnitEnum.DAY.getKey()));
//            } catch (ScriptException e) {
//                e.printStackTrace();
//            }
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//


//        LocalDateTime localDateTime = Convert.toLocalDateTime(null);
//        String format2 = DateUtil.format(localDateTime, DatePattern.NORM_DATETIME_PATTERN);
//        String s = DateUtil.parse(format2) + "";
//
//        String content = "leaveTime-6444";
//        String[] strings = content.split(caclRegx);
//
//        String format = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN);
//
//        DecimalFormat percent = (DecimalFormat) NumberFormat.getPercentInstance();
//        percent.setMaximumFractionDigits(0);
//        BigDecimal bigDecimal = new BigDecimal("0.99");
//        String format1 = percent.format(bigDecimal);
//        // -1 0 1
//        if (bigDecimal.compareTo(new BigDecimal("1")) == 1) {
//            System.out.println("显示");
//        }
//
//        BigDecimal bigDecimal1 = bigDecimal.setScale(0,BigDecimal.ROUND_DOWN);
//
//        System.out.println(bigDecimal1.toString());

//        List<String> currItemList = new ArrayList<>();
//        List<String> dbItemList = new ArrayList<>();
//        String itemValue = "[\"a\",\"b\",\"c\"]";
//        if (!StringUtils.isBlank(itemValue)) {
//            dbItemList = JSONUtil.toList(JSONUtil.parseArray(itemValue), String.class);
//        }
//
//        List<String> newList = (List<String>) CollectionUtil.union(dbItemList, currItemList);
//        String s = JSONUtil.toJsonStr(dbItemList);
//        System.out.println(s);
//
//        boolean jsonArray = JSONUtil.isJsonArray(itemValue);
//        List<String> strings = JSONUtil.toList(itemValue, String.class);
//
//        List<String> strings2 = JSONUtil.toList(s, String.class);
//
//        String toJsonStr = JSONUtil.toJsonStr(s);
//
//        List<String> strings1 = JSON.parseArray(s, String.class);
//
//        Double A = 22.22D;
//        System.out.println(A.toString());
//
//        List<String> union = (List<String>) CollectionUtil.union(new ArrayList<>(), dbItemList);
//        System.out.println(union);

        HashMap<String, Object> hashMap = new HashMap<>(1);
        hashMap.put("dd","22");
        System.out.println(hashMap);
    }

    public static final String caclRegx = "\\(|\\)|\\+|\\-";

    private static String timestampToTime(BigDecimal timestamp, String unit) {

        if (unit.equals(UnitEnum.WEEK.getKey())) {
            timestamp = timestamp.divide(new BigDecimal(DateUnit.WEEK.getMillis()), 2, BigDecimal.ROUND_HALF_UP);
        }
        if (unit.equals(UnitEnum.DAY.getKey())) {
            timestamp = timestamp.divide(new BigDecimal(DateUnit.DAY.getMillis()), 2, BigDecimal.ROUND_HALF_UP);
        }
        if (unit.equals(UnitEnum.HOUR.getKey())) {
            timestamp = timestamp.divide(new BigDecimal(DateUnit.HOUR.getMillis()), 2, BigDecimal.ROUND_HALF_UP);
        }
        if (unit.equals(UnitEnum.MINUTE.getKey())) {
            timestamp = timestamp.divide(new BigDecimal(DateUnit.MINUTE.getMillis()), 2, BigDecimal.ROUND_HALF_UP);
        }
        if (unit.equals(UnitEnum.SECOND.getKey())) {
            timestamp = timestamp.divide(new BigDecimal(DateUnit.SECOND.getMillis()), 2, BigDecimal.ROUND_HALF_UP);
        }


        return timestamp.toString();

    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    
    private static void extracted() {
        String date = "2021-06-01 00:00:00";
        String date1 = "2021-12-01 00:00:00";


        int compareTo = date.compareTo(date1);

        String strFormat = "yyyy-MM";
        Date startDate = Convert.toDate(date);
        Date endDate = Convert.toDate(date1);
        int i1 = endDate.compareTo(startDate);
        // 遍历AddMonth
        long betweenMonth = DateUtil.betweenMonth(startDate, endDate, true);
        ArrayList<String> yearOfMonth = new ArrayList<>();
        for (int i = 0; i <= betweenMonth; i++) {
            String fStartDate = DateUtil.format(startDate, strFormat);
            yearOfMonth.add(fStartDate);
            startDate = DateUtil.offsetMonth(startDate, 1);
        }

        LocalDateTime time = LocalDateTime.parse("2020-09-08 00:02:12");
        LocalDateTime time1 = LocalDateTime.parse("2020-09-18 15:09:00");

        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setName("a");
        user.setTime(time);
        User user1 =new User();
        user1.setName("b");
        user1.setTime(time1);

        users.add(user);
        users.add(user1);

        Map<String, Long> stringLongMap = users.stream().collect(Collectors.groupingBy(User::formatTime, Collectors.counting()));
        System.out.println();
    }


}

@Data
class User {

    public LocalDateTime time;
    public String name;

    public String formatTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(time);
        return format;
    }
}

enum UnitEnum {
    YEAR("year", "年"),
    MONTH("month", "月"),
    WEEK("week", "周"),
    DAY("day", "日"),
    HOUR("hour", "时"),
    MINUTE("minute", "分"),
    SECOND("second", "秒"),
    ;

    private String key;
    private String value;

    UnitEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}