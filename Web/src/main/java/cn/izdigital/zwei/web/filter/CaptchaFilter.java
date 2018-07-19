package cn.izdigital.zwei.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import cn.izdigital.zwei.businesscomponent.SystemMessage;
import cn.izdigital.zwei.businesscomponent.captcha.CaptchaUtil;
import cn.izdigital.zwei.businesscomponent.interceptor.CustomInterceptor;

/**
 * 验证码验证
 * @author gz
 *
 */
@Component
public class CaptchaFilter implements CustomInterceptor {

	@Override
	public boolean invoke(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String captcha = request.getParameter("captcha");
		String sessionCaptcha = (String)request.getSession().getAttribute(CaptchaUtil.SESSION_KEY_OF_CAPTCHA_CODE);
		if(!captcha.isEmpty() && !sessionCaptcha.isEmpty() && captcha.toUpperCase().equals(sessionCaptcha.toUpperCase())) {
			return true;
		}
		String json = JSONObject.toJSONString(new SystemMessage(false, "验证码不正确"));
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
