package com.roy.buy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.roy.buy.entity.User;
import com.roy.buy.service.ICartService;
import com.roy.buy.service.ICategoryService;

/**
 * 側邊欄攔截器
 * 商品側邊欄：檢查HttpSession裡有沒有存側邊欄, 如果沒有, 建立並存入
 * 購物車側邊欄：每次請求都會查詢一次
 */
public class SidebarInterceptor implements HandlerInterceptor {

	/**
	 * 自動注入CategoryService
	 */
	@Autowired
	private ICategoryService categoryService;

	/**
	 * 自動注入CartService
	 */
	@Autowired
	private ICartService cartService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 商品類別側邊欄
		HttpSession session = request.getSession();
		if(session.getAttribute("sidebar") == null) {
			session.setAttribute("sidebar", categoryService.getSidebar());
		}
		
		// 購物車側邊欄
		User user = (User) session.getAttribute("validUser");
		if(user != null) {
			request.setAttribute("cartList", cartService.getCartList(user.getId()));
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
