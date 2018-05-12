package com.project.examtime.framework.exceptionhandlers;

import com.project.examtime.framework.utils.AppBundle;
import com.project.examtime.framework.utils.BasePropertyEnum;

public class AppException extends BaseAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean showDetails;

	private String details;

	/**
	 * Default constructor
	 */
	public AppException() {

	}

	/**
	 * Creates new AppException
	 * 
	 * @param messageId
	 * @param messageTextParams
	 */
	public AppException(final BasePropertyEnum property, final Object... params) {
		setMessageText(AppBundle.getString(property, params));
	}

	/**
	 * Creates new AppException
	 * 
	 * @param messageId
	 * @param messageTextParams
	 */
	public AppException(final String messageId, final Object... messageTextParams) {
		setMessageId(messageId);
		setMessageText(messageId);
		setMessageTextParams(messageTextParams);

	}

	/**
	 * Creates new AppException
	 * 
	 * @param bundeledMessage
	 */
	public AppException(boolean showDetails, final BasePropertyEnum property, String details) {
		setMessageText(AppBundle.getString(property.getBundle(), property.getKey()));
		setDetails(details);
		setShowDetails(showDetails);
	}

	/**
	 * Creates new AppException
	 * 
	 * @param messageId
	 * @param messageTextParams
	 */
	public AppException(boolean showDetails, final Throwable th, final BasePropertyEnum property,
			final Object... params) {
		super(th);
		this.setThrowable(th);
		this.showDetails = showDetails;
		setMessageText(AppBundle.getString(property.getBundle(), property.getKey(), params));
	}

	/**
	 * Creates new AppException
	 * 
	 * @param messageId
	 * @param th
	 * @param messageTextParams
	 */
	public AppException(final String messageId, final Throwable th, final Object... messageTextParams) {
		super(th);
		setMessageId(messageId);
		setThrowable(th);
		setMessageTextParams(messageTextParams);

	}

	/**
	 * String representation of the exception object
	 */
	@Override
	public String toString() {
		StringBuffer message = new StringBuffer();
		message.append(getMessageText());

		if (throwable != null) {
			message.append(", cause: ");
			message.append(getThrowable());
		}

		return message.toString();
	}

	public boolean isShowDetails() {
		return showDetails;
	}

	public void setShowDetails(boolean showDetails) {
		this.showDetails = showDetails;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
