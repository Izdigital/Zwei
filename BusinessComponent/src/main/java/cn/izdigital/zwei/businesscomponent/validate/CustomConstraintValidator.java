/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.validate;

import java.lang.annotation.Annotation;

/**
 * @author gz
 * 自定义验证实现接口(所有自定义验证类都需要实现该接口)
 */
public interface CustomConstraintValidator<A extends Annotation> {

	/**
	 * 初始化方法
	 * @param constraintAnnotation
	 */
	public void initialize(A constraintAnnotation);
	
	/**
	 * 验证方法
	 * @param value
	 * @param model
	 * @return
	 */
	public boolean isValid(Object value, Object model);
	
	/**
	 * 错误信息获取
	 * @param constraintAnnotation
	 * @return
	 */
	public String getErrorMessage();
	
}
