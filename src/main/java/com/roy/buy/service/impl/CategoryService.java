package com.roy.buy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.buy.constant.BuyConstant;
import com.roy.buy.dao.ICategoryDao;
import com.roy.buy.entity.Category;
import com.roy.buy.service.ICategoryService;

@Service
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

	@Override
	public List<Category> getParentCategoryList() {
		return categoryDao.findByParent(0);
	}

	@Override
	public List<Category> getChildCategoryList(int parent) {
		return categoryDao.findByParent(parent);
	}

	@Override
	public Map<Category, List<Category>> getSidebar() {
		Map<Category, List<Category>> result = new LinkedHashMap<>();
		Map<Integer, List<Category>> sortCategoryMap = getSortCategoryMap();
		// 避免沒有商品類別時發生NullPointerException
		if(sortCategoryMap.isEmpty()) {
			return result;
		}
		// 跑所有父類別迴圈, 將父類別放進Map的key, 父類別下所屬子類別放進value
		for(Category category : sortCategoryMap.get(BuyConstant.CATEGORY_ROOT)) {
			result.put(category, sortCategoryMap.get(category.getId()));
		}
		return result;
	}
	
	/**
	 * 取得分類後的商品類別Map(key為父類別編號, value為屬於該父類別下的子類別List)
	 */
	private Map<Integer, List<Category>> getSortCategoryMap() {
		Map<Integer, List<Category>> result = new HashMap<>();
		for(Category category : categoryDao.findAll()) {
			// 取得父類別編號
			int parent = category.getParent();
			// 根據父類別編號取得類別List, 若沒有新增一個
			List<Category> categoryList = result.get(parent);
			if(categoryList == null) {
				categoryList = new ArrayList<>();
			}
			// 將類別放入類別List
			categoryList.add(category);
			// 放入Map, key為父類別編號, value為類別List
			result.put(parent, categoryList);
		}
		return result;
	}

}
