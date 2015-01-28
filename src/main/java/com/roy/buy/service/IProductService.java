package com.roy.buy.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	 * 取得所有商品列表
	 * @return
	 */
	public List<Product> getProductList();
	
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
	 * @param productIdArray
	 * 			商品編號陣列
	 * @param prductQuantityArray
	 * 			商品購買數量陣列
	 * @return 商品總額
	 */
	public int countProductTotal(int[] productIdArray, int[] prductQuantityArray);
	
	/**
	 * 修改商品
	 */
	public void updateProduct(Product product);
	
	/**
	 * 根據商品編號列表取得商品列表
	 * @param idList
	 * @return
	 */
	public List<Product> getProductListByIdList(List<Integer> idList);
	
	/**
	 * 新增商品圖片
	 * @param id
	 * 			商品編號
	 * @param image
	 * 			商品圖片
	 * @param webappRootPath
	 * 			網站根目錄
	 */
	public void addProductImage(int id, MultipartFile image, String webappRootPath) throws IOException;

}
