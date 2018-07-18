/**
 * 
 */
package cn.izdigital.zwei.web.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.izdigital.zwei.businesscomponent.captcha.CaptchaUtil;
import cn.izdigital.zwei.web.viewmodel.RegisterEditModel;

/**
 * @author gz 用户账户Controller
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
		if (errors.hasErrors()) {
			return "register";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/validUserName", method = RequestMethod.POST)
	@ResponseBody
	public Object validUserName(String userName) {
		if (userName.equals("guanzhen")) {
			return false;
		}
		return true;
	}

	/**
	 * 生产验证码图片
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/captchaGenerate")
	public void captchaGenerate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        CaptchaUtil captchaUtil = new CaptchaUtil();
        final BufferedImage image = captchaUtil.createImage();
        ImageIO.write(image, "JPEG", response.getOutputStream());  
	}

}
