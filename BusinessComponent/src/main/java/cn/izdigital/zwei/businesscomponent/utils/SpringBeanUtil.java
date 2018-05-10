/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author gz
 *
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware  {

	private static ApplicationContext ctx = null;
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		// TODO Auto-generated method stub
		SpringBeanUtil.ctx = ctx;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String prop) {  
        Object obj = ctx.getBean(prop);  
        return (T)obj;  
    } 
	
	public static <T> T getBean(Class<T> c) {
		return ctx.getBean(c);
	}
	
	public static <T> Map<String, T> getBeansOfType(Class<T> c){
		System.out.println(ctx);
		return ctx.getBeansOfType(c);
	}

}
