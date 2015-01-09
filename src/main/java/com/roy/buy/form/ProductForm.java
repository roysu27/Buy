package com.roy.buy.form;

import com.roy.buy.entity.Product;

/**
 * 產品表單
 */
public class ProductForm {
	
	/** 商品編號 */
	private int productId;
	
	/** 所屬類別編號 */
	private int childCategory;
	
	/** 商品名稱 */
	private String productName;
	
	/** 定價 */
	private int price;
	
	/** 庫存 */
	private int reserve;
	
	/**
	 * 折扣, 例：八折=80, 八五折=85
	 */
	private int off;
	
	/**
	 * 將ProductForm轉為新Product(不含產品編號)
	 */
	public Product toProduct() {
		return new Product(childCategory, productName, price, reserve, off);
	}
	
	/**
	 * 將ProductForm轉為修改Product(含產品編號)
	 */
	public Product toUpdateProduct() {
		return new Product(productId, childCategory, productName, price, reserve, off);
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getChildCategory() {
		return childCategory;
	}

	public void setChildCategory(int childCategory) {
		this.childCategory = childCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
