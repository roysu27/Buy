package com.roy.buy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.roy.buy.dao.IProductDao;
import com.roy.buy.entity.Product;

@Repository
public class ProductDao extends BaseDao<Product> implements IProductDao {
	
	public ProductDao() {
		super(Product.class);
	}

	@Override
	public List<Product> findProductList(int categoryId) {
		return super.findListBy("category", categoryId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductListByLikeStr(String searchStr) {
        Criteria criteria = super.getSession().createCriteria(Product.class);    
        criteria.add(Restrictions.like("name", "%" + searchStr + "%"));
		return criteria.list();
	}

	@Override
	public List<Product> findProductListByProductIdList(List<Integer> productIdList) {
		return super.findListBy("id", productIdList);
	}
	
	@Override
	public void update(Product product) {
		super.update(product);
		super.getSession().flush();
	}

}
