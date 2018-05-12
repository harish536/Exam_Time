package com.project.examtime.framework.utils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Hari
 * 
 *         This class contains all utility methods used in KAPA
 *
 */

public class AppWebUtils {

	public static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * Converts the double value to string
	 * 
	 */
	public static String doubleToString(Object value, String pattern) {
		if (value == null) {
			return null;
		}
		DecimalFormat priceFormat = new DecimalFormat(pattern, new DecimalFormatSymbols(Locale.ENGLISH));
		return priceFormat.format(value);
	}

	public static String convertObjectToJson(Object o) throws JsonProcessingException {
		return mapper.writeValueAsString(o);
	}

	public static <T> T convertJsonToObject(Class<T> clazz, String json) throws IOException {
		return mapper.readValue(json, clazz);
	}

}
