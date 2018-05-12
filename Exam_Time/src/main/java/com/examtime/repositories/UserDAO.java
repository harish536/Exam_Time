package com.examtime.repositories;



import com.examtime.models.User;
import com.project.examtime.framework.dao.BaseDAO;

public interface UserDAO extends BaseDAO<User,Integer> {
	void save(User user);

}
