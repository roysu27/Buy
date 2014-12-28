package com.roy.buy.dao.impl;

import org.springframework.stereotype.Repository;

import com.roy.buy.dao.IOrderDao;
import com.roy.buy.entity.Order;

@Repository
public class OrderDao extends BaseDao<Order> implements IOrderDao {

	public OrderDao() {
		super(Order.class);
	}

}
