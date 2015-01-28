package com.roy.buy.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.buy.dao.IBuyRecordDao;
import com.roy.buy.dao.IUserDao;
import com.roy.buy.entity.BuyRecord;
import com.roy.buy.entity.User;
import com.roy.buy.exception.DataCheckException;
import com.roy.buy.form.ChangePasswordForm;
import com.roy.buy.service.IUserService;

@Service
public class UserService implements IUserService {
	
	/**
	 * 自動注入UserDao
	 */
	@Autowired
	private IUserDao userDao;
	
	/**
	 * 自動注入BuyRecordDao
	 */
	@Autowired
	private IBuyRecordDao buyRecord;

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

	@Override
	public User changePassword(int userId, ChangePasswordForm form)
			throws DataCheckException {
		if(!passwordCheck(userId, form.getOldPassword())) {
			throw new DataCheckException(12);
		}
		User user = userDao.findById(userId);
		user.setPassword(form.getMD5newPassword());
		userDao.update(user);
		return user;
	}
	
	/**
	 * 驗證輸入的密碼是否正確
	 * @param userId
	 * 			會員編號
	 * @param password
	 * 			輸入密碼
	 * @return
	 */
	private boolean passwordCheck(int userId, String password) {
		User user = userDao.findById(userId);
		String md5Password = DigestUtils.md5Hex(password);
		return user.getPassword().equals(md5Password);
	}

	@Override
	public void saveBuyRecord(int userId, int[] productIdArray, int[] prductQuantityArray, int orderId) {
		for (int i = 0; i < productIdArray.length; i++) {
			buyRecord.save(new BuyRecord(userId, productIdArray[i], orderId, prductQuantityArray[i]));
		}
	}
	
}
