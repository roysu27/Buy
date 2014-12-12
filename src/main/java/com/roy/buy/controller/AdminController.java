package com.roy.buy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;

/**
 * 管理後台Controller
 */
@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	/**
	 * 管理後台首頁
	 */
	@RequestMapping(value = "Home")
	public String home() {
		return View.ADMIN_HOME;
	}

}
