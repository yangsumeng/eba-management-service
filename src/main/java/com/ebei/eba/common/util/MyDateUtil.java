package com.ebei.eba.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Description: 时间工具类
 *
 * @author xu
 * @date:2018/5/2
 * @Copyright (c) 2018 一碑科技
 */
public class MyDateUtil {
    private final static String YEAR = "yyyy";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String getThisYear()throws Exception{
        return new SimpleDateFormat(YEAR).format(new Date());
    }

    public static Date convertToTimes(String value) throws ParseException {
        return new SimpleDateFormat(DATE_FORMAT).parse(value);
    }
    /**
     * 增加天数
     *
     * @param date
     * @param n
     * @return
     */
    public static String ADD_DAY(String date, int n) {
        return MyDateUtil.ADD_DATE(Calendar.DATE, date, n);
    }
    /**
     * 增加天数
     *
     * @param date
     * @param n
     * @return
     */
    public static Date ADD_DAY(Date date, int n) {
        return MyDateUtil.ADD_DATE(date, n);
    }
    private static Date ADD_DATE( Date date, int num) {
        Calendar calendar  =   Calendar.getInstance();
        calendar.setTime(date); //需要将date数据转移到Calender对象中操作
        calendar.add(calendar.DATE, num);//把日期往后增加n天.正数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
        return date;
    }
    private static String ADD_DATE(int optype, String date, int num) {
        String st_return = "";
        try {
            DateFormat daf_date = DateFormat.getDateInstance(DateFormat.MEDIUM,
                    Locale.CHINA);
            daf_date.parse(date);
            Calendar calendar = daf_date.getCalendar();
            calendar.add(optype, num);
            String st_m = "";
            String st_d = "";
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DAY_OF_MONTH);
            if (m <= 9) {
                st_m = "0" + m;
            } else {
                st_m = "" + m;
            }
            if (d <= 9) {
                st_d = "0" + d;
            } else {
                st_d = "" + d;
            }
            st_return = y + "-" + st_m + "-" + st_d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return st_return;
    }
    public static void main(String args[]){
       // System.out.println(ADD_DATE(new Date(),2));
    }
}
