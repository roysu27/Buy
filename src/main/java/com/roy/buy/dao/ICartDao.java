package com.roy.buy.dao;

import java.util.List;

import com.roy.buy.entity.Cart;

/**
 * 購物車Dao
 */
public interface ICartDao extends IBaseDao<Cart> {
	
	/**
	 * 根據會員編號查詢, 若查詢不到回傳null
	 */
	public List<Cart> findByUserId(int userId);
	
	/**
	 * 根據會員編號與商品編號刪除購物車商品
	 * @param userId
	 * @param productId
	 */
	public void deleteCartByUserIdAndProductId(int userId, int productId);

}
