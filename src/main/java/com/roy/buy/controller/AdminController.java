package com.roy.buy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;
import com.roy.buy.entity.Category;
import com.roy.buy.service.ICategoryService;

/**
 * 管理後台Controller
 */
@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	/**
	 * 自動注入CategoryService
	 */
	@Autowired
	private ICategoryService categoryService;
	
	/**
	 * 管理後台首頁
	 */
	@RequestMapping(value = "Home")
	public String home() {
		return View.ADMIN_HOME;
	}
	
	/**
	 * 建立父類別頁面
	 */
	@RequestMapping(value = "CreateParentCategory")
	public String createParentCategory() {
		return View.ADMIN_CREATE_PARENT_CATEGORY;
	}
	
	/**
	 * 建立父類別
	 */
	@RequestMapping(value = "SaveParentCategory")
	public String saveParentCategory(String categoryName) {
		categoryService.createCategory(new Category(categoryName, 0));
		return View.ADMIN_HOME;
	}
	
	/**
	 * 建立子類別頁面
	 */
	@RequestMapping(value = "CreateChildCategory")
	public String createChildCategory() {
		return View.ADMIN_CREATE_CHILD_CATEGORY;
	}
	
	/**
	 * 建立商品頁面
	 */
	@RequestMapping(value = "CreateProduct")
	public String createProduct() {
		return View.ADMIN_CREATE_PRODUCT;
	}

}
