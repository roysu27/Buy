package com.roy.buy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;

/**
 * 會員Controller
 */
@Controller
@RequestMapping("/User")
public class UserController {
	
	/**
	 * 會員登出
	 */
	@RequestMapping("Logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return View.HOME;
	}

}
