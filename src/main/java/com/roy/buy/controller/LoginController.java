package com.roy.buy.controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;
import com.roy.buy.entity.User;
import com.roy.buy.exception.DataCheckException;
import com.roy.buy.form.LoginForm;
import com.roy.buy.service.IUserService;

/**
 * 登入Controller
 */
@Controller
public class LoginController {

	/**
	 * 自動注入UserService
	 */
	@Autowired
	private IUserService userService;

	/**
	 * 登入表單
	 */
	@RequestMapping(value = "/Login/Form")
	public String form(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return View.LOGIN_FORM;
	}

	/**
	 * 會員登入
	 */
	@RequestMapping("/Login")
	public String login(Model model, LoginForm form, HttpSession session) {
		if(form.validateFail()) {
			model.addAttribute("errorMessage", form.getErrorMessage());
			model.addAttribute("loginForm", form);
			return View.LOGIN_FORM;
		}
		try {
			User user = userService.login(form.getAccount(), form.getPassword());
			session.setAttribute("validUser", user);
		} catch(DataCheckException e) {
			model.addAttribute("errorMessage", Arrays.asList(e.getMessage()));
			model.addAttribute("loginForm", form);
			return View.LOGIN_FORM;
		}
		return View.LOGIN_SUCCESS;
	}

}
