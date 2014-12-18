package com.roy.buy.dao.impl;

import org.springframework.stereotype.Service;

import com.roy.buy.dao.IProductDao;
import com.roy.buy.entity.Product;

@Service("productDao")
public class ProductDao extends BaseDao<Product> implements IProductDao {
	
	public ProductDao() {
		super(Product.class);
	}

}
