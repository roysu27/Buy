package com.roy.buy.dao.impl;

import org.springframework.stereotype.Service;

import com.roy.buy.dao.IUserDao;
import com.roy.buy.entity.User;

@Service("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {
	
	public UserDao() {
		super(User.class);
	}

	@Override
	public User findByAccount(String account) {
		return super.findBy("account", account);
	}

	@Override
	public User findByEmail(String email) {
		return super.findBy("email", email);
	}

}
