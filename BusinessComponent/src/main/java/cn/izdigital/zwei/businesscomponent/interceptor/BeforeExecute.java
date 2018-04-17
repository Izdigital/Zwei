/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.interceptor;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
/**
 * @author gz
 *
 */
public @interface BeforeExecute {

	public Class<? extends CustomInterceptor>[] value();
	
}
