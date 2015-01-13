package com.roy.buy.utils;

/**
 * 工具
 */
public class Utils {
	
	/**
	 * 取得檔案的副檔名
	 * @param fileName
	 * 			檔案名稱
	 * @return 副檔名, 例如：「.txt」
	 */
	public static String getFileExtension(String fileName) {
		return fileName.substring(fileName.indexOf("."), fileName.length());
	}

}
