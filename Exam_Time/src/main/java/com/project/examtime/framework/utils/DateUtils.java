package com.project.examtime.framework.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * 
 * @author Harish
 *
 */
public class DateUtils {

	public static final String DATE_FILTER_FORMAT = "dd-MMM-yyyy";
	public static final String DISPLAY_DATE_TIME_FORMAT = "MM/dd/yy hh:mm:ss a";
	public static final String SHORT_DATE_FORMAT = "MMddyy";
	public static final String SIMPLE_DATE_FORMAT = "MM/dd/yyyy";
	public static final String FULL_DATE_FORMAT = "MM/dd/yyyy hh:mm:ss a z";
	public static final String ETA_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_FORMAT_MM_DD_YYYY_HH_MM_SS = "MM/dd/yyyy HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String EX_DATE_FORMAT = "dd/MM/yyyy";

	/**
	 * Converts the specified date to a string formatted as dd-MMM-YYYY. If the
	 * input is null, returns null.
	 *
	 * @param date:
	 *            The date
	 * @return the date, as a string, converted to the specified format. Or
	 *         null, if the input is null.
	 */
	public static String convertToFilterDateString(final Date date) {
		if (date == null) {
			return null;
		}

		return convertDateFormat(date, DATE_FILTER_FORMAT);
	}

	public static java.sql.Date getSqlDate() {
		return new java.sql.Date(Calendar.getInstance().getTime().getTime());
	}

	/**
	 * Converts the specified date to a string formatted as MM/dd/yy HH:mm:ss a.
	 * If the input is null, returns null.
	 *
	 * @param date:
	 *            The date
	 * @return the date, as a string, converted to standard date time format. Or
	 *         null, if the input is null.
	 */
	public static String convertToDateTimeFormat(final Date date) {
		if (date == null) {
			return null;
		}

		return convertDateFormat(date, DISPLAY_DATE_TIME_FORMAT);
	}

	/**
	 * Converts the specified date to a string formatted as MM/dd/yyyy HH:mm:ss.
	 * If the input is null, returns null.
	 *
	 * @param date:
	 *            The date
	 * @return the date, as a string, converted to standard date time format. Or
	 *         null, if the input is null.
	 */
	public static String convertToDateTime24HourFormat(final Date date) {
		if (date == null) {
			return null;
		}

		return convertDateFormat(date, DATE_TIME_FORMAT_MM_DD_YYYY_HH_MM_SS);
	}

	/**
	 * Converts the specified date to a string formatted as MM/dd/yyyy. If the
	 * input is null, returns null.
	 *
	 * @param date:
	 *            The date
	 * @return the date, as a string, converted to standard date time format. Or
	 *         null, if the input is null.
	 */
	public static String convertToSimpleDateFormat(final Date date) {
		if (date == null) {
			return null;
		}

		return convertDateFormat(date, SIMPLE_DATE_FORMAT);
	}

	/**
	 * Converts the specified date to a string formatted as yyyy-MM-dd HH:mm:ss.
	 * If the input is null, returns null.
	 *
	 * @param date:
	 *            The date
	 * @return the date, as a string, converted to standard date time format. Or
	 *         null, if the input is null.
	 */
	public static String convertToEtaDateTimeFormat(final Date date) {
		if (date == null) {
			return null;
		}

		return convertDateFormat(date, ETA_DATE_FORMAT);
	}

	/**
	 * Converts the specified date to a string formatted as MM/dd/yy HH:mm:ss a
	 * z. If the input is null, returns null.
	 *
	 * @param date:
	 *            The date
	 * @return the date, as a string, converted to standard date time format. Or
	 *         null, if the input is null.
	 */
	public static String convertToFullDateTimeFormat(final Date date) {
		if (date == null) {
			return null;
		}

		return convertDateFormat(date, FULL_DATE_FORMAT);
	}

	/**
	 * Parses the specified date string using the specified format and returns a
	 * Date object.
	 */
	public static Date convertToDate(final String dateString, final String format) throws ParseException {
		if (isEmpty(dateString)) {
			return null;
		}

		DateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		Date date = dateFormat.parse(dateString);
		return date;
	}

	/**
	 * Parses the specified date string using the specified format and returns a
	 * Date object.
	 */
	public static Date convertToSimpleDate(final String dateString) throws ParseException {
		if (isEmpty(dateString)) {
			return null;
		}

		DateFormat dateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		dateFormat.setLenient(false);
		Date date = dateFormat.parse(dateString);
		return date;
	}

	/**
	 * Parses the specified date string using the specified format and returns a
	 * Date object.
	 */
	public static java.sql.Date convertToSqlDate(final String dateString) {
		if (isEmpty(dateString)) {
			return null;
		}
		java.sql.Date sqlDate = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			dateFormat.setLenient(false);
			Date date = dateFormat.parse(dateString);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	/**
	 * @param date:
	 *            The date to convert
	 * @param format:
	 *            The format to convert to
	 * @return
	 */
	public static String convertDateFormat(final Date date, final String format) {
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			return formatter.format(date);
		}
		return null;
	}

	/**
	 * Return the format of how dates will be displayed in the Calendar
	 * components on the screen
	 * 
	 * @param locale
	 * @return
	 */
	public static String getDisplayDateFormat(Locale locale) {
		// For now defaulted to MM/dd/yyyy
		return SIMPLE_DATE_FORMAT;
	}

	/**
	 * Add x number of days to a given date
	 */
	public static Date addDays(final Date aDate, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * Subtract x number of days to a given date NB. The int days value MUST be
	 * a negative number
	 */
	public static Date getFirstDayOftheMonth(final Date aDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		int dayOfMonth = calendar.get(Calendar.DATE);
		Date firstOfMOnth = subtractDays(aDate, dayOfMonth - 1);
		return truncateToMidnight(firstOfMOnth);
	}

	/**
	 * Subtract x number of days to a given date NB. The int days value MUST be
	 * a negative number
	 */
	public static Date subtractDays(final Date aDate, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	public static Date subtractYear(final Date aDate, int years) {
		if (years > 0) {
			years = ~(years - 1);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
	}

	public static void truncateToMidnight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return;
	}

	public static Date truncateToMidnight(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		DateUtils.truncateToMidnight(calendar);
		return calendar.getTime();
	}

	public static long daysBetween(LocalDate startDate, Date endDate) {
		String endDateString = convertDateFormat(endDate, "yyyy-MM-dd");
		LocalDate localEndDate = LocalDate.parse(endDateString);
		return startDate.until(localEndDate, ChronoUnit.DAYS);
	}

	public static long daysBetween(Date beginDate, Date endDate) {
		String startDateString = convertDateFormat(beginDate, "yyyy-MM-dd");
		String endDateString = convertDateFormat(endDate, "yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(startDateString);
		LocalDate localEndDate = LocalDate.parse(endDateString);
		return startDate.until(localEndDate, ChronoUnit.DAYS);
	}

	public static String getDatesTimePortion(Date dateTime, String timeFormat) {
		if (timeFormat == null || timeFormat.trim().length() == 0)
			return "000000";

		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		SimpleDateFormat timeOnly = new SimpleDateFormat(timeFormat);
		return timeOnly.format(cal.getTime());
	}

	/**
	 * Add x number of minutes to a given date
	 */
	public static Date addMinutes(final Date aDate, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}

	/**
	 * Return year of a given date
	 */
	public static int getYear(final Date date, final String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * Return a collection of Calendar (rolling months) objects based on the
	 * Date passed in. The number of rolling months to be returned will be based
	 * on the value passed as a parameter
	 * 
	 * @param fromDate
	 * @param numberOfMonths
	 * @return
	 */
	public static List<Calendar> getRollingMonths(Calendar fromDate, int numberOfMonths) {
		// Get First Day of the month for the fromDate
		fromDate.set(Calendar.DAY_OF_MONTH, 1);

		List<Calendar> rollingMonths = new ArrayList<Calendar>();
		for (int monthCount = 1; monthCount <= numberOfMonths; monthCount++) {
			Calendar newMonth = (Calendar) fromDate.clone();
			newMonth.add(Calendar.MONTH, monthCount);
			rollingMonths.add(newMonth);
		}

		return rollingMonths;
	}

	/**
	 * Add x number of hours to a given date
	 */
	public static Date addHours(final Date aDate, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

	public static LocalDate fromDate(Date date) {
		Instant instant = Instant.ofEpochMilli(date.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static boolean isEmpty(String aStr) {
		if ((aStr == null) || (aStr.trim().length() == 0))
			return (true);
		return (false);
	}

	public static Timestamp getCurrentTimeStamp() {
		return new java.sql.Timestamp(new Date().getTime());
	}
}
