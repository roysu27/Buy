package com.roy.buy.controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;
import com.roy.buy.entity.User;
import com.roy.buy.exception.DataCheckException;
import com.roy.buy.form.ChangePasswordForm;
import com.roy.buy.service.ICartService;
import com.roy.buy.service.IOrderService;
import com.roy.buy.service.IUserService;

/**
 * 會員Controller
 */
@Controller
@RequestMapping("/User")
public class UserController {

	/**
	 * 自動注入UserService
	 */
	@Autowired
	private IUserService userService;

	/**
	 * 自動注入CartService
	 */
	@Autowired
	private ICartService cartService;

	/**
	 * 自動注入OrderService
	 */
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 會員登出
	 */
	@RequestMapping("Logout")
	public String logout(HttpSession session) {
		session.removeAttribute("validUser");
		return View.HOME;
	}
	
	/**
	 * 修改密碼頁面
	 */
	@RequestMapping("ChangePassword/Form")
	public String changePasswordForm(Model model) {
		model.addAttribute("changePasswordForm", new ChangePasswordForm());
		return View.USER_CHANGE_PASSWORD_FROM;
	}
	
	/**
	 * 修改密碼
	 */
	@RequestMapping("ChangePassword/Save")
	public String changePasswordSava(ChangePasswordForm form, HttpSession session, Model model) {
		if(form.validateFail()) {
			model.addAttribute("errorMessage", form.getErrorMessage());
			return View.USER_CHANGE_PASSWORD_FROM;
		}
		try {
			User user = userService.changePassword(
					((User) session.getAttribute("validUser")).getId(), form);
			session.setAttribute("validUser", user);
		} catch(DataCheckException e) {
			model.addAttribute("errorMessage", Arrays.asList(e.getMessage()));
			return View.USER_CHANGE_PASSWORD_FROM;
		}
		return View.USER_CHANGE_PASSWORD_SUCCESS;
	}
	
	/**
	 * 購物車列表
	 */
	@RequestMapping("Cart/List")
	public String cartList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("validUser");
		model.addAttribute("productList", cartService.getCartList(user.getId()));
		return View.USER_CART;
	}
	
	/**
	 * 購物車加入商品
	 */
	@RequestMapping("Cart/Add/{productId}")
	public String cartAdd(HttpSession session, @PathVariable("productId") int productId, Model model) {
		User user = (User) session.getAttribute("validUser");
		int userId = user.getId();
		cartService.addProduct(userId, productId);
		model.addAttribute("productList", cartService.getCartList(userId));
		return View.USER_CART;
	}
	
	/**
	 * 購物車移除商品
	 */
	@RequestMapping("Cart/Delete/{productId}")
	public String cartDelete(HttpSession session, @PathVariable("productId") int productId, Model model) {
		User user = (User) session.getAttribute("validUser");
		int userId = user.getId();
		cartService.deleteProduct(userId, productId);
		model.addAttribute("productList", cartService.getCartList(userId));
		return View.USER_CART;
	}
	
	/**
	 * 購買商品
	 */
	@RequestMapping("Buy")
	public String buy(HttpSession session, int[] productIdArray, Model model) {
		User user = (User) session.getAttribute("validUser");
		model.addAttribute("order", orderService.createOrder(user.getId(), productIdArray));
		return View.ORDER_CREATE;
	}

}
