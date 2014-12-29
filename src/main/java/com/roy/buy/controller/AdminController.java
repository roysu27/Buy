package com.roy.buy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roy.buy.constant.View;
import com.roy.buy.entity.Category;
import com.roy.buy.entity.Product;
import com.roy.buy.service.ICategoryService;
import com.roy.buy.service.IProductService;

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
	 * 自動注入ProductService
	 */
	@Autowired
	private IProductService productService;
	
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
	public String createChildCategory(Model model) {
		model.addAttribute("parentCategoryList", categoryService.getParentCategoryList());
		return View.ADMIN_CREATE_CHILD_CATEGORY;
	}
	
	/**
	 * 建立子類別
	 */
	@RequestMapping(value = "SaveChildCategory")
	public String saveChildCategory(int parentCategory, String categoryName) {
		categoryService.createCategory(new Category(categoryName, parentCategory));
		return View.ADMIN_HOME;
	}
	
	/**
	 * 建立商品頁面
	 */
	@RequestMapping(value = "CreateProduct")
	public String createProduct(Model model) {
		model.addAttribute("parentCategoryList", categoryService.getParentCategoryList());
		return View.ADMIN_CREATE_PRODUCT;
	}
	
	/**
	 * 根據父類別取得子類別
	 */
	@RequestMapping(value = "GetChildCategory/{parentCategory}")
	@ResponseBody
	public Object getChildCategory(@PathVariable("parentCategory") int parentCategory) {
		return categoryService.getChildCategoryList(parentCategory);
	}
	
	/**
	 * 建立商品
	 */
	@RequestMapping(value = "SaveProduct")
	public String saveProduct(int childCategory, String productName, int price) {
		productService.createProduct(new Product(childCategory, productName, price));;
		return View.ADMIN_HOME;
	}
	
	/**
	 * 修改商品頁面
	 */
	@RequestMapping(value = "UpdateProductPage")
	public String updateProductPage(Model model) {
		model.addAttribute("parentCategoryList", categoryService.getParentCategoryList());
		return View.ADMIN_UPDATE_PRODUCT;
	}
	
	/**
	 * 根據子類別取得商品
	 */
	@RequestMapping(value = "GetProductList/{childCategory}")
	@ResponseBody
	public Object getProductList(@PathVariable("childCategory") int childCategory) {
		return productService.getProductList(childCategory);
	}
	
	/**
	 * 修改商品
	 */
	@RequestMapping(value = "UpdateProduct")
	public String updateProduct(int productId, int childCategory, String productName, int price) {
		Product product = new Product(childCategory, productName, price);
		product.setId(productId);
		productService.updateProduct(product);;
		return View.ADMIN_HOME;
	}
	
	/**
	 * 根據商品編號取得商品內容
	 */
	@RequestMapping(value = "GetProduct/{productId}")
	@ResponseBody
	public Object getProduct(@PathVariable("productId") int productId) {
		return productService.getProductDetail(productId);
	}

}
