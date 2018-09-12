package com.ebei.eba.common.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class DateUtils
{
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    
    private static final String MONTH_DAT_FORMAT = "MM-dd";
    
    private static final String MONTH_FORMAT = "yyyy-MM";
    
    private static final String SHOUT_MONTH_FORMAT = "yyyy-M";
    
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    private static final String HMS_FORMAT = "HH:mm:ss";
    
    public static final String HM_FORMAT = "HH:mm";
    
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
    
    private static final String DATETIMEHM_FORMAT = "yyyyMMddHHmm";
    
    private static final String FILE_FORMAT = "yyyyMMdd";
    
    private static final String CHINADATE_FORMAT = "yyyy年M月dd日";
    
    private static final String DATETIMEHMS_FORMAT = "yyyyMMddHHmmss";
    
    private static final String TIME_FORMAT_ALL = "yyyy-MM-dd HH:mm:ss SSS";
    
    private static final String TIME_FORMAT_VERSION = "yyyyMMddHHmmssSSS";
    
    private static final String CHINADATETIME_FORMAT = "yyyy年MM月dd日HH时mm分ss秒";
    
    private static final String CHINADATETIME_FORMAT2 = "yyyy年MM月dd日 HH时mm分";
    
    public static final String DAY = "day";
    
    public static final String WEEK = "week";
    
    public static final String MONTH = "month";
    
    public static final String START = "start";
    
    public static final String END = "end";
    
    private static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    
    private static Map<Integer, String> weekMap = Collections.synchronizedMap(new HashMap<Integer, String>());
    
    static
    {
        weekMap.put(1, "星期一");
        weekMap.put(2, "星期二");
        weekMap.put(3, "星期三");
        weekMap.put(4, "星期四");
        weekMap.put(5, "星期五");
        weekMap.put(6, "星期六");
        weekMap.put(7, "星期日");
    }
    
    public static Date parseMonthDay(String value)
        throws ParseException
    {
        return new SimpleDateFormat(MONTH_DAT_FORMAT).parse(value);
    }
    
    public static String convertToDateTime(Date date)
    {
        return new SimpleDateFormat(DATETIME_FORMAT).format(date);
    }
    
    public static Date convertStringToDate(String date)
        throws ParseException
    {
        return new SimpleDateFormat(DATETIME_FORMAT).parse(date);
    }
    
    public static Date convertToDateTime(String value)
        throws ParseException
    {
        return new SimpleDateFormat(DATETIME_FORMAT).parse(value);
    }
    
    public static Date convertToTime(String value)
    {
        Date date = null;
        try
        {
            date = new SimpleDateFormat(TIME_FORMAT).parse(value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return date;
    }
    
    public static String convertToMonth(Date date)
    {
        return new SimpleDateFormat(MONTH_FORMAT).format(date);
    }
    
    public static String convertToShoutMonth(Date date)
    {
        return new SimpleDateFormat(SHOUT_MONTH_FORMAT).format(date);
    }
    
    public static Date convertToMonth(String value)
        throws ParseException
    {
        return new SimpleDateFormat(MONTH_FORMAT).parse(value);
    }
    
    public static Date convertToDateTimeHMS(String value)
        throws ParseException
    {
        return new SimpleDateFormat(DATETIMEHMS_FORMAT).parse(value);
    }
    
    public static Date convertToTimes(String value)
        throws ParseException
    {
        return new SimpleDateFormat(DATE_FORMAT).parse(value);
    }
    
    public static Date convertToyyyyMMdd(String value)
    {
        Date date = null;
        try
        {
            if (ObjectUtils.isNotEmpty(value))
            {
                date = new SimpleDateFormat(DATE_FORMAT).parse(value);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return date;
    }
    
    public static Date convertToTimes(String dateFormat, String value)
        throws ParseException
    {
        return new SimpleDateFormat(dateFormat).parse(value);
    }
    
    public static String convertToDate(Date date)
    {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }
    
    public static String convertToDateMonDay(Date date)
    {
        return new SimpleDateFormat(MONTH_DAT_FORMAT).format(date);
    }
    
    public static Date parseDate(String value)
        throws ParseException
    {
        return new SimpleDateFormat(DATE_FORMAT).parse(value);
    }
    
    public static Date parseTime(String value)
            throws ParseException
        {
            return new SimpleDateFormat(TIME_FORMAT).parse(value);
        }
    
    public static String convertToTime(Date date)
    {
        if (ObjectUtils.isNull(date))
        {
            return "";
        }
        return new SimpleDateFormat(TIME_FORMAT).format(date);
    }
    
    public static String convertToTime(String timeFormat, Date date)
    {
        return new SimpleDateFormat(timeFormat).format(date);
    }
    
    public static String convertToAllTime(Date date)
    {
        return new SimpleDateFormat(TIME_FORMAT_ALL).format(date);
    }
    
    public static String convertToVersion(Date date)
    {
        return new SimpleDateFormat(TIME_FORMAT_VERSION).format(date);
    }
    
    public static String convertToChinaDateTime(Date date)
    {
        return new SimpleDateFormat(CHINADATETIME_FORMAT).format(date);
    }
    
    public static String convertToChinaDateTime2(Date date)
    {
        return new SimpleDateFormat(CHINADATETIME_FORMAT2).format(date);
    }
    
    public static String convertToYearMonth(Date date)
    {
        return new SimpleDateFormat(YEAR_MONTH_FORMAT).format(date);
    }
    
    /**
     * 
     * Discription :获取时间的时分秒字符串
     * 
     * @param date
     * @return String
     * @throws
     * @author : shendx
     */
    public static String convertToHMS(Date date)
    {
        return new SimpleDateFormat(HMS_FORMAT).format(date);
    }
    
    public static String convertToTimeHM(Date date)
    {
        return new SimpleDateFormat(DATETIMEHM_FORMAT).format(date);
    }
    
    public static String getFormatToday4File(Date date)
    {
        return new SimpleDateFormat(FILE_FORMAT).format(date);
    }
    
    public static String dayForWeek(Date pTime)
    {
        
        String chinaDate = new SimpleDateFormat(CHINADATE_FORMAT).format(pTime);
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1)
        {
            dayForWeek = 7;
        }
        else
        {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return chinaDate + " " + weekMap.get(dayForWeek);
    }
    
    public static String getWeek(Date pTime)
    {
        
        String chinaDate = new SimpleDateFormat(CHINADATE_FORMAT).format(pTime);
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1)
        {
            dayForWeek = 7;
        }
        else
        {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return weekMap.get(dayForWeek);
    }
    
    public static int getWeekDay(Date pTime)
    {
        
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1)
        {
            dayForWeek = 7;
        }
        else
        {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
    
    public static Date getFutureDateByDayNum(int num, Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(c.DATE, num);
        return c.getTime();
    }
    
    public static String convertToDateHMS(Date date)
    {
        return new SimpleDateFormat(DATETIMEHMS_FORMAT).format(date);
    }
    
    public static String getYear(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.YEAR));
        
    }
    
    public static String getMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.MONTH));
        
    }
    
    /**
     * getMonth 的扩展方法 从1开始 <一句话功能简述> <功能详细描述>
     * 
     * @param date
     * @return
     */
    public static String getMonthStartOne(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.MONTH) + 1);
    }
    
    /**
     * 
     * Discription :比较日期 startDate是否早于endDate
     * 
     * @param startDate
     * @param endDate
     * @return boolean
     * @throws
     * @author : shendx
     * @date 2013-11-22 上午9:50:42
     */
    public static boolean isBeforeDateCompare(Date startDate, Date endDate)
    {
        boolean isBefore = false;
        try
        {
            if (startDate.before(endDate))
                isBefore = true;
        }
        catch (Exception e)
        {
            isBefore = false;
            e.printStackTrace();
        }
        return isBefore;
    }
    
    /**
     * 
     * Discription :比较日期 startDate是否晚于endDate
     * 
     * @param startDate
     * @param endDate
     * @return boolean
     * @throws
     * @author : shendx
     * @date 2013-11-22 上午9:50:42
     */
    public static boolean isAfterDateCompare(Date startDate, Date endDate)
    {
        boolean isBefore = false;
        try
        {
            if (startDate.after(endDate))
                isBefore = true;
        }
        catch (Exception e)
        {
            isBefore = false;
            e.printStackTrace();
        }
        return isBefore;
    }
    
    /**
     * 
     * Discription :比较两个日期
     * 
     * @param
     * @param
     * @return 0 表示相等 -1表示 start小于end 1表示start大于end int
     * @throws
     * @author : shendx
     * @date 2013-11-22 上午9:55:53
     */
    public static int dateCompare(Date startDate, Date endDate)
    {
        int result = 0;
        try
        {
            result = startDate.compareTo(endDate);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String getDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }
    
    public static long subDate(Date startDate, Date endDate)
    {
        long timeNow = startDate.getTime();
        long timeOld = endDate.getTime();
        long day = (timeNow - timeOld) / (1000 * 60 * 60 * 24);// 化为天
        return day;
    }
    
    /**
     * 
     * Discription : 获取两个时间相差的天数（值为double类型，scale为有效小数点）
     * 
     * @param
     * @param
     * @param
     * @return double
     * @author : han
     */
    public static double subDate(Date startDate, Date endDate, int scale)
    {
        long timeNow = startDate.getTime();
        long timeOld = endDate.getTime();
        double day = NumericalUtil.divide(timeNow - timeOld, 1000 * 60 * 60 * 24, scale);// 化为天
        return day;
    }
    
    /**
     * 
     * Discription : 获取两个时间的分钟差startDate 开始时间 endDate 结束时间（值为double类型，scale为有效小数点）
     * 
     * @param
     * @param
     * @return long
     * @throws
     * @author : Zhough
     */
    public static double subMinute(Date startDate, Date endDate, int scale)
    {
        long endTime = endDate.getTime();
        long startTime = startDate.getTime();
        double minute = NumericalUtil.divide(endTime - startTime, 1000 * 60, scale);// 化为分钟
        return minute;
    }
    
    /**
     * 
     * Discription : 获取格式化的当前日期（yyyy-MM-dd）
     * 
     * @return Date
     * @throws
     * @throws
     * @author : Wuyk
     */
    public static Date getCurrFormatDate()
    {
        Calendar calendar = Calendar.getInstance();
        String dateStr =
            calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);
        Date date = null;
        try
        {
            date = new SimpleDateFormat(DATE_FORMAT).parse(dateStr);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * 
     * Discription : 获取格式化的昨天日期（yyyy-MM-dd）
     * 
     * @return Date
     * @throws ParseException
     * @throws
     * @author : Wuyk
     */
    public static Date getYestFormatDate()
        throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        String temp =
            calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);
        return new SimpleDateFormat(DATE_FORMAT).parse(temp);
    }
    
    /**
     * 
     * Discription : 指定日期增加指定天数
     * 
     * @param endDate
     * @param i
     * @return Date
     * @throws ParseException
     * @throws
     * @author : Wuyk
     */
    public static Date addDate(Date endDate, int i)
        throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.DATE, i);
        String temp =
            calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);
        return new SimpleDateFormat(DATE_FORMAT).parse(temp);
    }
    
    /**
     * 
     * Discription :指定日期增加指定小时
     * 
     * @param endDate
     * @param i
     * @return
     * @throws ParseException Date
     * @throws
     * @author : shendx
     */
    public static Date addHours(Date endDate, int i)
        throws ParseException
    {
        endDate.setHours(endDate.getHours() + i);
        return endDate;
    }
    
    /**
     * 
     * Discription : 获取月份的第一天
     * 
     * @param month
     * @return
     * @throws ParseException String
     * @throws
     * @author : Zhough
     */
    public static String getMonStartDay(String month)
        throws ParseException
    {
        String startDate = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parseDate(month + "-01"));
        startDate = DateUtils.convertToDate(calendar.getTime()) + " 00:00:00";
        return startDate;
    }
    
    /**
     * 
     * Discription : 获取月份的最后一天
     * 
     * @param month
     * @return
     * @throws ParseException String
     * @throws
     * @author : Zhough
     */
    public static String getMonEndDay(String month)
        throws ParseException
    {
        String endDate = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parseDate(month + "-01"));
        calendar.roll(Calendar.DATE, -1);
        endDate = DateUtils.convertToDate(calendar.getTime()) + " 23:59:59";
        return endDate;
    }
    
    /**
     * 
     * Discription : 获取当前的年份，并且获取指定月份的最后一天
     * 
     * @param
     * @return
     * @throws ParseException String
     * @throws
     * @author : shendx
     * @date 2013-12-13 上午11:37:46
     */
    public static String getMonLastDay(String month)
        throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parseDate(calendar.get(Calendar.YEAR) + "-" + month + "-01"));
        calendar.roll(Calendar.DATE, -1);
        return ConvertUtil.convert(calendar.get(Calendar.DAY_OF_MONTH), "30");
    }
    
    /**
     * 
     * Discription : 计算两个日期相差月份

     * @return int

     * @throws
     * @author : Wuyk
     */
    public static int getTimeInervalOfMonth(String monthVal1, String monthVal2)
        throws ParseException
    {
        int timeInterval = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(monthVal1));
        c2.setTime(sdf.parse(monthVal2));
        
        timeInterval =
            (c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH) + 1) + (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR))
                * 12;
        
        return timeInterval;
    }
    
    public static int getTimeInervalOfMonth(Date firstDate, Date lastDate)
        throws ParseException
    {
        String monthVal1 = convertToTime(firstDate);
        String monthVal2 = convertToTime(lastDate);
        return getTimeInervalOfMonth(monthVal1, monthVal2);
    }
    
    /**
     * 
     * Discription : 取月份的天数
     * 
     * @param flag
     * @param nowMonth
     * @return String
     * @throws
     * @author : Zhough
     */
    public static String countMonthDate(String flag, String nowMonth)
    {
        String[] times = nowMonth.split("\\-");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.valueOf(times[0]), (Integer.valueOf(times[1]) - 1), 1);
        if ("last".equals(flag))
        {
            // 当前月的最后一天
            cal.roll(Calendar.DATE, -1);
        }
        String d = DateUtils.convertToDate(cal.getTime());
        return d;
    }
    
    /**
     * 
     * Discription : 每个季度
     * 
     * @return Date
     * @throws
     * @author : Zhough
     */
    public static Date getFirstDayOfQua()
    {
        Calendar cal = Calendar.getInstance();
        Calendar quaDate = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth <= 3)
        { // 一季度
            quaDate.set(Calendar.MONTH, 0);
            quaDate.set(Calendar.DATE, 1);
            
        }
        else if (currentMonth >= 4 && currentMonth <= 6)
        {// 二季度
            quaDate.set(Calendar.MONTH, 3);
            quaDate.set(Calendar.DATE, 1);
            
        }
        else if (currentMonth >= 7 && currentMonth <= 9)
        {// 三季度
            quaDate.set(Calendar.MONTH, 6);
            quaDate.set(Calendar.DATE, 1);
            
        }
        else if (currentMonth >= 10 && currentMonth <= 12)
        {// 四季度
            quaDate.set(Calendar.MONTH, 9);
            quaDate.set(Calendar.DATE, 1);
            
        }
        
        Date quaFirstDate = parseTimeToDate(quaDate);
        
        return quaFirstDate;
    }
    
    public static Date parseTimeToDate(Calendar dtime)
    {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String temp = dtime.get(Calendar.YEAR) + "-" + (dtime.get(Calendar.MONTH) + 1) + "-" + dtime.get(Calendar.DATE);
        Date d = null;
        try
        {
            d = form.parse(temp);
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d;
    }
    
    /**
     * 
     * Discription : 判断参数时间是否在该月或之后
     * 
     * @param monthVal
     * @return boolean
     * @throws
     * @author : Zhough
     */
    public static boolean compareDateIfInThisMonthOrAfter(String monthVal)
        throws ParseException
    {
        boolean flag = false;
        Calendar calendar = Calendar.getInstance();
        String currMonthString = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-01";
        Date currMonth = DateUtils.parseDate(currMonthString);
        Date searchMonth = DateUtils.parseDate(monthVal);
        if (searchMonth.compareTo(currMonth) >= 0)
        {
            flag = true;
        }
        else
        {
            flag = false;
        }
        return flag;
    }
    
    /**
     * 
     * Discription : 将月份减去 subMonNum
     * 

     * @return Date
     * @throws
     * @author : shendx
     * @date 2014-4-8 上午10:30:42
     */
    public static Date subMoth(int subMonNum)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.MONTH, -subMonNum);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription : 将月份加 subMonNum
     * 

     * @return Date
     * @throws
     * @author : shendx
     * @date 2014-4-8 上午10:30:42
     */
    public static Date addMoth(int addMonNum)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.MONTH, addMonNum);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription :给指定的日期添加年份
     * 
     * @param addYearNum
     * @return
     * @throws Exception Date
     * @throws
     * @author : dison
     */
    public static Date addYear(Date date, int addYearNum)
        throws Exception
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, addYearNum);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription :
     * 
     * @see #addMoth(int)
     * @param date
     * @param addMonthNum
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date addMonth(Date date, int addMonthNum)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, addMonthNum);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription :周加减
     * 

     * @return Date
     * @throws
     * @author : dison
     */
    public static Date addWeek(Date date, int addWeekNum)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.WEEK_OF_YEAR, addWeekNum);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription :周加减
     * 

     * @throws
     * @author : dison
     */
    public static Date addDay(Date date, int addDayNum)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE, addDayNum);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription :秒加减
     * 

     * @return Date
     * @throws
     * @author : dison
     */
    public static Date addHour(Date date, int addHours)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.HOUR, addHours);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription :秒加减
     * 

     * @return Date
     * @throws
     * @author : dison
     */
    public static Date addSecond(Date date, int addSecNum)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.SECOND, addSecNum);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription : 获取与当前相差天数的时间
     * 

     * @author : han
     */
    public static Date getDayByBetVal(int betVal)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.DAY_OF_YEAR, betVal);
        return new Date(rightNow.getTimeInMillis());
    }
    
    /**
     * 
     * Discription : 获取当前的季度
     * 

     * @return int
     * @throws
     * @author : Zhough
     */
    public static int getQuaNumByCal(int currentMonth)
    {
        int quaNum = 0;
        if (currentMonth >= 1 && currentMonth <= 3)
        { // 一季度
            quaNum = 1;
        }
        else if (currentMonth >= 4 && currentMonth <= 6)
        {// 二季度
            quaNum = 2;
        }
        else if (currentMonth >= 7 && currentMonth <= 9)
        {// 三季度
            quaNum = 3;
        }
        else if (currentMonth >= 10 && currentMonth <= 12)
        {// 四季度
            quaNum = 4;
        }
        return quaNum;
    }
    
    /**
     * 
     * Discription : 返回两个时间相差的小时数，保留两位小数
     * 
     * @param firstDay
     * @param lastDay
     * @return double
     * @throws
     * @author : Zhough
     */
    public static double getHourByTwoDate(Date firstDay, Date lastDay)
    {
        long l = lastDay.getTime() - firstDay.getTime();
        double hour = NumericalUtil.divide(l / (60 * 1000), 60, 2);
        return hour;
    }
    
    public static double getMinuteByTowDate(Date firstDay, Date lastDay)
    {
        long l = lastDay.getTime() - firstDay.getTime();
        double minute = NumericalUtil.divide(l / 1000, 60.0, 2);
        return minute;
    }
    
    public static long getDaysBetweenTwoDate(String fromDate, String toDate)
        throws Exception
    {
        long from = parseDate(fromDate).getTime();
        long to = parseDate(toDate).getTime();
        long days = (to - from) / (1000 * 60 * 60 * 24); // 1-31相差30天
        days += 1; // 1-31 实为31天
        return days;
    }
    
    /**
     * 
     * Discription :判断日期字符串类型是否合法
     * 
     * @param dateString
     * @return
     * @throws Exception boolean
     * @throws
     * @author : shendx
     */
    public static boolean isValidDate(String dateString)
        throws Exception
    {
        
        return isValidDates(dateString);
    }
    
    /**
     * 
     * Discription : hql查询时间区间模板 hql查询为大于或等于startdate,小于enddate(enddate会加一天)
     * 
     * @param startDate
     * @param endDate
     * @param map map有default属性,就不设置默认值
     * @throws ParseException String 返回值为startDate+":"+endDate
     * @throws
     * @author : fh
     */
    public static String finishStartAndEndDateCQR(String startDate, String endDate, Map map)
        throws ParseException
    {
        startDate = startDate == null || startDate.equals("null") ? "" : startDate;
        endDate = endDate == null || endDate.equals("null") ? "" : endDate;
        if (map.get("default") == null && startDate.length() == 0)
        {
            Calendar cal = Calendar.getInstance();
            Date date = countMonthDate("firstday");
            cal.setTime(DateUtils.parseDate(DateUtils.convertToDate(date)));
            map.put("startDate", cal.getTime());
            startDate = DateUtils.convertToDate(cal.getTime());
        }
        else if (startDate.length() > 0)
        {
            map.put("startDate", startDate);
        }
        if (map.get("default") == null && endDate.length() == 0)
        {
            Calendar date = Calendar.getInstance();
            date.setTime(DateUtils.parseDate(DateUtils.convertToDate(date.getTime())));
            endDate = DateUtils.convertToDate(date.getTime());
            date.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", date.getTime());
        }
        else if (endDate.length() > 0)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtils.parseDate(endDate));
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", endDate);
        }
        return startDate + ":" + endDate;
    }
    
    public static boolean isValidDates(String dateString)
        throws Exception
    {
        
        boolean isValidDate = true;
        try
        {
            convertToTimes(dateString);
        }
        catch (Exception e)
        {
            try
            {
                parseDate(dateString);
            }
            catch (Exception e1)
            {
                isValidDate = false;
            }
        }
        return isValidDate;
    }
    
    /**
     * 
     * Discription :校验字符串时间（年月日格式）是否合法
     * 
     * @param dateString
     * @return
     * @throws Exception boolean
     * @throws
     * @author : dison
     */
    public static boolean isValidDateYMD(String dateString)
        throws Exception
    {
        boolean isValidDate = true;
        try
        {
            parseDate(dateString);
        }
        catch (Exception e)
        {
            isValidDate = false;
        }
        return isValidDate;
    }
    
    /**
     * 
     * Discription : hql查询时间区间模板 hql查询为大于或等于startdate,小于enddate(enddate会加一天)
     * 
     * @param startDate
     * @param endDate
     * @param map map有default属性,就不设置默认值
     * @throws ParseException String 返回值为startDate+":"+endDate
     * @throws
     * @author : fh
     */
    public static String finishStartAndEndDate(String startDate, String endDate, Map map)
        throws ParseException
    {
        startDate = startDate == null || startDate.equals("null") ? "" : startDate;
        endDate = endDate == null || endDate.equals("null") ? "" : endDate;
        if (map.get("default") == null && startDate.length() == 0)
        {
            Calendar cal = Calendar.getInstance();
            Date date = countMonthDate("firstday");
            cal.setTime(DateUtils.parseDate(DateUtils.convertToDate(date)));
            map.put("startDate", cal.getTime());
            startDate = DateUtils.convertToDate(cal.getTime());
        }
        else if (startDate.length() > 0)
        {
            map.put("startDate", DateUtils.parseDate(startDate));
        }
        if (map.get("default") == null && endDate.length() == 0)
        {
            Calendar date = Calendar.getInstance();
            date.setTime(DateUtils.parseDate(DateUtils.convertToDate(date.getTime())));
            endDate = DateUtils.convertToDate(date.getTime());
            date.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", date.getTime());
        }
        else if (endDate.length() > 0)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtils.parseDate(endDate));
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", cal.getTime());
        }
        return startDate + ":" + endDate;
    }
    
    /**
     * @Description 计算当前月的第一天或者最后一天
     * 
     * @param flag
     * @return date
     */
    public static Date countMonthDate(String flag)
    {
        Calendar cal = Calendar.getInstance();
        // 当前月的第一天
        cal.set(Calendar.DATE, 1);
        if ("last".equals(flag))
        {
            // 当前月的最后一天
            cal.roll(Calendar.DATE, -1);
        }
        Date d = cal.getTime();
        return d;
    }
    
    /**
     * 
     * Discription : 获取月份的最后一天
     * 
     * @param betVal
     * @return Date
     * @author : han
     */
    public static Date getMonthLastDay(int betVal)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, betVal);
        cal.roll(Calendar.DATE, -1);
        return cal.getTime();
    }
    
    public static Date getMonthFirstDay(int betVal)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, betVal);
        cal.set(Calendar.DATE, 1);
        return cal.getTime();
    }
    
    /**
     * 
     * Discription : 根据标识获取时间
     * 
     * @param duration (day:当天，week:当周，month:当月)
     * @param flag (start:初，end:末)
     * @return Date (格式：yyyy-MM-dd)
     * @author : han
     */
    public static Date getDateByCurrDuration(String duration, String flag)
    {
        Calendar cal = Calendar.getInstance();
        if (DateUtils.DAY.equals(duration))
        {
            
        }
        else if (DateUtils.WEEK.equals(duration))
        {
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            if (DateUtils.END.equals(flag))
            {
                cal.add(Calendar.DATE, 6);
            }
        }
        else if (DateUtils.MONTH.equals(duration))
        {
            cal.set(Calendar.DATE, 1);
            if (DateUtils.END.equals(flag))
            {
                cal.roll(Calendar.DATE, -1);
            }
        }
        
        return cal.getTime();
    }
    
    /**
     * 
     * Discription : 获取时间区间的时间字符串（yyyy-MM-dd）
     * 
     * @param duration
     * @param flag
     * @return String
     * @author : han
     */
    public static String getDateStringByCurrDuration(String duration, String flag)
    {
        return DateUtils.convertToDate(DateUtils.getDateByCurrDuration(duration, flag));
    }
    
    /**
     * 
     * Discription : 是否为一个星期的某天
     * 
     * @param day
     * @return boolean
     * @author : han
     */
    public static boolean ifWhichDayOfWeek(int day)
    {
        boolean flag = false;
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == day)
        {
            flag = true;
        }
        return flag;
    }
    
    /**
     * 
     * Discription : 判断当前时间是否在条件时间区间内
     * 
     * @param begin （类型：字符串，格式：HH:mm）
     * @param end （类型：字符串，格式：HH:mm）
     * @return boolean
     * @author : han
     */
    public static boolean ifBetweenTimeRegion(String begin, String end)
    {
        boolean flag = false;
        try
        {
            if (ValidateUtil.stringIsEmpty(begin) || ValidateUtil.stringIsEmpty(end))
            {
                return false;
            }
            
            int begin_hour = Integer.valueOf(begin.split(":")[0]);
            int begin_minute = Integer.valueOf(begin.split(":")[1]);
            int end_hour = Integer.valueOf(end.split(":")[0]);
            int end_minute = Integer.valueOf(end.split(":")[1]);
            int begin_all_minute = begin_hour * 60 + begin_minute;
            int end_all_minute = end_hour * 60 + end_minute;
            
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int curr_all_minute = hour * 60 + minute;
            // 1:结束时间比开始时间大（都在当天） 2:结束时间比开始时间小(结束时间在第二天)
            if (end_all_minute > begin_all_minute)
            {
                if (curr_all_minute >= begin_all_minute && curr_all_minute <= end_all_minute)
                {
                    flag = true;
                }
            }
            else
            {
                if (curr_all_minute >= begin_all_minute || curr_all_minute <= end_all_minute)
                {
                    flag = true;
                }
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }
    
    /**
     * 
     * Discription :获取当前时间周的最后一天（星期日）时间
     * 
     * @param currDate
     * @return
     * @throws Exception Date
     * @throws
     * @author : shendx
     */
    public static Date getWeekLastDay(Date currDate)
        throws Exception
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        // 1周的第一天
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        // 1周的最后一天
        cal.add(Calendar.DATE, 6);
        
        return parseDate(convertToDate(cal.getTime()));
    }
    
    /**
     * 
     * Discription : 获取当前时间周的第一天（星期一）时间
     * 
     * @param currDate
     * @return
     * @throws Exception Date
     * @throws
     * @author : shendx
     */
    public static Date getWeekFristDay(Date currDate)
        throws Exception
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.add(Calendar.DATE, 0);
        
        return parseDate(convertToDate(cal.getTime()));
    }
    
    /**
     * 
     * Discription :获取指定时间的一个月的最后一天
     * 
     * @param currDate
     * @return
     * @throws Exception Date
     * @throws
     * @author : shendx
     */
    public static Date getMonthLastDay(Date currDate)
        throws Exception
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        
        return parseDate(convertToDate(cal.getTime()));
    }
    
    /**
     * 
     * Discription :获取指定时间的一个月的第一天
     * 
     * @param currDate
     * @return
     * @throws Exception Date
     * @throws
     * @author : shendx
     */
    public static Date getMonthFristDay(Date currDate)
        throws Exception
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.DATE, 1);
        
        return parseDate(convertToDate(cal.getTime()));
    }
    
    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return int
     * @throws Exception
     * @author : Wei,Sun
     */
    public static int daysBetween(Date smdate, Date bdate)
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days)) + 1;
    }
    
    /**
     * 
     * Discription :获取指定时间的月总天数
     * 
     * @param currDate
     * @return int
     * @throws Exception
     * @author : Wei,Sun
     */
    public static int getDaysForMonth(Date currDate)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }
    
    /**
     * 
     * Discription : 得到当前日期所在季度最后一天
     * 
     * @param date
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getCurrentQuarterEndTime(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try
        {
            if (currentMonth >= 1 && currentMonth <= 3)
            {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            }
            else if (currentMonth >= 4 && currentMonth <= 6)
            {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            }
            else if (currentMonth >= 7 && currentMonth <= 9)
            {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            }
            else if (currentMonth >= 10 && currentMonth <= 12)
            {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return now;
    }
    
    /**
     * 
     * Discription : 得到当前日期所在季度的第一天
     * 
     * @param date
     * @param isContainDay 是否需要把天设为1
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getCurrentQuarterStartTime(Date date, Boolean isContainDay)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try
        {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            if (isContainDay)
            {
                c.set(Calendar.DATE, 1);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return now;
    }
    
    /**
     * 
     * Discription : 获取当前时间所在半年的第一天
     * 
     * @param date
     * @param isContainDay 是否需要把天设为1
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getHalfYearStartTime(Date date, Boolean isContainDay)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try
        {
            if (currentMonth >= 1 && currentMonth <= 6)
            {
                c.set(Calendar.MONTH, 0);
            }
            else if (currentMonth >= 7 && currentMonth <= 12)
            {
                c.set(Calendar.MONTH, 6);
            }
            if (isContainDay)
            {
                c.set(Calendar.DATE, 1);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return now;
        
    }
    
    /**
     * 
     * Discription : 获取当前时间所在半年的最后一天
     * 
     * @param date
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getHalfYearEndTime(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try
        {
            if (currentMonth >= 1 && currentMonth <= 6)
            {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            }
            else if (currentMonth >= 7 && currentMonth <= 12)
            {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return now;
    }
    
    /**
     * 
     * Discription : 当前日期所在年的第一天
     * 
     * @param date
     * @param isContainDay 是否需要把天设为1
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getCurrentYearStartTime(Date date, Boolean isContainDay)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Date now = null;
        try
        {
            c.set(Calendar.MONTH, 0);
            if (isContainDay)
            {
                c.set(Calendar.DATE, 1);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return now;
    }
    
    /**
     * 
     * Discription : 当前日期所在年的最后一天
     * 
     * @param date
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getCurrentYearEndTime(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Date now = null;
        try
        {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return now;
    }
    
    /**
     * 
     * Discription : 得到几天前的时间
     * 

     * @return Date
     * @throws
     * @author : Wangxy
     */
    public static Date getDateBefore(Date d, int day)
    {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }
    
    /**
     * 
     * Discription : 得到几天后的时间
     * 
     * @param
     * @return Date
     * @throws
     * @author : Wangxy
     */
    public static Date getDateAfter(Date d, int day)
    {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }
    
    /**
     * 
     * Discription : hql查询时间区间模板 hql查询为大于或等于startdate,小于enddate(enddate会加一天)
     * 
     * @param startDate 精确到小时，分，秒
     * @param endDate
     * @param map map有default属性,就不设置默认值
     * @throws ParseException String 返回值为startDate+":"+endDate
     * @throws
     * @author : chenrh
     */
    public static String finishStartAndEndTime(String startDate, String endDate, Map map)
        throws ParseException
    {
        startDate = startDate == null || startDate.equals("null") ? "" : startDate;
        endDate = endDate == null || endDate.equals("null") ? "" : endDate;
        if (map.get("default") == null && startDate.length() == 0)
        {
            Calendar cal = Calendar.getInstance();
            Date date = countMonthDate("firstday");
            cal.setTime(DateUtils.convertToTime(DateUtils.convertToDate(date) + " 00:00:00"));
            map.put("startDate", cal.getTime());
            startDate = DateUtils.convertToDate(cal.getTime());
        }
        else if (startDate.length() > 0)
        {
            map.put("startDate", DateUtils.convertToTime(startDate + " 00:00:00"));
        }
        if (map.get("default") == null && endDate.length() == 0)
        {
            Calendar date = Calendar.getInstance();
            date.setTime(DateUtils.convertToTime(DateUtils.convertToDate(date.getTime()) + " 00:00:00"));
            endDate = DateUtils.convertToDate(date.getTime());
            date.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", date.getTime());
        }
        else if (endDate.length() > 0)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtils.convertToTime(endDate + " 00:00:00"));
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", cal.getTime());
        }
        return startDate + ":" + endDate;
    }
    
    /**
     * 
     * Discription : hql查询时间区间模板 hql查询为大于或等于startdate,小于enddate(enddate会加一天)
     * 
     * @param startDate 精确到小时，分，秒
     * @param endDate
     * @param map map有default属性,就不设置默认值
     * @throws ParseException String 返回值为startDate+":"+endDate
     * @throws
     * @author : chenrh
     */
    public static String finishStartAndEndCloseTime(String startDate, String endDate, Map map)
        throws ParseException
    {
        startDate = startDate == null || startDate.equals("null") ? "" : startDate;
        endDate = endDate == null || endDate.equals("null") ? "" : endDate;
        if (map.get("default") == null && startDate.length() == 0)
        {
            Calendar cal = Calendar.getInstance();
            Date date = countMonthDate("firstday");
            cal.setTime(DateUtils.convertToTime(DateUtils.convertToDate(date) + " 00:00:00"));
            map.put("startCloseDate", cal.getTime());
            startDate = DateUtils.convertToDate(cal.getTime());
        }
        else if (startDate.length() > 0)
        {
            map.put("startCloseDate", DateUtils.convertToTime(startDate));
        }
        if (map.get("default") == null && endDate.length() == 0)
        {
            Calendar date = Calendar.getInstance();
            date.setTime(DateUtils.convertToTime(DateUtils.convertToDate(date.getTime()) + " 00:00:00"));
            endDate = DateUtils.convertToDate(date.getTime());
            date.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endCloseDate", date.getTime());
        }
        else if (endDate.length() > 0)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtils.convertToTime(endDate));
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endCloseDate", cal.getTime());
        }
        return startDate + ":" + endDate;
    }
    
    /**
     * 
     * Discription : 两个日期相差的天数
     * 
     * @param date1
     * @param date2
     * @return
     * @throws ParseException int
     * @throws
     * @author : Wei,Sun
     */
    public static int getMonthSpace(String date1, String date2)
        throws ParseException
    {
        
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        
        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + 1;
        
        return Math.abs(result);
        
    }
    
    /**
     * 
     * Discription : 获取两个时间之间的时间差，返回天，时，分，秒
     * 
     * @param startDate
     * @param endDate
     * @return String
     * @throws
     * @author : Wangxy
     */
    public static String printDifference(Date startDate, Date endDate)
    {
        return printDifference(startDate, endDate, 0);
    }
    
    /**
     * 

     * @return
     */
    public static String printDifference(Date startDate, Date endDate, long lunchBreakMilli)
    {
        
        long different = endDate.getTime() - startDate.getTime();
        if (lunchBreakMilli > 0)
        {
            if (different > lunchBreakMilli)
            {
                different -= lunchBreakMilli;
            }
        }
        
        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);
        System.out.println("different : " + different);
        
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        
        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;
        
        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;
        
        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;
        
        long elapsedSeconds = different / secondsInMilli;
        
        System.out.printf("%d days, %d hours, %d minutes, %d seconds%n",
            elapsedDays,
            elapsedHours,
            elapsedMinutes,
            elapsedSeconds);
        return elapsedDays + "," + elapsedHours + "," + elapsedMinutes + "," + elapsedSeconds;
    }
    
    /**
     * 
     * Discription : 判断当前日期是否是月初
     * 
     * @return boolean
     * @throws
     * @author : han
     */
    public static boolean ifFirstDayOfMonth()
    {
        boolean flag = false;
        Calendar cal = Calendar.getInstance();
        // 判断是否为月份的1号
        if (cal.get(Calendar.DAY_OF_MONTH) == 1)
        {
            flag = true;
        }
        return flag;
    }
    
    /**
     * 
     * Discription : 获取指定日期的最后一天
     * 
     * @param currDate
     * @return
     * @throws Exception String
     * @throws
     * @author : hongxing
     */
    public static String getLastDay(String currDate)
        throws Exception
    {
        Date date = parseDate(currDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);
        
        return convertToDate(cal.getTime());
    }
    
    /**
     * 获取当前月的最后一天的日期
     * 
     * @author qsr
     * @param monthDay
     * @return
     */
    public static Date getThisMonthLastDay(Date monthDay)
    {
        // 复制当前月
        Date tempDate = new Date();
        tempDate.setTime(monthDay.getTime());
        tempDate.setDate(1);
        
        // 当前月份增加一个月
        int month = tempDate.getMonth();
        if (month == 11)// 当前月是最后一个月，则是下一年1月份
        {
            tempDate.setMonth(0);
            tempDate.setYear(tempDate.getYear() + 1);
        }
        else
        {
            tempDate.setMonth(month + 1);
        }
        
        // 减去一天
        long endDateTimeTemp = tempDate.getTime();
        long oneDayTime = 24 * 60 * 60 * 1000;// 一天的毫秒数
        long endDateTime = endDateTimeTemp - oneDayTime;// 月份加1后减去一天
        
        tempDate.setTime(endDateTime);
        
        return tempDate;
    }
    
    /**
     * 获取当前月的下一个月
     * 
     * @author qsr
     * @param date
     * @return
     */
    public static Date getNextMonth(Date date)
    {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.MONTH, 1);
        return cd.getTime();
    }
    
    /**
     * 根据日期获取月份
     * 
     * @author qsr
     * @param date
     * @return
     */
    public static Integer getMonthFromDate(Date date)
    {
        if (ObjectUtils.isNull(date))
        {
            return -1;
        }
        
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        
        int month = cd.get(Calendar.MONTH);
        
        return month;
    }
    
    /**
     * 获取指定月份的天数目
     * 
     * @author qsr
     * @param date
     * @return
     */
    public static int getMonthDayCount(Date date)
    {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        return cd.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 
     * Discription :是否在时间区间内容(包含)
     * 
     * @param startDate
     * @param date
     * @param endDate
     * @return
     * @throws Exception int
     * @date 2015-11-23 上午10:43:02
     * @throws
     * @author : dison
     */
    public static boolean isWithin(Date startDate, Date date, Date endDate)
        throws Exception
    {
        boolean isWithin = false;
        if (dateCompare(startDate, date) <= 0 && dateCompare(endDate, date) >= 0)
        {
            isWithin = true;
        }
        
        return isWithin;
    }
    
    /**
     * 
     * Discription :获取当年的第一天
     * 
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date getCurrYearFirst()
    {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }
    
    /**
     * 
     * Discription :获取当年的最后一天
     * 
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date getCurrYearLast()
    {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }
    
    /**
     * 
     * Discription :获取某年第一天日期
     * 
     * @param year
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date getYearFirst(int year)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }
    
    /**
     * 
     * Discription :获取某年最后一天日期
     * 
     * @param year
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date getYearLast(int year)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        
        return currYearLast;
    }
    
    /**
     * @description 把时间转化为字符串
     * @author qsr
     * @time 2016年3月25日
     * @param date
     * @param pattern
     * @return
     */
    public static String convertDateToString(Date date, String pattern)
    {
        if (date == null)
            return null;
        
        SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance();
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }
    
    public static String convertDateToString(Date date)
    {
        if (date == null)
            return null;
        
        SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    
    /**
     * @description 把时间字符串转化为时间

     * @return
     * @throws ParseException
     */
    public static Date convertStringToDate(String dateStr, String pattern)
    {
        Date date = new Date();
        try{
             date = new SimpleDateFormat(pattern).parse(dateStr);
        } catch(ParseException e){
        }
        return date;
    }
    
    public static String convertHourToString(Long hours)
    {
        return String.valueOf(hours);
    }
    
    /**
     * 获取当前时间所在月份的第一天时间
     * 
     * @author qsr
     * @param date
     * @return
     */
    public static Date getMonthFirstDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.DATE, 1);
        
        return calendar.getTime();
    }
    
    /**
     * 获取当前时间的上N个月份的第一天时间。时分秒毫秒为最小值
     * 
     * @author qsr
     * @param date
     * @param amount 上n个月份，大于0整数，0为当前月
     * @return
     */
    public static Date getMonthFirstDay(Date date, int amount)
    {
        if (amount < 0)
            amount = 0;
        else
            amount = 0 - amount;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        
        calendar.add(Calendar.MONTH, amount);// 回退月份
        calendar.set(Calendar.DATE, 1);// 设置第一天
        
        return calendar.getTime();
    }
    
    /**
     * 获取当前时间的上N个月份的最后一天时间。时分秒毫秒为最大值
     * 
     * @author qsr
     * @param date
     * @param amount 上n个月份，大于0整数，0为当前月
     * @return
     */
    public static Date getMonthLastDay(Date date, int amount)
    {
        if (amount < 0)
            amount = 0;
        else
            amount = 0 - amount;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        /*
         * calendar.set(Calendar.MILLISECOND, 0); calendar.set(Calendar.SECOND, 0); calendar.set(Calendar.MINUTE, 0);
         * calendar.set(Calendar.HOUR_OF_DAY, 0);
         */
        // calendar.set(Calendar.DATE,1);//先设置第一天
        calendar.add(Calendar.MONTH, amount);// 回退月份
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 设置最后一天
        
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        
        return calendar.getTime();
    }
    
    public static Object convertToHM(Date date)
    {
        return new SimpleDateFormat(HM_FORMAT).format(date);
    }
    
    /**
     * <<<<<<< .working 将Date时间转化为Unix时间戳
     * 
     * @param date
     * @return
     */
    public static String convertDateToUnixTime(Date date)
    {
        return String.valueOf(date.getTime() / 1000);
    }
    
    /**
     * 将Unix时间戳转化为时间
     * 
     * @param unixTime
     * @return
     */
    public static String convertUnixToDateString(String unixTime)
    {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(unixTime);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    
    /**
     * ======= 将字符串"1979-03-27"转换为"1979-03-27 00:00:00"的日期
     * 
     * @param value
     * @return
     * @throws ParseException
     */
    public static Date getDayStart(String value)
        throws ParseException
    {
        Date retDate = null;
        try
        {
            retDate = new SimpleDateFormat(TIME_FORMAT).parse(value);
        }
        catch (ParseException e)
        {
            retDate = new SimpleDateFormat(DATE_FORMAT).parse(value);
        }
        if (null != retDate)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(retDate);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            
            retDate = calendar.getTime();
        }
        return retDate;
    }
    
    /**
     * >>>>>>> .merge-right.r39041 将字符串"1979-03-27"转换为"1979-03-27 23:59:59"的日期
     * 
     * @param value
     * @return
     * @throws ParseException
     */
    public static Date getDayEnd(String value)
        throws ParseException
    {
        Date retDate = null;
        try
        {
            retDate = new SimpleDateFormat(TIME_FORMAT).parse(value);
        }
        catch (ParseException e)
        {
            retDate = new SimpleDateFormat(DATE_FORMAT).parse(value);
        }
        if (null != retDate)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(retDate);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            
            retDate = calendar.getTime();
        }
        return retDate;
    }
    
    /**
     * 将Date转换为XXXX年X月XX日
     * 
     * @param date
     * @return
     */
    public static String convertToChineseYMD(Date date)
    {
        return new SimpleDateFormat(CHINADATE_FORMAT).format(date);
    }
    
    public static String getCurrentFormatDate(String template)
    {
        return new SimpleDateFormat(template).format(new Date());
    }
    
    public static boolean isInTime(String sourceTime, String curTime)
    {
        if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":"))
        {
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
        if (curTime == null || !curTime.contains(":"))
        {
            throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
        }
        String[] args = sourceTime.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try
        {
            long now = sdf.parse(curTime).getTime();
            long start = sdf.parse(args[0]).getTime();
            long end = sdf.parse(args[1]).getTime();
            if (args[1].equals("00:00"))
            {
                args[1] = "24:00";
            }
            if (end < start)
            {
                if (now > end && now < start)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                if (now >= start && now <= end)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
    }
    
    /**
     * 相等则返回0,date大返回1,否则返回-1;
     * 
     * @param date
     * @param beComparedDate
     * @return
     */
    public static int compareDate(Date date, Date beComparedDate)
    {
        int res = date.compareTo(beComparedDate);
        return res;
    }
    
    /**
     * 注释见 {@link #xStreamDate(String, XStream)}
     * 
     * @param xstream
     */
    public static void xStreamDate(XStream xstream)
    {
        xStreamDate("yyyy-MM-dd HH:mm:ss", xstream);
    }
    
    /**
     * 当Object用{@link XStream}转换成XML时，设定Date的格式 若不调用此方法，XStream转换成xml时，date会默认为UTC格式。
     * 
     * @param dateFormat date格式 如:yyyy-MM-dd HH:mm:ss
     * @param xstream
     */
    public static void xStreamDate(String dateFormat, XStream xstream)
    {
        if (dateFormat == null || dateFormat.equals(""))
        {
            xstream.registerConverter(new DateConverter(TIME_FORMAT, null, TimeZone.getTimeZone("GMT+8")));
            return;
        }
        xstream.registerConverter(new DateConverter(dateFormat, null, TimeZone.getTimeZone("GMT+8")));
    }
    
    public static Date coverExcelDate(String turnDate)
    {   
        Date date = null;
        String resultValue = null;
        try
        {
            SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date = sdf1.parse(turnDate);
//            SimpleDateFormat sdf = new SimpleDateFormat(format);
//            resultValue = sdf.format(date);
//            System.out.println(resultValue);
        }
        catch (Exception e)
        {   
            date = convertToyyyyMMdd(turnDate);
            e.printStackTrace();
        }
        
        return date;
    }
    public static Date getTodayStartTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getTodayEndTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return  calendar.getTime();
    }
    
    public static String getTimeByMinute(int minute) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, minute);

        return new SimpleDateFormat(TIME_FORMAT).format(calendar.getTime());
    }
    
    /**
     * 判断时间是不是今天
     * @param date
     * @return    是返回true，不是返回false
     */
    public static boolean isToday(Date date) {
        //当前时间
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        //获取今天的日期
        String nowDay = sf.format(now);
        //对比的时间
        String day = sf.format(date);
        return day.equals(nowDay);
    }
    
    public static void main(String[] args)
    {   
        String turnDate = "Mon Mar 02 13:57:49 CST 2015";
        coverExcelDate(turnDate);
        
        System.out.println(isInTime("20:00-05:00", "23:00"));
        // System.out.println(isInTime("20:00-01:00", "00:00"));
        // System.out.println(isInTime("20:00-01:00", "03:00"));
        // System.out.println(isInTime("20:00-23:00", "03:00"));
        // System.out.println(isInTime("20:00-23:00", "22:00"));
        // System.out.println(isInTime("20:00-23:00", "18:00"));
        // System.out.println(isInTime("20:00-23:00", "20:00"));
        // System.out.println(isInTime("20:00-23:00", "23:00"));
    }
    
}
