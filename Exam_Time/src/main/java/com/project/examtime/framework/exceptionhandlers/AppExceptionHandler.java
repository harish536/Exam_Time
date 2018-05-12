package com.project.examtime.framework.exceptionhandlers;


import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import com.examtime.constants.MessageEnum;
import com.project.examtime.framework.logging.AppLogger;
import com.project.examtime.framework.logging.Log;
import com.project.examtime.framework.utils.AppBundle;
import com.project.examtime.framework.utils.MessageJson;

/**
 * 
 * @author Harish
 *
 */
@ControllerAdvice
public class AppExceptionHandler {

	private static @Log AppLogger logger;

	@ExceptionHandler(Throwable.class)
	public @ResponseBody ResponseEntity<MessageJson> handleSQLException(Throwable th) {
		MessageJson mjson = getExceptionString(th);
		return new ResponseEntity<MessageJson>(mjson, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * handles the exception and construct the message
	 * 
	 */
	public MessageJson getExceptionString(Throwable th) {
		th.printStackTrace();
		logger.error(th);
		if (th instanceof AppException) {
			AppException ke = (AppException) th;
			if (ke.isShowDetails()) {
				if (ke.getDetails() != null) {
					return new MessageJson(502, ke.getMessageText(), ke.getDetails());
				}
				return new MessageJson(502, ke.getMessageText(), getStackTrace(ke));
			}
			return new MessageJson(501, ke.getMessage());
		} else if (th instanceof PersistenceException) {
			return new MessageJson(501, AppBundle.getString(MessageEnum.UNEXPECTEDFAILURE.getBundle(),
					MessageEnum.UNEXPECTEDFAILURE.getKey()));
		} else if (th instanceof OptimisticLockException) {
			return new MessageJson(501,
					AppBundle.getString(MessageEnum.CONCURRENTMSG.bundleName, MessageEnum.CONCURRENTMSG.key));
		} else {
			return new MessageJson(501, AppBundle.getString(MessageEnum.UNEXPECTEDFAILURE.getBundle(),
					MessageEnum.UNEXPECTEDFAILURE.getKey()));
		}

	}

	public String getStackTrace(AppException ke) {
		if (ke.getThrowable() != null) {
			return ExceptionUtils.getStackTrace(ke.getThrowable());
		} else {
			return ExceptionUtils.getStackTrace(ke);
		}
	}
}