package com.roy.buy.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.roy.buy.entity.User;

/**
 * 註冊Form
 */
public class RegisterForm {
	
	/** 帳號 */
	private String account;
	
	/** 密碼 */
	private String password;
	
	/** 密碼確認 */
	private String passwordCheck;
	
	/** 姓名 */
	private String name;
	
	/** 信箱 */
	private String email;
	
	/** 錯誤訊息 */
	private List<String> errorMessage = new ArrayList<String>();
	
	/**
	 * 驗證RegisterForm, 如果驗證不通過回傳true
	 */
	public boolean validateFail() {
		errorMessage.clear();
		if(account.length() == 0) {
			errorMessage.add("帳號不能空著哦！");
		}
		if(password.length() == 0) {
			errorMessage.add("密碼不能空著哦！");
		}
		if(passwordCheck.length() == 0) {
			errorMessage.add("密碼確認不能空著哦！");
		}
		if(name.length() == 0) {
			errorMessage.add("姓名不能空著哦！");
		}
		if(email.length() == 0) {
			errorMessage.add("Email不能空著哦！");
		}
		if(password.length() != 0 &&
				passwordCheck.length() != 0 &&
				!password.equals(passwordCheck)) {
			errorMessage.add("兩次密碼輸入不一樣哦！");
		}
		return errorMessage.size() > 0;
	}
	
	/**
	 * 取得驗證失敗的錯誤訊息
	 */
	public List<String> getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * 將RegisterForm轉為User
	 */
	public User toUser() {
		User user = new User();
		user.setAccount(account);
		user.setPassword(DigestUtils.md5Hex(password));
		user.setName(name);
		user.setEmail(email);
		return user;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
