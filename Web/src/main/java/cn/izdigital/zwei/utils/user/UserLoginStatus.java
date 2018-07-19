package cn.izdigital.zwei.utils.user;

/**
 * 登陆验证状态
 * @author gz
 *
 */
public enum UserLoginStatus {

	/**
	 * 账号密码不正确
	 */
	InvalidCredentials,
	
	/**
	 * 账号被封禁
	 */
	Banned,
	
	/**
	 * 验证成功
	 */
	Success
	
}
