package com.project.examtime.framework.utils;

/**
 * 
 * @author Harish
 * 
 *         All properties Enums should extend this interface which help for
 *         processing the messages
 *
 */

public interface BasePropertyEnum {

	public String getBundle();

	public String getKey();

	public Integer getStatusCode();

}
