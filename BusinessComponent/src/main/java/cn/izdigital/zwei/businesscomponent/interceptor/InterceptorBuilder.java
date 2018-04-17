package cn.izdigital.zwei.businesscomponent.interceptor;

import java.util.HashMap;
import java.util.Map;

import cn.izdigital.zwei.businesscomponent.utils.SpringBeanUtil;

public enum InterceptorBuilder {

	INSTANCE;
	
	private Map<Class<CustomInterceptor>, CustomInterceptor> interceptors;
	
	@SuppressWarnings("unchecked")
	InterceptorBuilder(){
		Map<String, CustomInterceptor> allCustomInterceptors = SpringBeanUtil.getBeansOfType(CustomInterceptor.class);
		interceptors = new HashMap<Class<CustomInterceptor>, CustomInterceptor>();
		for (CustomInterceptor item : allCustomInterceptors.values()) {
			interceptors.put((Class<CustomInterceptor>)item.getClass(), item);
		}
	}

	public Map<Class<CustomInterceptor>, CustomInterceptor> getInterceptors() {
		return interceptors;
	}
	
}
