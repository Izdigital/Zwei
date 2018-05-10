/**
 * 
 */
package cn.izdigital.zwei.businesscomponent.validate;

import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author gz
 * freemarker验证脚本生成
 */
public class ValidDirective implements TemplateDirectiveModel {

	private ValidCreator validCreator;

	public ValidDirective(ValidCreator validCreator) {
		this.validCreator = validCreator;
	}

	/**
	 * 执行脚本生成
	 */
	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] model, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		// TODO Auto-generated method stub
		String className = params.get("className").toString();
		String formName = params.get("formName").toString();
		String validateScript = "";
		String rules = "";
		String messages = "";
		try {
			Class<?> c = Class.forName(className);
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {
				Map<String, String> result = GetValidationRule(field, c);
				if (result.containsKey("rule") && result.containsKey("message")) {
					String fieldRule = String.format("\n\t\t\t" + field.getName() + ": {%s\n\t\t\t},",
							result.get("rule"));
					String fieldMessage = String.format("\n\t\t\t" + field.getName() + ": {%s\n\t\t\t},",
							result.get("message"));
					rules += fieldRule;
					messages += fieldMessage;
				}
			}
			if (!rules.isEmpty() && !messages.isEmpty()) {
				validateScript = String.format(
						"<script>\n$().ready(function() {\n\t$(\"#%s\").validate({\n\t\trules: {%s\n\t\t},\n\t\tmessages: {%s\n\t\t}\n\t});\n});\n</script>",
						formName, rules.substring(0, rules.length() - 1), messages.substring(0, messages.length() - 1));
			}
			Writer writer = env.getOut();
			writer.write(validateScript);
			body.render(writer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取属性上annotation所对应的验证js脚本
	 */
	private Map<String, String> GetValidationRule(Field field, Class<?> c)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, String> result = new HashMap<String, String>();
		String rule = "";
		String message = "";
		Annotation[] annotations = field.getAnnotations();
		for (Annotation a : annotations) {
			Map<String, String> valid = validCreator.CreateValidation(a);
			if (valid != null) {
				rule += valid.get("rule");
				message += valid.get("message");
			}
		}
		if (!rule.isEmpty()) {
			result.put("rule", rule.substring(0, rule.length() - 1));
		}
		if (!message.isEmpty()) {
			result.put("message", message.substring(0, message.length() - 1));
		}
		return result;
	}
	
}
