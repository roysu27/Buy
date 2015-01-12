package com.roy.buy.dao;

import java.util.List;

import com.roy.buy.entity.Order;

/**
 * 訂單Dao
 */
public interface IOrderDao extends IBaseDao<Order> {
	
	public void update(Order order);
	
	/**
	 * 根據訂單狀態查詢訂單
	 * @param orderState
	 * 			訂單狀態
	 * @return
	 */
	public List<Order> getOrderList(int orderState);
	
	/**
	 * 根據多種訂單狀態查詢訂單
	 * @param orderStateList
	 * 			訂單狀態List
	 * @return
	 */
	public List<Order> getOrderList(List<Integer> orderStateList);
	
	/**
	 * 修改訂單狀態
	 * @param orderId
	 * 			訂單編號
	 * @param orderState
	 * 			要改成什麼狀態
	 */
	public void updateOrderState(int orderId, int orderState);
	
	/**
	 * 分頁用, 查詢某個區間的訂單
	 * @param begin
	 * 			開始位置
	 * @param size
	 * 			查詢筆數
	 * @return
	 */
	public List<Order> findOrderList(int begin, int size);
	
	/**
	 * 取得訂單筆數
	 * @param userId
	 * 			使用者id
	 * @return
	 */
	public int findOrderCount(int userId);

}
