package com.roy.buy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.roy.buy.constant.BuyConstant;
import com.roy.buy.dao.IBuyRecordDao;
import com.roy.buy.dao.IOrderDao;
import com.roy.buy.entity.BuyRecord;
import com.roy.buy.entity.Order;
import com.roy.buy.entity.Product;
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

	@Autowired
	private IBuyRecordDao buyRecordDao;

	@Autowired
	private HibernateTransactionManager transactionManager;

	@Override
	public Order createOrder(int userId, int[] productIdArray, int[] prductQuantityArray) {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		Order order;
		try {
			// 新增訂單
		    order = new Order(userId, productService.countProductTotal(productIdArray, prductQuantityArray));
			int orderId = orderDao.save(order);
			order.setId(orderId);
			// 儲存購買記錄
			userService.saveBuyRecord(userId, productIdArray, prductQuantityArray, orderId);
			// 扣除購買商品庫存量
			productService.deductBuyProduct(productIdArray, prductQuantityArray);
			// 刪除購物車內容
			cartService.deleteProduct(userId);
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
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

	@Override
	public List<BuyRecord> getBuyRecordList(int orderId) {
		List<BuyRecord> buyRecordList = buyRecordDao.findByOrderId(orderId);
		// 根據購買記錄取得該訂單產品編號列表
		for(BuyRecord buyRecord : buyRecordList) {
			Product product = productService.getProductDetail(buyRecord.getProductId());
			buyRecord.setProduct(product);
		}
		return buyRecordList;
	}

	@Override
	public List<Order> getNewOrderList() {
		return orderDao.getOrderList(BuyConstant.ORDER_STATE_CONFIRM);
	}

	@Override
	public List<Order> getReadyOrderList() {
		List<Integer> orderStateList = new ArrayList<>();
		orderStateList.add(BuyConstant.ORDER_STATE_PACKING);
		orderStateList.add(BuyConstant.ORDER_STATE_TALLY);
		return orderDao.getOrderList(orderStateList);
	}

	@Override
	public List<Order> getShippingOrderList() {
		return orderDao.getOrderList(BuyConstant.ORDER_STATE_SHIPPING);
	}

	@Override
	public List<Order> getCompleteOrderList() {
		return orderDao.getOrderList(BuyConstant.ORDER_STATE_ARRIVALS);
	}

	@Override
	public List<Order> getCancelOrderList() {
		return orderDao.getOrderList(BuyConstant.ORDER_STATE_CANCEL);
	}

	@Override
	public void updateOrderState(int orderId, int orderState) {
		orderDao.updateOrderState(orderId, orderState);
	}

	@Override
	public List<Order> getOrderList(int userId, int page, int size) {
		int begin = (page - 1) * size;
		return orderDao.findOrderList(userId, begin, size);
	}

	@Override
	public int getOrderTotal(int userId) {
		return orderDao.findOrderCount(userId);
	}

}
