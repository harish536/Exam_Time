package com.project.examtime.framework.utils;

import java.util.HashMap;

/**
 * @author Harish
 * 
 *         This class is used setting and getting values during the thread
 *         context
 *
 */

public class ThreadLocalUtils {

	public static final String LOCALE = "LOCALE";
	public static final String CURRENT_USER = "CURRENT_USER";

	private final static ThreadLocal<HashMap<String, Object>> THREAD_VARIABLES = new ThreadLocal<HashMap<String, Object>>() {

		/**
		 * @see java.lang.ThreadLocal#initialValue()
		 */
		@Override
		protected HashMap<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}
	};

	/**
	 * Set the value
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getThreadVariable(String name) {
		return (T) THREAD_VARIABLES.get().get(name);
	}

	/**
	 * get the value
	 * 
	 */
	public static void setThreadVariable(String name, Object value) {
		THREAD_VARIABLES.get().put(name, value);
	}

	/**
	 * remove the value
	 * 
	 */
	public static void destroy() {
		THREAD_VARIABLES.remove();
	}

	public static String getUserName() {

		return "Guvvala";
	}

	public static String getLocale() {
		return getThreadVariable(LOCALE);
	}

}
