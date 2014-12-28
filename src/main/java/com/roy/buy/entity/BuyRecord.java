package com.roy.buy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 購買記錄
 */
@Entity
public class BuyRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主鍵 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** 會員編號 */
	private int userId;
	
	/** 商品編號 */
	private int productId;
	
	/** 訂單編號 */
	private int orderId;
	
	public BuyRecord() {
		
	}
	
	public BuyRecord(int userId, int productId, int orderId) {
		this.userId = userId;
		this.productId = productId;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
