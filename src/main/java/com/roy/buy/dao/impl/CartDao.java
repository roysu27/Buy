package com.roy.buy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.roy.buy.dao.ICartDao;
import com.roy.buy.entity.Cart;

@Repository
public class CartDao extends BaseDao<Cart> implements ICartDao {
	
	public CartDao() {
		super(Cart.class);
	}

	@Override
	public List<Cart> findByUserId(int userId) {
		return super.findListBy("userId", userId);
	}

	@Override
	public void deleteCartByUserIdAndProductId(int userId, int productId) {
		String hql = "DELETE Cart WHERE userId = :userId AND productId = :productId";
		Query query = super.getSession().createQuery(hql);
		query.setInteger("userId", userId);
		query.setInteger("productId", productId);
		query.executeUpdate();
	}

}
