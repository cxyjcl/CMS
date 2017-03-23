package com.dcs.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具
 * 
 * @className: DateUtils.java
 * @author zongzi
 * @date 2016年2月2日 下午3:30:37
 */
public class DateUtils {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(DateUtils.class);

	public static final String YEAR = "year"; // 年
	public static final String MONTH = "month"; // 月
	public static final String DAY_OF_MONTH = "dayOfMonth"; // 日
	public static final String HOUR_OF_DAY = "hourOfDay"; // 时
	public static final String DAY = "day"; // 时
	public static final String HOUR = "hour"; // 时
	public static final String MINUTE = "minute"; // 分
	public static final String SECOND = "second"; // 秒
	public static final String START_TIME = "startTime"; // 开始时间
	public static final String END_TIME = "endTime"; // 结束时间
	private static final SimpleDateFormat SHORT_SDF = new SimpleDateFormat(
			"yyyy-MM-dd"); // 精确到天
	private static final SimpleDateFormat LONG_SDF = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss"); // 精确到时分秒

	/**
	 * ----------------------------------日期字串转Date对象----------------------------
	 * 
	 */

	/**
	 * 日期字符串 yyyy-MM-dd 格式转到date
	 * 
	 * @param @param dateStr
	 * 
	 * @param @return
	 * 
	 * @author zongzi
	 * 
	 * @date 2016年12月14日 下午2:43:35
	 */
	public static Date str2Date(String dateStr) {
		return str2Date(dateStr, "yyyy-MM-dd");
	}

	/**
	 * 日期字符串 yyyy-MM-dd 格式 转到date
	 * 
	 * @param @param dateStr
	 * 
	 * @param @return
	 * 
	 * @author zongzi
	 * 
	 * @date 2016年11月21日 下午1:28:25
	 */
	public static Date str2Date2(String dateStr) {
		return str2Date(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 日期转字串 yyyyMMddHHmmss格式 转到date
	 * 
	 * @param @param dateStr
	 * 
	 * @param @return
	 * 
	 * @author zongzi
	 * 
	 * @date 2016年11月21日 下午1:28:49
	 */
	public static Date str2Date3(String dateStr) {
		return str2Date(dateStr, "yyyyMMddHHmmss");
	}

	/**
	 * 日期字符串自定义格式转到date
	 * 
	 * @param dateStr
	 * 
	 * @param dateFormat
	 * 
	 * @return
	 */
	public static Date str2Date(String dateStr, String dateFormat) {
		if (dateStr == null || dateStr == "") {
			return null;
		}
		DateFormat formatter = new SimpleDateFormat(dateFormat);
		Date date;
		try {
			date = formatter.parse(dateStr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ----------------------------Date对象转 日期字符串----------------------------
	 * 
	 */

	/**
	 * @Description 获取 date对象 的 yyyy-MM-dd HH:mm:ss 日期格式的日期字符串
	 * 
	 * @param date
	 *            日期
	 * 
	 * @return yyyy-MM-dd HH:mm:ss 格式的日期字符串
	 */
	public static String getSimpleFormatDate(Date date) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	/**
	 * 获得当前时间的yyyy-MM-dd HH:mm:ss S格式的字符串
	 * 
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午2:44:08
	 */
	public static String getNowSimpleFormatTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
		return formatter.format(new Date());
	}

	/**
	 * 将 date对象 转换成 dateFormatStr 格式规定的字符串
	 * 
	 * @param dateFormatStr
	 *            "yyyy-MM-dd HH:mm:ss"
	 * @param date
	 *            new Date(1481698502840L) "2017-01-01 00:00:00"
	 * @return "2017-01-01 00:00:00"
	 */
	public static String getFormatDate(String dateFormatStr, Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(dateFormatStr).format(date);
	}

	/**
	 * ------------------------时间计算----------------------------
	 */

	/**
	 * 获得unix时间戳 返回1970年到现在的时间 单位:秒
	 * 
	 * @param @param inDate
	 * 
	 * @author zongzi
	 * 
	 * @date 2016年12月14日 下午2:27:58
	 */
	public static Long getUNIXTimeStamp(Date inDate) {
		return inDate.getTime() / 1000;
	}

	/**
	 * 返回 inDate 指定的天 timeStr 指定的小时和分钟的 date
	 * 
	 * @param inDate
	 *            date in 2016-12-14 14:12:10
	 * 
	 * @param timeStr
	 *            "12:10"
	 * 
	 * @return 设置时间时分 date in 2016-12-14 12:10:10
	 */
	public static Date setHourMinuteOFInDate(Date inDate, String timeStr) {
		DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date date = null;
		try {
			date = formatter2.parse(formatter1.format(inDate) + " " + timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将年月转化成int型年月
	 * 
	 * @param year
	 * 
	 * @param month
	 * 
	 * @return
	 */
	public static int calcLastYearMonth(int year, int month) {
		return month == 1 ? (year - 1) * 10000 + (1200)
				: (year * 10000 + (month - 1) * 100);
	}

	/**
	 * 获取date对象当天最后一秒的date对象
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static Date getEndTimeOfDay(Date date) {
		String strDate = getFormatDate("yyyy-MM-dd", date);
		String dateStr = strDate + " 23:59:59";
		return str2Date2(dateStr);
	}

	/**
	 * 获取当天开始的那一秒的date对象
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static Date getStartTimeOfDay(Date date) {
		String strDate = getFormatDate("yyyy-MM-dd", date);
		String dateStr = strDate + " 00:00:00";
		return str2Date2(dateStr);
	}

	/**
	 * 获取 当前date对象的 beforeDay 天之前的开始date对象
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static Date getStartTimeBeforeDay(Integer beforeDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - beforeDay);
		return getStartTimeOfDay(calendar.getTime());
	}

	/**
	 * 获取date对象的 beforeDay 天之前的结束date对象
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static Date getEndTimeBeforeDay(Integer beforeDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - beforeDay);
		return getEndTimeOfDay(calendar.getTime());
	}

	/**
	 * 获取指定date对象 beforeDate 天前的开始时间的 date对象
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartTimeBeforeDay(Date date, Integer beforeDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - beforeDay);
		return getStartTimeOfDay(calendar.getTime());
	}

	/**
	 * 获得当前时间beforeDay之前的date 例如 Date in 2016-11-11 11:11:11
	 * --->getTimeBeforDay(1) ----->date in 2016-11-10 11:11:11
	 * 
	 * @param beforeDay
	 * 
	 * @param @return
	 * 
	 * @author zongzi
	 * 
	 * @date 2016年11月21日 下午1:25:03
	 */
	public static Date getTimeBeforeDay(Integer beforeDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - beforeDay);
		return calendar.getTime();
	}

	public static Date getTimeBeforeDay(Date date, Integer beforeDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - beforeDay);
		return calendar.getTime();
	}

	/**
	 * 获取laterDay天后的开始date
	 * 
	 * @param date
	 * @return
	 */
	public static Date getstartTimelaterDay(Integer laterDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + laterDay);
		return getStartTimeOfDay(calendar.getTime());
	}

	/**
	 * 获取date对象laterDay天后的开始date
	 * 
	 * @param @param date
	 * @param @param laterDay
	 * @param @return
	 * @author zongzi
	 * @date 2016年11月21日 下午1:17:38
	 */
	public static Date getstartTimelaterDay(Date date, Integer laterDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + laterDay);
		return getStartTimeOfDay(calendar.getTime());
	}

	/**
	 * 获取laterDay天后的结束date
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndTimelaterDay(Integer laterDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + laterDay);
		return getEndTimeOfDay(calendar.getTime());
	}

	/**
	 * 获得当前时间laterDay之后的date 例如 Date in 2016-11-11 11:11:11
	 * --->getTimelaterDay(1) ----->Date in 2016-11-12 11:11:11
	 * 
	 * @param @param laterDay
	 * @param @return
	 * @author zongzi
	 * @date 2016年11月21日 下午1:27:16
	 */
	public static Date getTimelaterDay(Integer laterDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + laterDay);
		return calendar.getTime();
	}

	public static Date getTimelaterDay(Date date, Integer laterDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + laterDay);
		return calendar.getTime();
	}

	/**
	 * 获得当前date对象laterHour之后的时间date
	 * 
	 * @param @param laterHour
	 * @param @return
	 * @author zongzi
	 * @date 2016年11月24日 上午9:49:09
	 */
	public static Date getTimelaterHour(Integer laterHour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + laterHour);
		return calendar.getTime();
	}

	public static Date getTimelaterHour(Date date, Integer laterHour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + laterHour);
		return calendar.getTime();
	}

	/**
	 * 获得当前date对象laterMinute之后的时间date
	 * 
	 * @param @param laterHour
	 * @param @return
	 * @author zongzi
	 * @date 2016年11月24日 上午9:48:04
	 */
	public static Date getTimelaterMinute(Integer laterMinute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)
				+ laterMinute);
		return calendar.getTime();
	}

	/**
	 * 获得date对象所在小时的开始时间
	 * 
	 * @param @param date
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:38:33
	 */
	public static Date getStartTimeOfHour(Date date) {
		String strDate = getFormatDate("yyyy-MM-dd HH", date);
		String dateString = strDate + ":00:00";
		return str2Date2(dateString);
	}

	/**
	 * 获得date对象24小时前的date对象
	 * 
	 * @param @param date
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:40:16
	 */
	public static Date beforeDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.get(Calendar.HOUR_OF_DAY) - 24);
		return calendar.getTime();
	}

	/**
	 * 获取date对象minute分钟之前的date对象
	 * 
	 * @param @param date
	 * @param @param minute
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:41:29
	 */
	public static Date beforeGetTime(Date date, Integer minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - minute);
		return calendar.getTime();
	}

	/**
	 * 获取date对象minute分钟之后的date对象
	 * 
	 * @param @param date
	 * @param @param minute
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:41:16
	 */
	public static Date afterGetTime(Date date, Integer minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);
		return calendar.getTime();
	}

	/**
	 * 获得date对象当月开始第一天的date对象
	 * 
	 * @param @param date
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:42:51
	 */
	public Date firstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取date所在对象当月的最后一天的date对象
	 * 
	 * @param @param date
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:42:51
	 */
	public Date lastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 获取某年第一天一天日期
	 * 
	 * @param @param year
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:44:36
	 */
	public static Date firstDayOfYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取某年最后一天日期
	 * 
	 * @param @param year
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:44:51
	 */
	public static Date lastDayOfYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}

	/**
	 * 获取两个日期的月份差
	 * 
	 * @param @param start
	 * @param @param end
	 * @param @return
	 * @author zongzi
	 * @date 2016年12月14日 下午3:45:42
	 */
	public static int getMonth(Date start, Date end) {
		if (start.after(end)) {
			Date t = start;
			start = end;
			end = t;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);
		temp.add(Calendar.DATE, 1);

		int year = endCalendar.get(Calendar.YEAR)
				- startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH)
				- startCalendar.get(Calendar.MONTH);

		if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month + 1;
		} else if ((startCalendar.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month;
		} else if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {
			return year * 12 + month;
		} else {
			return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
		}
	}

	/**
	 * 给出日期添加一段时间后的日期
	 * 
	 * @param dateStr
	 * @param plus
	 *            天数
	 * @return
	 */
	public static String getPlusDays(String dateStr, long plus) {
		try {
			Date convertDateFromStr = convertDateFromStr(dateStr);
			long time = convertDateFromStr.getTime() + plus * 24 * 60 * 60
					* 1000;
			return getFormatDate("yyyy-MM-dd HH:mm:dd", new Date(time));
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 获取所提供日期间隔月份的 开始时间和结束时间 （第一天00:00:00和最后一天23:59:59）
	 * 
	 * @param date
	 *            时间参数 (入参，以此时间为轴心)
	 * @param forwardMonth
	 *            向前推移的月数(为0表入参date所在月份，大于0表向前推进的月数，小于0表向后推迟)
	 * @return Map<key, value> key = startTime || endTime
	 */
	public static Map<String, Date> getFirstday_Lastday_Month(Date date,
			int forwardMonth) {
		Map<String, Date> map = new HashMap<String, Date>();

		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(date);
		// 如果间隔月份存在时 重新设定日体时间
		if (forwardMonth != 0) {
			gcLast.add(Calendar.MONTH, -forwardMonth);// 计算向前N个月
		}
		gcLast.setTime(gcLast.getTime());
		// 第一天
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		gcLast.set(Calendar.HOUR_OF_DAY, 0);
		gcLast.set(Calendar.MINUTE, 0);
		gcLast.set(Calendar.SECOND, 0);
		String strStrart = getFormatDate("yyyy-MM-dd", gcLast.getTime());
		String startDate = strStrart + " 00:00:00";
		map.put(START_TIME, str2Date2(startDate));// 本周开始时间

		// 最后一天
		gcLast.add(Calendar.MONTH, 1);// 加一个月
		gcLast.set(Calendar.DATE, 1);// 设置为该月第一天
		gcLast.add(Calendar.DATE, -1);// 再减一天即为上个月最后一天
		gcLast.set(Calendar.HOUR_OF_DAY, 23);
		gcLast.set(Calendar.MINUTE, 59);
		gcLast.set(Calendar.SECOND, 59);
		String endStrart = getFormatDate("yyyy-MM-dd", gcLast.getTime());
		String endtDate = endStrart + " 23:59:59";
		map.put(END_TIME, str2Date2(endtDate));// 本周结束时间

		return map;
	}

	/**
	 * 给出日期获取日期的 年月日时分秒
	 * 
	 * @param date
	 * @return 返回 年月日时分秒 的MAP
	 */
	public static Map<String, Integer> getSystimePrams(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		Map<String, Integer> mapResult = new HashMap<String, Integer>();
		mapResult.put(YEAR, calendar.get(Calendar.YEAR));
		mapResult.put(MONTH, calendar.get(Calendar.MONTH) + 1);
		mapResult.put(DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
		mapResult.put(HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
		mapResult.put(MINUTE, calendar.get(Calendar.MINUTE));
		mapResult.put(SECOND, calendar.get(Calendar.SECOND));

		return mapResult;
	}

	/**
	 * 获取传入时间所在周的开始和结束时间
	 * 
	 * @param date
	 * @return
	 */
	public static Map<String, Date> getWeek_Start_End(Date date) {
		// 返回结果
		Map<String, Date> map = new HashMap<String, Date>();
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(date);
		gcLast.setFirstDayOfWeek(Calendar.MONDAY);

		gcLast.set(Calendar.HOUR_OF_DAY, 0);
		gcLast.set(Calendar.MINUTE, 0);
		gcLast.set(Calendar.SECOND, 0);
		gcLast.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String strStrart = getFormatDate("yyyy-MM-dd", gcLast.getTime());
		String startDate = strStrart + " 00:00:00";
		map.put(START_TIME, str2Date2(startDate));// 本周开始时间

		gcLast.set(Calendar.HOUR_OF_DAY, 23);
		gcLast.set(Calendar.MINUTE, 59);
		gcLast.set(Calendar.SECOND, 59);
		gcLast.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String endStrart = getFormatDate("yyyy-MM-dd", gcLast.getTime());
		String endtDate = endStrart + " 23:59:59";
		map.put(END_TIME, str2Date2(endtDate));// 本周结束时间

		return map;
	}

	/**
	 * 根据传入时间获取所在季度的开始时间，即格式2012-01-01 00:00:00 2012-01-01 00:00:00 2012-01-01
	 * 00:00:00 2012-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Date getQuarterStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date returnTime = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 0);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 3);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 6);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 9);
			}
			c.set(Calendar.DATE, 1);
			returnTime = LONG_SDF.parse(SHORT_SDF.format(c.getTime())
					+ " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnTime;
	}

	/**
	 * 根据传入时间获取所在季度的结束时间，即格式2012-03-31 23:59:59 2012-06-30 23:59:59 2012-09-30
	 * 23:59:59 2012-12-31 23:59:59
	 * 
	 * @return
	 */
	public static Date getQuarterEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date returnTime = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 2);
				c.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 8);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			returnTime = LONG_SDF.parse(SHORT_SDF.format(c.getTime())
					+ " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnTime;
	}

	/**
	 * 根据传入时间获取所在年的开始时间，即2012-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Date getYearStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		Date returnTime = null;
		try {
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DATE, 1);
			returnTime = SHORT_SDF.parse(SHORT_SDF.format(c.getTime())
					+ " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnTime;
	}

	/**
	 * 根据传入时间获取所在年的结束时间，即2012-12-31 23:59:59
	 * 
	 * @return
	 */
	public static Date getYearEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		Date returnTime = null;
		try {
			c.set(Calendar.MONTH, 11);
			c.set(Calendar.DATE, 31);
			returnTime = LONG_SDF.parse(SHORT_SDF.format(c.getTime())
					+ " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnTime;
	}

	/**
	 * 获取传入时间的上一周的相同时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastWeekTime(Date date) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		cal.add(Calendar.WEEK_OF_MONTH, -1);// 周数减一，即上周
		// cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//日子设为星期天
		// 此设置后获取将是前一周的周日
		return cal.getTime();
	}

	/**
	 * 获取传入时间的前一个月的相同时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastMonthTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}

	/**
	 * 获取传入时间所在半年的开始时间
	 * 
	 * @return
	 */
	public static Date getHalfYearStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 0);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 6);
			}
			c.set(Calendar.DATE, 1);
			now = LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获取传入时间所在半年的结束时间
	 * 
	 * @return
	 */
	public static Date getHalfYearEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获取传入时间间隔N天的日期 （dayNum>0后延 dayNum<0前退）
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNumDaysInterval(Date date, int dayNum) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime());
		if (dayNum > 0) {
			c.add(Calendar.DATE, dayNum);// dayNum天后的日期
		} else if (dayNum < 0) {
			c.add(Calendar.DATE, dayNum);// dayNum天前的日期
		}
		return new Date(c.getTimeInMillis()); // 将c转换成Date
	}

	/**
	 * 根据date i获取某一天的日期
	 * 
	 * @param date
	 * @param i
	 *            (after正数为后多少天，before负数为前多少天)
	 * @return
	 */
	public static Date getABDate(Date date, int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, i);
		return c.getTime();
	}

	/**
	 * 
	 * @param 要转换的毫秒数
	 * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
	 * @author heimu
	 */
	public static Map<String, Long> formatDuring(long l) {
		Map<String, Long> timeMap = new HashMap<String, Long>();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long minute = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long second = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);
		timeMap.put(DAY, day);
		timeMap.put(HOUR, hour);
		timeMap.put(MINUTE, minute);
		timeMap.put(SECOND, second);
		return timeMap;
	}

	/**
	 * 
	 * @param begin
	 *            时间段的开始
	 * @param end
	 *            时间段的结束
	 * @return 输入的两个Date类型数据之间的时间间格用* day * hour * minute * second的格式展示
	 * @author heimu
	 */
	public static Map<String, Long> formatDuring(Date begin, Date end) {
		return formatDuring(end.getTime() - begin.getTime());
	}

	/**
	 * 获取天
	 * 
	 * @author heimu
	 * @param date
	 * @return
	 */
	public static String getDate(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat("dd").format(date);
	}

	/**
	 * 通用日期字符串转换方法
	 * 
	 * @param strDate
	 *            字符串格式的日期
	 * @return Date类型的日期
	 * 
	 */
	public static Date convertDateFromStr(String strDate) {
		if (!StringUtils.isEmpty(strDate)) {
			try {
				try {
					Long longDate = Long.parseLong(strDate);
					return new Date(longDate);
				} catch (Exception e) {

				}
				if (strDate.length() == 7) {
					return new SimpleDateFormat("yyyy-MM").parse(strDate);
				} else if (strDate.length() == 10) {
					return new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
				} else if (strDate.length() == 13) {
					return new SimpleDateFormat("yyyy-MM-dd HH").parse(strDate);
				} else if (strDate.length() == 16) {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm")
							.parse(strDate);
				} else if (strDate.length() == 28) {
					return new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",
							Locale.UK).parse(strDate);
				} else {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(strDate);
				}
			} catch (ParseException e) {
				LOGGER.error("支持的模式有：long类型时间||yyyy-MM||yyyy-MM-dd||yyyy-MM-dd HH||yyyy-MM-dd HH:mm||yyyy-MM-dd HH:mm:ss||EEE MMM dd HH:mm:ss Z yyyy");
			}
		}
		return null;
	}

}
