package com.roy.buy.dao;

import com.roy.buy.entity.Order;

/**
 * 訂單Dao
 */
public interface IOrderDao extends IBaseDao<Order> {
	
	public void update(Order order);

}
