/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.validate;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
/**
 * @author gz
 * 自定义验证实现类绑定
 */
public @interface CustomConstraint {

	Class<? extends CustomConstraintValidator<?>>[] validatedBy();
	
}
