/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.izdigital.zwei.businesscomponent.utils.SpringBeanUtil;

/**
 * @author gz
 *
 */
public class CustomHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	private Map<String, CustomInterceptor> interceptor;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(interceptor == null) {
			interceptor = SpringBeanUtil.getBeansOfType(CustomInterceptor.class);
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Before before = handlerMethod.getMethodAnnotation(Before.class);
		if (before != null) {
			for (Class<?> c : before.value()) {
				System.out.println(c.getName());
			}
		}
		return true;
	}

}
