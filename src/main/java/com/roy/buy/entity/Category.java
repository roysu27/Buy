package com.roy.buy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商品類別
 */
@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主鍵, 類別編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** 商品名稱 */
	private String name;
	
	/** 父類別編號 */
	private int parent;
	
	public Category() {
		
	}
	
	public Category(String name, int parent) {
		this.name = name;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

}
