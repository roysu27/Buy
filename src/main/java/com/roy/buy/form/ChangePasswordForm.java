package com.roy.buy.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 修改密碼Form
 */
public class ChangePasswordForm {
	
	/** 舊帳號 */
	private String oldPassword;
	
	/** 新密碼 */
	private String newPassword;
	
	/** 新密碼確認 */
	private String newPasswordCheck;
	
	/** 錯誤訊息 */
	private List<String> errorMessage = new ArrayList<String>();
	
	/**
	 * 驗證ChangePasswordForm, 如果驗證不通過回傳true
	 */
	public boolean validateFail() {
		errorMessage.clear();
		if(oldPassword.length() == 0) {
			errorMessage.add("舊密碼不能空著哦！");
		}
		if(newPassword.length() == 0) {
			errorMessage.add("新密碼不能空著哦！");
		}
		if(newPasswordCheck.length() == 0) {
			errorMessage.add("新密碼確認不能空著哦！");
		}
		if(newPassword.length() != 0 &&
				newPasswordCheck.length() != 0 &&
				!newPassword.equals(newPasswordCheck)) {
			errorMessage.add("兩次新密碼輸入不一樣哦！");
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
	 * 取得MD5加密後的新密碼
	 */
	public String getMD5newPassword() {
		return DigestUtils.md5Hex(newPassword);
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordCheck() {
		return newPasswordCheck;
	}

	public void setNewPasswordCheck(String newPasswordCheck) {
		this.newPasswordCheck = newPasswordCheck;
	}

}
