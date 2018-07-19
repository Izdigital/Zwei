package cn.izdigital.zwei.web.viewmodel;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户登陆视图模型
 * @author gz
 *
 */
public class LoginEdidModel {

	/**
	 * 用户名
	 */
	@NotEmpty(message = "用户名不能为空")
	@Size(min = 5, max = 15, message = "用户名格式不正确")
	@Pattern(regexp = "[a-zA-Z0-9_-]{5,15}", message = "用户名格式不正确")
	private String userName;
	
	/**
	 * 密码
	 */
	@NotEmpty(message = "密码不能为空")
	private String password;

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
	
}
