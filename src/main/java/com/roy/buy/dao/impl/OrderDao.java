package com.roy.buy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.roy.buy.dao.IOrderDao;
import com.roy.buy.entity.Order;

@Repository
public class OrderDao extends BaseDao<Order> implements IOrderDao {

	public OrderDao() {
		super(Order.class);
	}

	@Override
	public void update(Order order) {
		super.getSession().update(order);
		super.getSession().flush();
	}

	@Override
	public List<Order> getOrderList(int orderState) {
		return super.findListBy("state", orderState);
	}

	@Override
	public List<Order> getOrderList(List<Integer> orderStateList) {
		return super.findListBy("state", orderStateList);
	}

	@Override
	public void updateOrderState(int orderId, int orderState) {
		String hql = "UPDATE Order SET state = :state WHERE id = :orderId";
		Query query = super.getSession().createQuery(hql);
		query.setInteger("state", orderState);
		query.setInteger("orderId", orderId);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findOrderList(int userId, int begin, int size) {
        Criteria criteria = getSession().createCriteria(Order.class);  
        criteria.add(Restrictions.in("userId", new Object[]{userId}));
        criteria.setFirstResult(begin);
        criteria.setMaxResults(size);
        return criteria.list();
	}

	@Override
	public int findOrderCount(int userId) {
		String hql = "SELECT COUNT(id) FROM Order WHERE userId = :userId";
		Query query = super.getSession().createQuery(hql);
		query.setInteger("userId", userId);
		return Integer.valueOf(query.uniqueResult().toString());
	}

}
