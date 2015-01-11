package com.roy.buy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.buy.dao.IProductDao;
import com.roy.buy.entity.Product;
import com.roy.buy.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	/**
	 * 自動注入ProductDao
	 */
	@Autowired
	private IProductDao productDao;

	@Override
	public void createProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> getProductList(int categoryId) {
		return productDao.findProductList(categoryId);
	}

	@Override
	public Product getProductDetail(int productId) {
		return productDao.findById(productId);
	}

	@Override
	public List<Product> searchProduct(String searchStr) {
		return productDao.findProductListByLikeStr(searchStr);
	}

	@Override
	public int countProductTotal(int[] productIdArray) {
		List<Integer> productIdList = new ArrayList<>();
		for(int id : productIdArray) {
			productIdList.add(new Integer(id));
		}
		List<Product> productList = productDao.findProductListByProductIdList(productIdList);
		return productList.stream()
				.mapToInt(Product::getDiscountsPrice)
				.sum();
	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
	}

	@Override
	public List<Product> getProductListByIdList(List<Integer> idList) {
		return productDao.findProductListByProductIdList(idList);
	}

}
