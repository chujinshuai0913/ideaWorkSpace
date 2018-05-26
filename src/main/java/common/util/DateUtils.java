package common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    public static final String YMD = "yyyy-MM-dd";
    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String KEY_INT_STARTTIME = "intStarttime";
    public static final String KEY_STR_STARTTIME = "strStarttime";
    public static final String KEY_INT_ENDTIME = "intEndtime";
    public static final String KEY_STR_ENDTIME = "strEndtime";

    public DateUtils() {
    }

	/**
     * 根据传入的时间字符串，获得unix对应的时间戳格式
     * 
     * @author liuqiang(liuqang@meicai.cn) 
     * 2016年3月12日
     * @param day
     * @return
     */
    public static Integer getDayUnixTimeStamp(String day) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = df.parse(day);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            long timestamp = cal.getTimeInMillis();
            return Integer.valueOf((int) (timestamp / 1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 将日期转换为 时间戳
     * @author yangweiqiang 2016.12.01
     * @param date
     * @return
     */
    public static Integer getDayUnixTimeStamp(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String day = df.format(date);
        return getDayUnixTimeStamp(day);
    }

    /**
     * 获取当天日期的unix时间戳
     * 
     * @author liuqiang(liuqiang@meicai.cn) 
     * 2016年3月12日
     * @return
     */
    public static Integer getTodayUnixTimeStamp() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String day = df.format(date);
        return getDayUnixTimeStamp(day);
    }
    

    public static Integer getNowTimeStamp() {
        Integer now = 0;
        Long time = System.currentTimeMillis() / 1000;
        now = time.intValue();
        return now;
    }

    /**
     * 描述: 将秒转换为指定格式化的日期
     * @author yangweiqiang
     * @param timeStamp 秒数
     * @param format 格式化 yyyy-MM-dd等
     * @date   2016/8/15
     */
    public static String getFormatDate(Integer timeStamp,SimpleDateFormat format){
        return format.format(new Date(timeStamp * 1000L));
    }

    /**
     * 获取某月最大的天数
     * @param time 日期
     * @param format 日期格式化类型
     * @return 实际最大天数
     */
    public static int getMaxDayOfMonth(String time,SimpleDateFormat format){
        try {
            Date date = format.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 获取昨天的时间戳
     * @return
     */
    public static int getPreDayByToday(Integer days){
        return getTodayUnixTimeStamp() + 86400 * days;
    }

    /**
     * 获取指定天的推迟天时间戳
     * @param time
     * @param days
     * @return
     */
    public static int getPreDayBy(Integer time,Integer days){
        return time + 86400 * days;
    }

    /**
     * 获取指定天的推迟天时间戳
     * @param time
     * @param days 增加的天数
     * @return
     */
    public static int getPreDayBy(String time,Integer days){
        return getDayUnixTimeStamp(time) + 86400 * days;
    }

    /**
     * 根据时间戳获取日期（此日期为几号）
     * @param date
     * @return
     */
    public static int getDayBy(Integer date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date((long)date * 1000));
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    public static int getCurrentTimeIntValue() {
        int sencends = (int)(System.currentTimeMillis() / 1000L);
        return sencends;
    }

    public static int getAppointedTimeIntValue(String time, String format) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(format);
        Date date = f.parse(time);
        return (int)(date.getTime() / 1000L);
    }

    public static Date getDateByTimeStamp(int timeStamp, String format) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(format);
        String d = f.format((long)timeStamp * 1000L);
        Date date = f.parse(d);
        return date;
    }

    public static String getDateStringByTimeStamp(Integer timeStamp, String format) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(format);
        String d = "";
        if (timeStamp != null) {
            d = f.format((long)timeStamp * 1000L);
        }
        return d;
    }

    public static String formatDate(Object datetime, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        if (datetime instanceof Date) {
            return f.format((Date)datetime);
        } else if (datetime instanceof Long) {
            return f.format(new Date((Long)datetime));
        } else {
            return "";
        }
    }

    public static int getTimesmorning(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 0);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(14, 0);
        return (int)(cal.getTimeInMillis() / 1000L);
    }

    public static int getTimesnight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 23);
        cal.set(13, 59);
        cal.set(12, 59);
        cal.set(14, 999);
        return (int)(cal.getTimeInMillis() / 1000L);
    }

    public static String formatDateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return date == null ? "" : sdf.format(date);
    }

    public static Map<String, Object> formatStarttimeAndEndtime(String format, String strStarttime, String strEndtime, Integer intStarttime, Integer intEndtime) throws ParseException {
        Map<String, Object> timeMap = new HashMap();
        if (format == null) {
            timeMap.put("strStarttime", (Object)null);
            timeMap.put("intStarttime", (Object)null);
            timeMap.put("strEndtime", (Object)null);
            timeMap.put("intEndtime", (Object)null);
            return timeMap;
        } else {
            boolean ymd = false;
            boolean ymdhms = false;
            format = format.trim();
            int formatLen = format.length();
            int ymdLen = "yyyy-MM-dd".length();
            int ymdhmsLen = "yyyy-MM-dd HH:mm:ss".length();
            if (formatLen == ymdLen) {
                ymd = true;
            } else if (formatLen == ymdhmsLen) {
                ymdhms = true;
            }

            if (strStarttime != null && "".equals(strStarttime.trim())) {
                strStarttime = null;
            }

            if (strEndtime != null && "".equals(strEndtime.trim())) {
                strEndtime = null;
            }

            if (intStarttime != null && intStarttime <= 0) {
                intStarttime = null;
            }

            if (intEndtime != null && intEndtime <= 0) {
                intEndtime = null;
            }

            Date currentTime = new Date();
            int intCurrentTime = (int)(currentTime.getTime() / 1000L);
            int intTodayTimesmorning = getTimesmorning(currentTime);
            String strTodayTimesmorning = getDateStringByTimeStamp(intTodayTimesmorning, format);
            int intTodayTimesnight = getTimesnight(currentTime);
            String strTodayTimesnight = getDateStringByTimeStamp(intTodayTimesnight, format);
            if (strStarttime == null && strEndtime == null) {
                if ((intStarttime != null || intEndtime != null) && (strStarttime == null || strEndtime == null) && strStarttime != null) {
                    ;
                }
            } else {
                if (strStarttime != null && strEndtime != null) {
                    intStarttime = getAppointedTimeIntValue(strStarttime, format);
                    intEndtime = getAppointedTimeIntValue(strEndtime, format);
                } else if (strStarttime != null) {
                    intStarttime = getAppointedTimeIntValue(strStarttime, format);
                    intEndtime = intTodayTimesnight;
                    strEndtime = strTodayTimesnight;
                } else {
                    intEndtime = getAppointedTimeIntValue(strEndtime, format);
                    if (ymdhms) {
                        strStarttime = "1970-01-01 00:00:00";
                    } else {
                        strStarttime = "1970-01-01";
                    }

                    intStarttime = getAppointedTimeIntValue(strStarttime, format);
                }

                if (ymd) {
                    intStarttime = getTimesmorning(getDateByTimeStamp(intStarttime, format));
                    strStarttime = getDateStringByTimeStamp(intStarttime, format);
                    intEndtime = getTimesnight(getDateByTimeStamp(intEndtime, format));
                    strEndtime = getDateStringByTimeStamp(intEndtime, format);
                }

                if (intStarttime > intEndtime) {
                    intStarttime = getTimesmorning(getDateByTimeStamp(intEndtime, format));
                    strStarttime = getDateStringByTimeStamp(intStarttime, format);
                }

                if (intStarttime > intCurrentTime) {
                    intStarttime = intTodayTimesmorning;
                    strStarttime = getDateStringByTimeStamp(intStarttime, format);
                }

                if (intStarttime.equals(intEndtime)) {
                    intStarttime = getTimesmorning(getDateByTimeStamp(intStarttime, format));
                    strStarttime = getDateStringByTimeStamp(intStarttime, format);
                }
            }

            timeMap.put("strStarttime", strStarttime);
            timeMap.put("intStarttime", intStarttime);
            timeMap.put("strEndtime", strEndtime);
            timeMap.put("intEndtime", intEndtime);
            return timeMap;
        }
    }

    public static Set<Integer> strTimesToIntTimes(String strTimes, String split, String foratter) {
        Set<Integer> intTimeSet = new HashSet();
        String[] dts = strTimes.split(split);
        String[] var5 = dts;
        int var6 = dts.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String str = var5[var7];
            if (str != null && !"".equals(str.trim())) {
                try {
                    intTimeSet.add(getAppointedTimeIntValue(str.trim(), foratter));
                } catch (Exception var10) {
                    ;
                }
            }
        }

        return intTimeSet;
    }

    public static String foratterIntTime(Integer intTime) {
        if (intTime != null && intTime > 0) {
            int h = intTime / 60;
            int m = intTime % 60;
            String hh = h + "";
            String mm = m + "";
            if (hh.length() == 1) {
                hh = "0" + h;
            }

            if (mm.length() == 1) {
                mm = "0" + m;
            }

            return hh + ":" + mm;
        } else {
            return "00:00";
        }
    }

    public static Integer foratterStrTime(String strTime) {
        String strDateTime = "1970-01-01 " + strTime + ":00";
        Integer result = 0;

        try {
            Integer intTime = getAppointedTimeIntValue(strDateTime, "yyyy-MM-dd HH:mm:ss");
            String hh = getDateStringByTimeStamp(intTime, "HH");
            String mm = getDateStringByTimeStamp(intTime, "mm");
            int h = Integer.parseInt(hh, 10);
            int m = Integer.parseInt(mm);
            result = h * 60 + m;
        } catch (Exception var8) {
            ;
        }

        return result;
    }

    public static Integer foratterDateTime(String strDateTime) {
        Integer resultIntTime = 0;
        if (strDateTime == null) {
            return resultIntTime;
        } else {
            strDateTime = strDateTime.trim();
            SimpleDateFormat sdf = new SimpleDateFormat();
            if (!"".equals(strDateTime) && strDateTime.indexOf("date") != 0) {
                if (strDateTime.indexOf("time") == 0) {
                    if (strDateTime.length() > 4) {
                        switch(strDateTime.toCharArray()[4]) {
                            case 'H':
                            case 'h':
                                sdf = new SimpleDateFormat("HH");
                                break;
                            case 'M':
                            case 'm':
                                sdf = new SimpleDateFormat("HH:mm");
                                break;
                            case 'S':
                                sdf = new SimpleDateFormat("HH:mm:ss:SSS");
                                break;
                            case 's':
                                sdf = new SimpleDateFormat("HH:mm:ss");
                        }

                        strDateTime = sdf.format(new Date());
                    } else {
                        sdf = new SimpleDateFormat("HH:mm:ss");
                        strDateTime = sdf.format(new Date());
                    }

                    resultIntTime = foratterDateTime(strDateTime);
                } else if (strDateTime.indexOf("datetime") != 0 && strDateTime.indexOf("-") <= 0 && strDateTime.indexOf("/") <= 0) {
                    String[] strArrTime = strDateTime.split(":");
                    int strArrLenTime = strArrTime.length;
                    if (strArrLenTime == 1) {
                        resultIntTime = Integer.parseInt(strArrTime[0]);
                    } else if (strArrLenTime == 2) {
                        resultIntTime = Integer.parseInt(strArrTime[0]) * 60 + Integer.parseInt(strArrTime[1]);
                    } else if (strArrLenTime == 3) {
                        resultIntTime = Integer.parseInt(strArrTime[0]) * 60 * 60 + Integer.parseInt(strArrTime[1]) * 60 + Integer.parseInt(strArrTime[2]);
                    } else {
                        resultIntTime = 0;
                    }
                }
            }

            return resultIntTime;
        }
    }

    public static int getCurrentTimeMinuteValue() {
        Integer result = 0;

        try {
            Integer intTime = getCurrentTimeIntValue();
            String hh = getDateStringByTimeStamp(intTime, "HH");
            String mm = getDateStringByTimeStamp(intTime, "mm");
            int h = Integer.parseInt(hh, 10);
            int m = Integer.parseInt(mm);
            result = h * 60 + m;
        } catch (Exception var6) {
            ;
        }

        return result;
    }

    public static void main(String[] args) {
        Integer statTime = 1460329200;
        Integer endTime = 1460340000;
        System.out.println(getHHMM(statTime));
        System.out.println(getHHMM(endTime));
    }

    public static Date gregorianCalendar(Date date, int value, int field) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(field, value);
        date = gc.getTime();
        return date;
    }

    public static Integer addDay(Integer intDate, int day) {
        Integer result = 0;
        int oneDay = 86400;
        result = intDate + day * oneDay;
        return result;
    }

    public static Integer addDay(Date date, int day) {
        Integer intDate = (int)(date.getTime() / 1000L);
        Integer result = 0;
        int oneDay = 86400;
        result = intDate + day * oneDay;
        return result;
    }

    public static String getHHMM(Integer dateTime) {
        String result = "";

        try {
            String hh = getDateStringByTimeStamp(dateTime, "HH");
            String mm = getDateStringByTimeStamp(dateTime, "mm");
            result = result + hh + ":" + mm;
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return result;
    }
}
