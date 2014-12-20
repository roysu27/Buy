package com.roy.buy.dao;

import java.util.List;

import com.roy.buy.entity.Product;

/**
 * 商品Dao
 */
public interface IProductDao extends IBaseDao<Product> {
	
	/**
	 * 根據商品類別編號查詢商品
	 * @param categoryId
	 * 			商品類別編號
	 * @return
	 */
	public List<Product> getProductList(int categoryId);

}
