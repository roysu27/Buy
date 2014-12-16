package com.roy.buy.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.buy.dao.IUserDao;
import com.roy.buy.entity.User;
import com.roy.buy.exception.DataCheckException;
import com.roy.buy.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	
	/**
	 * 自動注入UserDao
	 */
	@Autowired
	private IUserDao userDao;

	@Override
	public void register(User user) throws DataCheckException {
		// 驗證是否有相同帳號
		User validateAccountUser = userDao.findByAccount(user.getAccount());
		if(validateAccountUser != null) {
			throw new DataCheckException(1);
		}			
		// 驗證是否有相同Email
		User validateEmailUser = userDao.findByEmail(user.getEmail());
		if(validateEmailUser != null) {
			throw new DataCheckException(2);
		}
		userDao.save(user);
	}

	@Override
	public User login(String account, String password)
			throws DataCheckException {
		// 驗證帳號是否正確
		User user = userDao.findByAccount(account);
		if(user == null) {
			throw new DataCheckException(11);
		}
		// 驗證密碼是否正確
		String md5Password = DigestUtils.md5Hex(password);
		if(!user.getPassword().equals(md5Password)) {
			throw new DataCheckException(12);
		}
		return user;
	}
	
}
