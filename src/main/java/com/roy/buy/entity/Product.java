package com.roy.buy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商品
 */
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主鍵, 商品編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** 所屬類別編號 */
	private int category;
	
	/** 商品名稱 */
	private String name;
	
	/** 定價 */
	private int price;
	
	/** 庫存 */
	private int reserve;
	
	/**
	 * 折扣, 例：八折=80, 八五折=85
	 */
	private int off;
	
	public Product() {
		
	}
	
	public Product(int category, String name, int price, int reserve, int off) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.reserve = reserve;
		this.off = off;
	}
	
	public Product(int id, int category, String name, int price, int reserve, int off) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.reserve = reserve;
		this.off = off;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getReserve() {
		return reserve;
	}

	public void setReserve(int reserve) {
		this.reserve = reserve;
	}

	public int getOff() {
		return off;
	}

	public void setOff(int off) {
		this.off = off;
	}

}
