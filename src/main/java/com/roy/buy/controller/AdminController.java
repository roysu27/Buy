package com.roy.buy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roy.buy.constant.BuyConstant;
import com.roy.buy.constant.View;
import com.roy.buy.entity.Category;
import com.roy.buy.form.ProductForm;
import com.roy.buy.service.ICategoryService;
import com.roy.buy.service.IOrderService;
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
	 * 自動注入訂單Service
	 */
	@Autowired
	private IOrderService orderService;
	
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
	public String saveProduct(ProductForm form) {
		productService.createProduct(form.toProduct());;
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
	public String updateProduct(ProductForm form) {
		productService.updateProduct(form.toUpdateProduct());;
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
	
	/**
	 * 取得新訂單列表
	 */
	@RequestMapping(value = "Order/List/New")
	public String orderListNew(Model model) {
		model.addAttribute("orderList", orderService.getNewOrderList());
		return View.ADMIN_ORDER_LIST;
	}
	
	/**
	 * 取得準備中訂單列表
	 */
	@RequestMapping(value = "Order/List/Ready")
	public String orderListReady(Model model) {
		model.addAttribute("orderList", orderService.getReadyOrderList());
		return View.ADMIN_ORDER_LIST;
	}
	
	/**
	 * 取得已出貨訂單列表
	 */
	@RequestMapping(value = "Order/List/Shipping")
	public String orderListShipping(Model model) {
		model.addAttribute("orderList", orderService.getShippingOrderList());
		return View.ADMIN_ORDER_LIST;
	}
	
	/**
	 * 取得已送達訂單列表
	 */
	@RequestMapping(value = "Order/List/Complete")
	public String orderListComplete(Model model) {
		model.addAttribute("orderList", orderService.getCompleteOrderList());
		return View.ADMIN_ORDER_LIST;
	}
	
	/**
	 * 取得已取消訂單列表
	 */
	@RequestMapping(value = "Order/List/Cancel")
	public String orderListCancel(Model model) {
		model.addAttribute("orderList", orderService.getCancelOrderList());
		return View.ADMIN_ORDER_LIST;
	}
	
	/**
	 * 修改訂單狀態
	 */
	@RequestMapping("Order/UpdateState/{orderState}/{orderId}")
	public String orderStateToPicking(
			@PathVariable("orderState") String orderState, 
			@PathVariable("orderId") int orderId, 
			Model model) {
		switch(orderState) {
			case "Picking":
				orderService.updateOrderState(orderId, BuyConstant.ORDER_STATE_PACKING);
				model.addAttribute("orderList", orderService.getNewOrderList());
				break;
			case "Tally":
				orderService.updateOrderState(orderId, BuyConstant.ORDER_STATE_TALLY);
				model.addAttribute("orderList", orderService.getReadyOrderList());
				break;
			case "Shipping":
				orderService.updateOrderState(orderId, BuyConstant.ORDER_STATE_SHIPPING);
				model.addAttribute("orderList", orderService.getReadyOrderList());
				break;
			case "Arrivals":
				orderService.updateOrderState(orderId, BuyConstant.ORDER_STATE_ARRIVALS);
				model.addAttribute("orderList", orderService.getShippingOrderList());
				break;
			case "Cancel":
				orderService.updateOrderState(orderId, BuyConstant.ORDER_STATE_CANCEL);
				model.addAttribute("orderList", orderService.getNewOrderList());
				break;
		}
		return View.ADMIN_ORDER_LIST;
	}

}
