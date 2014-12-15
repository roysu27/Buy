package com.roy.buy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.buy.dao.ICategoryDao;
import com.roy.buy.entity.Category;
import com.roy.buy.service.ICategoryService;

@Service("categoryService")
public class CategoryService implements ICategoryService {
	
	/**
	 * 自動注入CategoryDao
	 */
	@Autowired
	private ICategoryDao categoryDao;

	@Override
	public void createCategory(Category category) {
		categoryDao.save(category);
	}

}
