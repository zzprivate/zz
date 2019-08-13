package com.nplat.convert.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class myDate {

    public static final SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 计算两个日期之间相差的天数
     *
     * @param startDate 较小的时间
     * @param endDate   较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date startDate, Date endDate)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        startDate = sdf.parse(sdf.format(startDate));
        endDate = sdf.parse(sdf.format(endDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期间隔并返回精确的  天  时  分  秒  毫秒  值，为字符串形式返回
     * 例如   12天3小时23分24秒34毫秒
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getDateDiff(Date startDate, Date endDate) {
        long between = 0;
        try {
            Date begin = startDate;
            Date end = endDate;
            between = (end.getTime() - begin.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                - min * 60 * 1000 - s * 1000);
        return (day + "天" + hour + "小时" + min + "分" + s + "秒" + ms
                + "毫秒");
    }

    /**
     * 获取当前日期时间
     *
     * @return 返回2016-2-23 10:23:43  格式的当前日期时间
     */
    public static String getDateTimeStrNow() {
        return simpledateformat.format(new Date());
    }

    /**
     * 获取当前日期
     *
     * @return 返回 2016-2-23  格式的当前日期
     */
    public static String getDateStrNow() {
        return simpleDate.format(new Date());
    }

    /**
     * 获取前一天日期
     *
     * @return 返回 2016-2-23  格式的当前日期
     */
    public static String getDateStrYesterday() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE,-1);
        return simpleDate.format(now.getTime());
    }

    /**
     * 格式化日期时间
     *
     * @param date
     * @return 返回 2016-2-23 10:23:43  格式的日期时间
     */
    public static String getDateTimeStrWithDate(Date date) {
        return simpledateformat.format(date);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return 返回 2016-2-23  格式的日期
     */
    public static String getDateStrWithDate(Date date) {
        return simpleDate.format(date);
    }

    /**
     * 获取制定日期之前或者之后几天的日期对象
     *
     * @param date 指定日期
     * @param days 正数为指定日期后days天，负数为指定日期之前days天
     * @return 返回Date对象
     */
    public static Date getRollDate(Date date, int days) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
        return now.getTime();
    }

    /**
     * 根据字符串获取格式化日期
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date getDateWithStr(String dateStr) throws ParseException {
        if (dateStr.length() > 10)
            return simpledateformat.parse(dateStr);
        else
            return simpleDate.parse(dateStr);
    }

    /**
     * 根据生日算年龄
     *
     * @param birthDay
     * @return
     * @throws Exception
     */
    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            } else {
                age--;
            }
        }
        return age;
    }
}
