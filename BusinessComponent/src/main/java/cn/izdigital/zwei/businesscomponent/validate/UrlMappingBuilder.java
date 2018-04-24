package cn.izdigital.zwei.businesscomponent.validate;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import cn.izdigital.zwei.businesscomponent.ZweiController;
import cn.izdigital.zwei.businesscomponent.utils.SpringBeanUtil;

/**
 * url与controller中方法的映射
 * @author gz
 *
 */
public enum UrlMappingBuilder {

	INSTANCE;
	
	private Map<String, Method> urlMappings;
	private Map<String, ZweiController> controllers;
	
	private UrlMappingBuilder() {
		urlMappings = new HashMap<>();
		controllers = SpringBeanUtil.getBeansOfType(ZweiController.class);
		for (ZweiController controller : controllers.values()) {
			String rootUrl = "";
			RequestMapping controllerRequestMapping = controller.getClass().getDeclaredAnnotation(RequestMapping.class);
			if(controllerRequestMapping != null) {
				rootUrl = controllerRequestMapping.value()[0];
			}
			Method[] methods = controller.getClass().getDeclaredMethods();
			for (Method method : methods) {
				RequestMapping methodRequestMapping = method.getDeclaredAnnotation(RequestMapping.class);
				if(methodRequestMapping != null) {
					for (String url : methodRequestMapping.value()) {
						urlMappings.put(rootUrl + url,  method);
					}
				}
			}
		}
	}
	
}
