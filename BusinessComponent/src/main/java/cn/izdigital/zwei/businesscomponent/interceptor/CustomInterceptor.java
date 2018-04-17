/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gz
 *
 */
public interface CustomInterceptor {

	public boolean invoke(HttpServletRequest request, HttpServletResponse response);
	
}
