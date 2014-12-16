package com.roy.buy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;

/**
 * 首頁Controller
 */
@Controller
public class HomeController {
	
	/**
	 * 首頁
	 */
	@RequestMapping(value = "/")
	public String home() {
		return View.HOME;
	}
	
}
