package com.roy.buy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;
import com.roy.buy.service.IProductService;

/**
 * 商品Controller
 */
@Controller
@RequestMapping("Product")
public class ProductController {

	/**
	 * 自動注入ProductService
	 */
	@Autowired
	private IProductService productService;
	
	/**
	 * 商品列表
	 */
	@RequestMapping("List/{categoryId}")
	public String list(@PathVariable("categoryId") int categoryId, Model model) {
		model.addAttribute("productList", productService.getProductList(categoryId));
		return View.PRODUCT_LIST;
	}

}
