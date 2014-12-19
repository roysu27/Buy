package com.roy.buy.service;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 根據父類別編號取得子類別列表
	 */
	public List<Category> getChildCategoryList(int parent);
	
	/**
	 * 取得側邊欄
	 */
	public Map<Category, List<Category>> getSidebar();

}
