package com.roy.buy.service;

import com.roy.buy.entity.User;
import com.roy.buy.exception.DataCheckException;

/**
 * 會員Service
 */
public interface IUserService {

	/**
	 * 會員註冊, 如果帳號或信箱已被申請過會抛出例外
	 */
	public void register(User user) throws DataCheckException;

}
