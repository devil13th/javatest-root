package com.thd.base64;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * com.thd.base64.T
 *
 * @author: wanglei62
 * @DATE: 2020/12/22 17:45
 **/
public class T {

    public static int daysBetween(Date smdate, Date bdate) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     　　 *字符串的日期格式的计算
     　　 */
    public static int daysBetween(String smdate,String bdate) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static void main(String[] args) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date n = sdf.parse("2020-12-22 21:21:21");
        Date to = sdf.parse("2020-11-22 01:01:01");

        System.out.println(T.daysBetween(n,to));
        System.out.println(T.daysBetween(to,n));
    }
}
