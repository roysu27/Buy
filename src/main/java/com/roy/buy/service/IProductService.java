package com.roy.buy.service;

import java.util.List;

import com.roy.buy.entity.Product;

/**
 * 商品Service
 */
public interface IProductService {
	
	/**
	 * 建立商品
	 */
	public void createProduct(Product product);
	
	/**
	 * 取得商品列表
	 * @param categoryId
	 * 			商品類別編號
	 */
	public List<Product> getProductList(int categoryId);
	
	/**
	 * 取得商品資訊
	 * @param productId
	 * 			商品編號
	 */
	public Product getProductDetail(int productId);

}
