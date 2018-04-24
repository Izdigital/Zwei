/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.validate;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
/**
 * @author gz
 * 激活自定义验证工具
 */
public @interface CustomValidatorActivation {

	Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
    
    String message() default "数据不一致";
	
}
