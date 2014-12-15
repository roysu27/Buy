package com.roy.buy.service;

import java.util.List;

import com.roy.buy.entity.Category;

/**
 * 商品類別Service
 */
public interface ICategoryService {
	
	/**
	 * 建立類別
	 */
	public void createCategory(Category category);
	
	/**
	 * 取得所有父類別
	 */
	public List<Category> getParentCategoryList();

}
