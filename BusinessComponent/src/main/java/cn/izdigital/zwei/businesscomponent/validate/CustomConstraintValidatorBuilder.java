/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.validate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gz
 * 自定义验证方法构造器，单例模式构造所有继承CustomConstraintValidator接口的类实例
 */
public enum CustomConstraintValidatorBuilder {

INSTANCE;
	
	private Map<Class<CustomConstraintValidator<?>>, CustomConstraintValidator<?>> validators;
	
	CustomConstraintValidatorBuilder(){
		validators = new HashMap<Class<CustomConstraintValidator<?>>, CustomConstraintValidator<?>>();
	}
	
	public CustomConstraintValidator<?> GetValidator(Class<CustomConstraintValidator<?>> c){
		CustomConstraintValidator<?> result = validators.get(c);
		if(result == null) {
			try {
				result = c.newInstance();
				validators.put(c, result);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
