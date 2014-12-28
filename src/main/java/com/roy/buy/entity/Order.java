package com.roy.buy.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 訂單
 */
@Entity
@Table(name = "order_")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主鍵, 訂單編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** 會員編號 */
	private int userId;
	
	/** 訂單金額 */
	private int money;
	
	/**
	 * 付款狀態
	 * true = 已付款
	 * false = 未付款
	 */
	private boolean pay;
	
	/**
	 * 訂單狀態
	 * 0 = 訂單成立
	 * 1 = 收到訂單
	 * 2 = 撿貨
	 * 3 = 理貨
	 * 4 = 出貨
	 * 5 = 送達
	 */
	private int state;
	
	/** 訂單成立時間 */
	private Timestamp createTime;
	
	public Order(int userId, int money) {
		this.userId = userId;
		this.money = money;
		this.createTime = new Timestamp(System.currentTimeMillis());
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
