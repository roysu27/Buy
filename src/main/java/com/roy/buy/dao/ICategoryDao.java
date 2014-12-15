package com.roy.buy.dao;

import java.util.List;

import com.roy.buy.entity.Category;

/**
 * 商品類別Dao
 */
public interface ICategoryDao extends IBaseDao<Category> {
	
	/**
	 * 根據父類別編號查詢, 若查詢不到回傳null
	 */
	public List<Category> findByParent(int parent);

}
