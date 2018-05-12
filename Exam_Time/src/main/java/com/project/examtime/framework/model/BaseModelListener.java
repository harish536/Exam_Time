package com.project.examtime.framework.model;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.project.examtime.framework.utils.ThreadLocalUtils;

/**
 * 
 * @author Harish
 *
 */

public class BaseModelListener {

	@PreUpdate
	public void beforeUpdate(BaseModel entity) {
		entity.setUpdatedBy(getUserName());
		entity.setUpdatedDate(new Date());
	}

	@PrePersist
	public void beforePersist(BaseModel entity) {
		Date now = new Date();
		entity.setCreatedBy(getUserName());
		entity.setCreatedDate(now);
		entity.setUpdatedBy(getUserName());
		entity.setUpdatedDate(now);
	}

	/**
	 * Get user name from thread context - set in the session filter
	 * 
	 * @return
	 */
	private String getUserName() {
		return ThreadLocalUtils.getUserName();
	}

}
