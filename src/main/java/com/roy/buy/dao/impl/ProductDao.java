package com.roy.buy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roy.buy.dao.IProductDao;
import com.roy.buy.entity.Product;

@Service("productDao")
public class ProductDao extends BaseDao<Product> implements IProductDao {
	
	public ProductDao() {
		super(Product.class);
	}

	@Override
	public List<Product> getProductList(int categoryId) {
		return super.findListBy("category", categoryId);
	}

}
