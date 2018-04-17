/**
 * 
 */
package cn.izdigital.zwei.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.izdigital.zwei.businesscomponent.interceptor.CustomInterceptor;
import cn.izdigital.zwei.businesscomponent.utils.SpringBeanUtil;

/**
 * @author gz
 *
 */
@Controller
public class ChannelController {

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String Index() {
		System.out.println(SpringBeanUtil.getBeansOfType(CustomInterceptor.class));
		return "index";
	}
	
}
