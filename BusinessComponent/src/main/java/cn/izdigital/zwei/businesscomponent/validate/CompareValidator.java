/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.validate;

import java.lang.reflect.Field;

/**
 * @author gz
 *
 */
public class CompareValidator implements CustomConstraintValidator<Compare> {

	private String verifyField;
	private String message;
	
	/* (non-Javadoc)
	 * @see cn.izdigital.zwei.businesscomponent.validate.CustomConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(Compare constraintAnnotation) {
		// TODO Auto-generated method stub
		verifyField = constraintAnnotation.verifyField();
		message = constraintAnnotation.message();
	}

	/* (non-Javadoc)
	 * @see cn.izdigital.zwei.businesscomponent.validate.CustomConstraintValidator#isValid(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean isValid(Object value, Object model) {
		// TODO Auto-generated method stub
		try {
			Field field = model.getClass().getDeclaredField(verifyField);
			field.setAccessible(true);
			Object verifyFieldValue = field.get(model);
			if(value.equals(verifyFieldValue)) {
				return true;
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

	/* (non-Javadoc)
	 * @see cn.izdigital.zwei.businesscomponent.validate.CustomConstraintValidator#getErrorMessage(java.lang.annotation.Annotation)
	 */
	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
