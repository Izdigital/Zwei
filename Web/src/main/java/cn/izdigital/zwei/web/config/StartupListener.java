/**
 * 
 */
package cn.izdigital.zwei.web.config;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import cn.izdigital.zwei.businesscomponent.interceptor.InterceptorBuilder;
import cn.izdigital.zwei.businesscomponent.utils.SpringBeanUtil;

/**
 * @author gz
 *
 */
@Component
public class StartupListener implements ApplicationContextAware,ServletContextAware,InitializingBean {

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		Map<RequestMappingInfo, HandlerMethod> map =  handlerMapping.getHandlerMethods();
		//Map<String, HandlerMethod> urlMap = new HashMap<>();
        for (RequestMappingInfo info : map.keySet()) {
			System.out.println(info.getPatternsCondition().getPatterns());
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		// TODO Auto-generated method stub
		SpringBeanUtil.setApplicationContext(ctx);
		InterceptorBuilder.INSTANCE.init();
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.ServletContextAware#setServletContext(javax.servlet.ServletContext)
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub

	}

}
