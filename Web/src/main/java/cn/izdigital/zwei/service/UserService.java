package cn.izdigital.zwei.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.izdigital.zwei.dao.UserDao;
import cn.izdigital.zwei.meta.User;
import cn.izdigital.zwei.utils.user.UserLoginStatus;
import cn.izdigital.zwei.utils.user.UserPasswordFormat;
import cn.izdigital.zwei.utils.user.UserPasswordHelper;

/**
 * 用户账户业务逻辑
 * @author gz
 *
 */
@Repository
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName) {
		return userDao.getByUserName(userName);
	}
	
	/**
	 * 根据邮箱查询用户信息
	 * @param email
	 * @return
	 */
	public User GetByEmail(String email) {
		return userDao.getByEmail(email);
	}
	
	/**
	 * 根据手机查询用户信息
	 * @param mobile
	 * @return
	 */
	public User GetByMobile(String mobile) {
		return userDao.getByMobile(mobile);
	}

	/**
	 * 验证提供的用户名和密码是否匹配
	 * @param userName 用户名
	 * @param password 密码
	 * @return UserLoginStatus
	 */
	public UserLoginStatus validateUser(String userName, String password) {
		User user = getByUserName(userName);
		if(user == null) {
			return UserLoginStatus.InvalidCredentials;
		}
		if (!UserPasswordHelper.checkPassword(password, user.getPassword(), UserPasswordFormat.values()[user.getPasswordFormat()])) {
			return UserLoginStatus.InvalidCredentials;
		}
		if (user.isIsBanned()) {
			if (user.getBanDeadline().before(new Date())) {
                return UserLoginStatus.Banned;
			}
		}
		return UserLoginStatus.Success;
	}
	
}
