/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author gz
 *
 */
public class CustomHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		BeforeExecute before = handlerMethod.getMethodAnnotation(BeforeExecute.class);
		if (before != null) {
			for (Class<?> c : before.value()) {
				CustomInterceptor interceptor = InterceptorBuilder.INSTANCE.getInterceptors().get(c);
				if (interceptor != null) {
					interceptor.invoke(request, response);
				}
			}
		}
		return true;
	}

}