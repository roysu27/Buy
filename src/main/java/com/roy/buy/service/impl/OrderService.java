package com.roy.buy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.buy.constant.BuyConstant;
import com.roy.buy.dao.IOrderDao;
import com.roy.buy.entity.Order;
import com.roy.buy.service.ICartService;
import com.roy.buy.service.IOrderService;
import com.roy.buy.service.IProductService;
import com.roy.buy.service.IUserService;

@Service
public class OrderService implements IOrderService {

	/**
	 * 自動注入OrderDao
	 */
	@Autowired
	private IOrderDao orderDao;
	
	/**
	 * 自動注入ProductService
	 */
	@Autowired
	private IProductService productService;

	/**
	 * 自動注入UserService
	 */
	@Autowired
	private IUserService userService;

	/**
	 * 自動注入CartService
	 */
	@Autowired
	private ICartService cartService;

	@Override
	public Order createOrder(int userId, int[] productIdArray) {
		// 新增訂單
	    Order order = new Order(userId, productService.countProductTotal(productIdArray));
		int orderId = orderDao.save(order);
		order.setId(orderId);
		// 儲存購買記錄
		userService.saveBuyRecord(userId, productIdArray, orderId);
		// 刪除購物車內容
		cartService.deleteProduct(userId);
		return order;
	}

	@Override
	public void confirmOrder(int orderId) {
		Order order = orderDao.findById(orderId);
		order.setState(BuyConstant.ORDER_STATE_CONFIRM);
		orderDao.update(order);
	}

	@Override
	public void cancelOrder(int orderId) {
		Order order = orderDao.findById(orderId);
		order.setState(BuyConstant.ORDER_STATE_CANCEL);
		orderDao.update(order);
	}

	@Override
	public List<Order> getOrderList() {
		return orderDao.findAll();
	}

	@Override
	public Order getOrderDetail(int orderId) {
		return orderDao.findById(orderId);
	}

}
