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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.izdigital.zwei.businesscomponent.SystemMessage;
import cn.izdigital.zwei.businesscomponent.captcha.CaptchaUtil;
import cn.izdigital.zwei.businesscomponent.interceptor.BeforeExecute;
import cn.izdigital.zwei.meta.User;
import cn.izdigital.zwei.service.UserService;
import cn.izdigital.zwei.utils.user.UserLoginStatus;
import cn.izdigital.zwei.web.filter.CaptchaFilter;
import cn.izdigital.zwei.web.viewmodel.LoginEdidModel;
import cn.izdigital.zwei.web.viewmodel.RegisterEditModel;

/**
 * @author gz 用户账户Controller
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	private UserService userService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
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
	
	@BeforeExecute(CaptchaFilter.class)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@Valid @ModelAttribute("loginModel") LoginEdidModel loginModel, Errors errors) {
		if (errors.hasErrors()) {
			return new SystemMessage(false, errors.getAllErrors().get(0).getDefaultMessage());
		}
		User user = userService.getByUserName(loginModel.getUserName());
		UserLoginStatus userLoginStatus = userService.validateUser(loginModel.getUserName(), loginModel.getPassword());
		if(userLoginStatus == UserLoginStatus.InvalidCredentials) {
			User emailUser = userService.GetByEmail(loginModel.getUserName());
			User mobileUser = userService.GetByMobile(loginModel.getUserName());
			if(emailUser != null) {
				user = emailUser;
				userLoginStatus = userService.validateUser(emailUser.getUserName(), loginModel.getPassword());
			}
			if(mobileUser != null) {
				user = mobileUser;
				userLoginStatus = userService.validateUser(mobileUser.getUserName(), loginModel.getPassword());
			}
		}
		if(userLoginStatus == UserLoginStatus.InvalidCredentials) {
			return new SystemMessage(false, "账号密码不匹配");
		}
		if(userLoginStatus == UserLoginStatus.Banned) {
			return new SystemMessage(false, "账号被封禁，无法登陆");
		}
		if(userLoginStatus == UserLoginStatus.Success) {
			request.getSession().setAttribute("currentUser", user);
		}
		return new SystemMessage();
	}

	/**
	 * 生产验证码图片
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/captchaGenerate")
	public void captchaGenerate() throws IOException {
		response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        CaptchaUtil captchaUtil = new CaptchaUtil();
        String captchaCode = captchaUtil.createCaptchaCode();
        final BufferedImage image = captchaUtil.createImage(captchaCode);
        request.getSession().setAttribute(CaptchaUtil.SESSION_KEY_OF_CAPTCHA_CODE, captchaCode);
        ImageIO.write(image, "JPEG", response.getOutputStream());  
	}

}
