/**
 * 
 */
package cn.izdigital.zwei.web.viewmodel;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import cn.izdigital.zwei.businesscomponent.validate.Compare;

/**
 * @author gz
 *
 */
public class RegisterEditModel {

	/**
	 * 账号名
	 */
	@NotEmpty(message = "不能为空")
	@Size(min = 6, max = 15, message = "请输入长度在{min}到{max}之间的字符串")
	private String userName;

	/**
	 * 密码
	 */
	@NotEmpty(message = "不能为空")
	@Length(min = 6, message = "最少输入{min}个字符")
	private String password;

	/**
	 * 确认密码
	 */
	@NotEmpty(message = "不能为空")
	@Length(min = 6, message = "最少输入{min}个字符")
	@Compare(verifyField = "password", message = "密码不一致")
	private String confirmPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
