package com.examtime.repositories;

import org.springframework.stereotype.Repository;
import com.examtime.models.User;
import com.project.examtime.framework.dao.BaseDAOImpl;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User,Integer>  implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}
	
	@Override
	public void save(User user) {
		create(user);
	}

}
