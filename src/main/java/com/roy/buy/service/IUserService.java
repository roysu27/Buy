package com.roy.buy.service;

import com.roy.buy.entity.User;
import com.roy.buy.exception.DataCheckException;
import com.roy.buy.form.ChangePasswordForm;

/**
 * 會員Service
 */
public interface IUserService {

	/**
	 * 會員註冊, 如果帳號或信箱已被申請過會抛出例外
	 */
	public void register(User user) throws DataCheckException;

	/**
	 * 會員登入, 如果查無此帳號或密碼錯誤會抛出例外
	 * @param account
	 * 			會員帳號
	 * @param password
	 * 			會員密碼
	 * @return {@link User}
	 * @throws DataCheckException
	 */
	public User login(String account, String password) throws DataCheckException;
	
	/**
	 * 修改密碼, 如果舊密碼錯誤會拋出例外
	 * @param userId
	 * 			會員編號
	 * @param form
	 * 			修改密碼Form
	 * @return {@link User}
	 * @throws DataCheckException
	 */
	public User changePassword(int userId, ChangePasswordForm form) throws DataCheckException;
}
