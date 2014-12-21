package com.roy.buy.dao;

import com.roy.buy.entity.User;

/**
 * 會員Dao
 */
public interface IUserDao extends IBaseDao<User> {

	/**
	 * 根據帳號查詢, 若查詢不到回傳null
	 */
	public User findByAccount(String account);
	
	/**
	 * 根據Email查詢, 若查詢不到回傳null
	 */
	public User findByEmail(String email);
	
	/**
	 * 修改會員
	 */
	public void update(User user);

}
