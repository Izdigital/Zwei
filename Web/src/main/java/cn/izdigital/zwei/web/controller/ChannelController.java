/**
 * 
 */
package cn.izdigital.zwei.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.izdigital.zwei.businesscomponent.ZweiController;
import cn.izdigital.zwei.businesscomponent.interceptor.BeforeExecute;
import cn.izdigital.zwei.web.filter.LoginFilter;

/**
 * @author gz
 *
 */
@Controller
public class ChannelController extends ZweiController {
	
	@BeforeExecute(LoginFilter.class)
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String Index() {
        return "index";
	}
	
}
