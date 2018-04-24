/**
 * 
 */
package cn.izdigital.zwei.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.izdigital.zwei.web.viewmodel.RegisterEditModel;

/**
 * @author gz
 * 用户账户Controller
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("registerModel") RegisterEditModel registerModel, Errors errors) {
		if(errors.hasErrors()) {
			return "register";
		}
		return "redirect:/";
	}
	
}
