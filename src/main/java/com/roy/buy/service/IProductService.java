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
	
	/**
	 * 搜尋商品
	 * @param searchStr
	 * 			搜尋字串
	 */
	public List<Product> searchProduct(String searchStr);
	
	/**
	 * 計算多樣商品總額
	 * @param productId
	 * 			商品編號陣列
	 * @return 商品總額
	 */
	public int countProductTotal(int[] productIdArray);
	
	/**
	 * 修改商品
	 */
	public void updateProduct(Product product);

}
