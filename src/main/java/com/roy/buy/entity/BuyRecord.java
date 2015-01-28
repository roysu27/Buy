package com.roy.buy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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
	
	/** 購買數量 */
	private int quantity;
	
	/** 訂單編號 */
	private int orderId;
	
	/** 商品 */
	@Transient
	private Product product;
	
	public BuyRecord() {
		
	}
	
	public BuyRecord(int userId, int productId, int orderId, int quantity) {
		this.userId = userId;
		this.productId = productId;
		this.orderId = orderId;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
