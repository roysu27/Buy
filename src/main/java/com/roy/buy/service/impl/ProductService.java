package com.roy.buy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.buy.dao.IProductDao;
import com.roy.buy.entity.Product;
import com.roy.buy.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	/**
	 * 自動注入CategoryDao
	 */
	@Autowired
	private IProductDao productDao;

	@Override
	public void createProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> getProductList(int categoryId) {
		return productDao.getProductList(categoryId);
	}

}
