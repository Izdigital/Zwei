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
 * 自定义远程数据验证
 */
public @interface Remote {

	String message() default "账号已注册";
	
	String validatrUrl() default "";
	
	String[] additionalField() default {};
	
	String method() default "POST";
	
}
