package com.fsoft.gst.ptithcm.tms.commonUltil;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtil.
 */
public class DateUtil {
	
	/** The hour. */
	public static long HOUR = 3600000L;

	/**
	 * Date 2 string.
	 *
	 * @param input the input
	 * @param format the format
	 * @return the string
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public static String date2String(Date input, String format) throws IllegalArgumentException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(input);
	}

	/**
	 * String 2 date.
	 *
	 * @param input the input
	 * @param format the format
	 * @return the date
	 * @throws ParseException the parse exception
	 */
	public static Date string2Date(String input, String format) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(input);
	}

	/**
	 * Move 2 the end of day.
	 *
	 * @param input the input
	 * @return the timestamp
	 */
	public static Timestamp move2TheEndOfDay(Timestamp input) {
		Timestamp res = null;
		if (input != null) {
			res = new Timestamp(input.getTime() + 24 * HOUR - 1000);
		}
		return res;
	}

	/**
	 * Validate date format MMDDYYYY.
	 *
	 * @param input the input
	 * @return true, if successful
	 */
	public static boolean validateDateFormatMMDDYYYY(String input) {
		boolean res = false;
		if (StringUtils.isNotBlank(input)) {
			String[] temp = input.split("/");
			if (temp.length == 3) {
				try {
					int month = Integer.parseInt(temp[0]);
					int day = Integer.parseInt(temp[1]);
					int year = Integer.parseInt(temp[2]);

					if (month >= 1 && month <= 12) {
						if (year >= 1900) {
							res = isValidDay(day, month, year);
						}
					}
				} catch (Exception e) {
					res = false;
				}
			}
		}
		return res;
	}

	/**
	 * Checks if is leap year.
	 *
	 * @param year the year
	 * @return true, if is leap year
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is valid day.
	 *
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @return true, if is valid day
	 */
	private static boolean isValidDay(int day, int month, int year) {
		if (day < 1) {
			return false;
		}
		if (day > 31)
			return false;
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 30) {
				return false;
			}
		}
		if (month == 2) {
			if (isLeapYear(year)) {
				if (day > 29) {
					return false;
				}
			} else {
				if (day > 28) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Truncate time.
	 *
	 * @param date the date
	 * @return the long
	 */
	public static long truncateTime(Date date) {
		try {
			return DateUtil.string2Date(date2String(date, "yyyyMMdd"), "yyyyMMdd").getTime();
		} catch (Exception e) {
			return System.currentTimeMillis();
		}
	}

	/**
	 * Yesterday.
	 *
	 * @return the date
	 */
	public static Date yesterday() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, -1); // minus number would decrement the days
		return cal.getTime();
	}

	/**
	 * Today.
	 *
	 * @return the date
	 */
	public static Date today() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * Format timestamp 2 string.
	 *
	 * @param dateTime the date time
	 * @param format the format
	 * @return the string
	 */
	public static String formatTimestamp2String(Timestamp dateTime, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(dateTime.getTime()));
	}

	/**
	 * Date to timestamp.
	 *
	 * @param dateInput the date input
	 * @param format the format
	 * @return the timestamp
	 */
	public static Timestamp dateToTimestamp(Date dateInput, String format) {
		return new Timestamp(dateInput.getTime());
	}

	/**
	 * Difference in months.
	 *
	 * @param beginningDate the beginning date
	 * @param endingDate the ending date
	 * @return the integer
	 */
	public static Integer differenceInMonths(Date beginningDate, Date endingDate) {
		if (beginningDate == null || endingDate == null) {
			return 0;
		}
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(beginningDate);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(endingDate);
		return differenceInMonths(cal1, cal2);
	}

	/**
	 * Difference in months.
	 *
	 * @param beginningDate the beginning date
	 * @param endingDate the ending date
	 * @return the integer
	 */
	private static Integer differenceInMonths(Calendar beginningDate, Calendar endingDate) {
		if (beginningDate == null || endingDate == null) {
			return 0;
		}
		int m1 = beginningDate.get(Calendar.YEAR) * 12 + beginningDate.get(Calendar.MONTH);
		int m2 = endingDate.get(Calendar.YEAR) * 12 + endingDate.get(Calendar.MONTH);
		return m2 - m1;
	}

}
