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
	
	public Product() {
		
	}
	
	public Product(int category, String name) {
		this.category = category;
		this.name = name;
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

}
