package fun.xzl.tool.time;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 日期处理
 * 
 * @author littl
 *
 */
public class TimeUtils {

	private TimeUtils() {
	}

	/**
	 * 格式化日期，并返回字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static final String format(Date date, TimeFormat format) {
		return TimeUtils.getDateTimeFromDate(date).toString(format.getFormat());
	}

	public static final String format(Date date) {
		return TimeUtils.format(date, TimeFormat.LONG);
	}

	public static final Date parseDate(String dateStr, TimeFormat format) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(format.getFormat());
		DateTime dateTime = DateTime.parse(dateStr, formatter);
		return dateTime.toDate();
	}

	public static final Date parseDate(String dateStr) {
		return TimeUtils.parseDate(dateStr, TimeFormat.LONG);
	}

	public static final Date addDays(Date date, int duration) {
		return TimeUtils.getDateTimeFromDate(date).plusDays(duration).toDate();
	}

	public static final Date addMonths(Date date, int duration) {
		return TimeUtils.getDateTimeFromDate(date).plusMonths(duration).toDate();
	}

	public static final Date addYears(Date date, int duration) {
		return TimeUtils.getDateTimeFromDate(date).plusYears(duration).toDate();
	}

	public static final Date addHours(Date date, int duration) {
		return TimeUtils.getDateTimeFromDate(date).plusHours(duration).toDate();
	}

	public static final Date addMinutes(Date date, int duration) {
		return TimeUtils.getDateTimeFromDate(date).plusMinutes(duration).toDate();
	}

	/**
	 * 获取该日期对应的月份的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static final Date getFirstDayOfMonth(Date date) {
		return TimeUtils.getDateTimeFromDate(date).dayOfMonth().withMinimumValue().toDate();
	}

	/**
	 * 获取该日期对应的月份的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static final Date getLastDayOfMonth(Date date) {
		return TimeUtils.getDateTimeFromDate(date).dayOfMonth().withMaximumValue().toDate();
	}

	/**
	 * 获取该日期对应的周一
	 * 
	 * @param date
	 * @return
	 */
	public static final Date getMondayOfWeek(Date date) {
		return TimeUtils.getDateTimeFromDate(date).dayOfWeek().withMinimumValue().toDate();
	}

	/**
	 * 获取该日期对应的周日
	 * 
	 * @param date
	 * @return
	 */
	public static final Date getSundayOfWeek(Date date) {
		return TimeUtils.getDateTimeFromDate(date).dayOfWeek().withMaximumValue().toDate();
	}

	/**
	 * 获取该日期当天的第一时间
	 * 
	 * @param date
	 * @return
	 */
	public static final Date getFirstTimeOfDay(Date date) {
		return TimeUtils.getDateTimeFromDate(date).millisOfDay().withMinimumValue().toDate();
	}

	/**
	 * 获取改日期当天的最后时间
	 * 
	 * @param date
	 * @return
	 */
	public static final Date getLastTimeOfDay(Date date) {
		return TimeUtils.getDateTimeFromDate(date).millisOfDay().withMaximumValue().toDate();
	}

	/**
	 * 获取两个日期之间相差的天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static final int getDays(Date start, Date end) {
		return Days.daysBetween(DateTime.parse(TimeUtils.format(end, TimeFormat.LONG_DAY)),
				DateTime.parse(TimeUtils.format(start, TimeFormat.LONG_DAY))).getDays();
	}

	public static final DateTime getDateTimeFromDate(Date date) {
		return new DateTime(date);
	}

	// public static void main(String[] args) {
	// Date now = new Date();
	// String str = TimeUtils.format(TimeUtils.getFirstDayOfMonth(now));
	// System.out.println(str);
	//
	// String monday = TimeUtils.format(TimeUtils.getSundayOfWeek(now));
	// System.out.println(monday);
	//
	// String minTime = TimeUtils.format(TimeUtils.getLastTimeOfDay(now));
	// System.out.println(minTime);
	//
	// Date date = TimeUtils.parseDate("2016-12-30 23:44:00");
	// int days = TimeUtils.getDays(date, now);
	// System.out.println(days);
	// }

}
