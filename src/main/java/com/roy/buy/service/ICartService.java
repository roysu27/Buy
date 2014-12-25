package com.roy.buy.service;

import java.util.List;

import com.roy.buy.entity.Product;

/**
 * 購物車Service
 */
public interface ICartService {
	
	/**
	 * 取得購物車商品
	 * @param userId
	 * @return
	 */
	public List<Product> getCartList(int userId);
	
	/**
	 * 新增購物車商品
	 * @param userId
	 * @param productId
	 */
	public void addProduct(int userId, int productId);
	
	/**
	 * 移除購物車商品
	 * @param userId
	 * @param productId
	 */
	public void deleteProduct(int userId, int productId);

}
