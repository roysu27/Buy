package com.roy.buy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 購物車
 */
@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主鍵 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** 會員編號 */
	private int userId;
	
	/** 商品編號 */
	private int productId;
	
	public Cart() {
		
	}
	
	public Cart(int id) {
		this.id = id;
	}
	
	public Cart(int userId, int productId) {
		this.userId = userId;
		this.productId = productId;
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

}
