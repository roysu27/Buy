package com.roy.buy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;

/**
 * 會員註冊Controller
 */
@Controller
@RequestMapping("/Register")
public class RegisterController {
	
	/**
	 * 註冊表單
	 */
	@RequestMapping(value = "Form")
	public String form() {
		return View.REGISTER_FORM;
	}

}
