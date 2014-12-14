package com.roy.buy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;
import com.roy.buy.form.RegisterForm;

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
	public String form(Model model) {
		model.addAttribute("registerForm", new RegisterForm());
		return View.REGISTER_FORM;
	}
	
	/**
	 * 會員註冊
	 */
	@RequestMapping(value = "Save")
	public String save(Model model, RegisterForm form) {
		if(form.validateFail()) {
			model.addAttribute("errorMessage", form.getErrorMessage());
			model.addAttribute("registerForm", form);
			return View.REGISTER_FORM;
		}
		return View.REGISTER_SUCCESS;
	}

}
