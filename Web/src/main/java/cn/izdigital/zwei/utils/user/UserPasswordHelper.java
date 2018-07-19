package cn.izdigital.zwei.utils.user;

import cn.izdigital.zwei.businesscomponent.utils.MD5;

/**
 * 密码验证
 * @author Administrator
 *
 */
public class UserPasswordHelper {
	
	/**
	 * 检查用户密码是否正确
	 * @param password 用户录入的用户密码（尚未加密的密码）
	 * @param storedPassword 数据库存储的密码（即加密过的密码）
	 * @param passwordFormat 用户密码加密格式
	 * @return
	 */
	public static boolean checkPassword(String password, String storedPassword, UserPasswordFormat passwordFormat) {
		String encodedPassword = encodePassword(password, passwordFormat);
		if(!encodedPassword.isEmpty()) {
			return encodedPassword.toUpperCase().equals(storedPassword.toUpperCase());
		}
		else {
			return false;
		}
	}

	/**
	 * 检查用户密码是否正确
	 * @param password 需要加密的用户密码
	 * @param passwordFormat 用户密码加密格式
	 * @return
	 */
	public static String encodePassword(String password, UserPasswordFormat passwordFormat) {
		if (passwordFormat == UserPasswordFormat.MD5) {
			return MD5.getMD5(password);
		}
		return password;
	}
	
}
