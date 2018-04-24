/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.validate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
/**
 * @author gz
 * 自定义数据一致性验证
 */
public @interface Compare {

	/**
	 * 错误提示
	 * @return
	 */
	String message() default "数据不一致";
	
	/**
	 * 验证属性名称
	 * @return
	 */
	String verifyField() default "";
	
}
