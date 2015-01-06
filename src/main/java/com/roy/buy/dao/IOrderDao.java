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

}
