package util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

/**
 * <p>
 * test
 * </p>
 *
 * @package: util
 * @description: test
 * @author: YZS650
 * @date: Created in 2021/11/9 13:35
 * @copyright: Copyright (c)2021
 * @version: V1.0
 * @modified: YZS650
 **/
public class DateUtilDemo {
    public static void main(String[] args) {
        String startDate = "2021-11-01";
        Date sd = Convert.toDate(startDate);

        String endDate = "2021-12-01";
        Date dd = Convert.toDate(endDate);


        String format = DateUtil.format(sd, "yyyy-MM-dd HH:mm:ss");
        System.out.println(format);

        ArrayList<Long> longArrayList = new ArrayList<>();
        Object[] objects = longArrayList.stream().filter(s -> s.equals(2)).toArray();

        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
            InetAddress localHost1 = Inet6Address.getLocalHost();
            System.out.println(localHost1.getAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
