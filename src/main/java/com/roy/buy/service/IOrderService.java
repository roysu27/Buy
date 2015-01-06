package com.roy.buy.service;

import java.util.List;

import com.roy.buy.entity.Order;
import com.roy.buy.entity.Product;

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
	
	/**
	 * 取得訂單產品
	 * @param orderId
	 * @return
	 */
	public List<Product> getProductList(int orderId);
	
	/**
	 * 取得新訂單列表(狀態為確認)
	 * @return
	 */
	public List<Order> getNewOrderList();
	
	/**
	 * 取得準備中訂單列表(狀態為撿貨或理貨)
	 * @return
	 */
	public List<Order> getReadyOrderList();
	
	/**
	 * 取得已送達訂單列表(狀態為已送達)
	 * @return
	 */
	public List<Order> getCompleteOrderList();

}
