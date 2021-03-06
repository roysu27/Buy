package com.roy.buy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.roy.buy.dao.ICategoryDao;
import com.roy.buy.entity.Category;

@Repository
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {
	
	public CategoryDao() {
		super(Category.class);
	}

	@Override
	public List<Category> findByParent(int parent) {
		return super.findListBy("parent", parent);
	}

}
