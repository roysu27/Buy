package com.roy.buy.service;

import com.roy.buy.entity.Order;

/**
 * 訂單Service
 */
public interface IOrderService {
	
	/**
	 * 建立訂單
	 * @param userId
	 * 			會員編號
	 * @param productId
	 * 			商品編號陣列
	 * @return 訂單
	 */
	public Order createOrder(int userId, int[] productIdArray);

}
