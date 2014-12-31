package com.roy.buy.service;

import java.util.List;

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
	
	/**
	 * 確認訂單
	 * @param orderId
	 */
	public void confirmOrder(int orderId);
	
	/**
	 * 取消訂單
	 * @param orderId
	 */
	public void cancelOrder(int orderId);
	
	/**
	 * 取得訂單列表
	 * @return
	 */
	public List<Order> getOrderList();
	
	/**
	 * 取得訂單資訊
	 * @param orderId
	 * @return
	 */
	public Order getOrderDetail(int orderId);

}
