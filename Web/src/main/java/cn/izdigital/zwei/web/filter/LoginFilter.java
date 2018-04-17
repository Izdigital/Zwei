/**
 * 
 */
package cn.izdigital.zwei.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import cn.izdigital.zwei.businesscomponent.interceptor.CustomInterceptor;

/**
 * @author gz
 *
 */
@Component
public class LoginFilter implements CustomInterceptor {

	/* (non-Javadoc)
	 * @see cn.izdigital.zwei.businesscomponent.interceptor.CustomInterceptor#invoke(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public boolean invoke(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return true;
	}

}
