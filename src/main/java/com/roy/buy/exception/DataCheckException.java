package com.roy.buy.exception;

/**
 * 資料正確性例外
 */
public class DataCheckException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/** 錯誤代碼 */
	private int id;
	
	/** 錯誤訊息 */
	private String message;
	
	/**
	 * 建立時必須傳入錯誤代碼
	 */
	public DataCheckException(int id) {
		this.id = id;
	}

	/**
	 * 取得例外訊息
	 */
	public String getMessage() {
		switch(id) {
			case 1:
				message = "這帳號被別人註冊囉，請您更換一個帳號。";
				break;
			case 2:
				message = "這Email被別人註冊囉，請您更換一個Email。";
				break;
			case 11:
				message = "查無此帳號，請確認後再次輸入。";
				break;
			case 12:
				message = "密碼錯誤，請確認後再次輸入。";
				break;
			default:
				message = "資料驗證錯誤。";
				break;
		}
		return message;
	}

}
