package com.roy.buy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;
import com.roy.buy.service.IOrderService;

/**
 * 訂單
 */
@Controller
@RequestMapping("Order")
public class OrderController {

	/**
	 * 自動注入訂單Service
	 */
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 確認訂單
	 */
	@RequestMapping("Confirm/{orderId}")
	public String confirm(@PathVariable("orderId") int orderId) {
		orderService.confirmOrder(orderId);
		return View.ORDER_CONFIRM;
	}
	
	/**
	 * 取消訂單
	 */
	@RequestMapping("Cancel/{orderId}")
	public String cancel(@PathVariable("orderId") int orderId) {
		orderService.cancelOrder(orderId);
		return View.ORDER_CANCEL;
	}

}
