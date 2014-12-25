package com.roy.buy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.buy.dao.ICartDao;
import com.roy.buy.dao.IProductDao;
import com.roy.buy.entity.Cart;
import com.roy.buy.entity.Product;
import com.roy.buy.service.ICartService;

@Service
public class CartService implements ICartService {
	
	/**
	 * 自動注入CartDao
	 */
	@Autowired
	private ICartDao cartDao;
	
	/**
	 * 自動注入ProductDao
	 */
	@Autowired
	private IProductDao productDao;

	@Override
	public List<Product> getCartList(int userId) {
		List<Cart> cartList = cartDao.findByUserId(userId);
		if(cartList == null) {
			return null;
		}
		List<Integer> productIdList = new ArrayList<>();
		for(Cart cart : cartList) {
			productIdList.add(cart.getProductId());
		}
		return productDao.findProductListByProductIdList(productIdList);
	}

	@Override
	public void addProduct(int userId, int productId) {
		cartDao.save(new Cart(userId, productId));
	}

	@Override
	public void deleteProduct(int userId, int productId) {
		cartDao.deleteCartByUserIdAndProductId(userId, productId);
	}

}
