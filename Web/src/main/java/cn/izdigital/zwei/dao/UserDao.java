package cn.izdigital.zwei.dao;

import org.apache.ibatis.annotations.Select;

import cn.izdigital.zwei.meta.User;

/**
 * 用户数据访问
 * @author gz
 *
 */
public interface UserDao {

	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	@Select("select * from tn_users where UserName=#{userName}")
	public User getByUserName(String userName);
	
	/**
	 * 根据邮箱查询用户信息
	 * @param email
	 * @return
	 */
	@Select("select * from tn_users where AccountEmail=#{email}")
	public User getByEmail(String email);
	
	/**
	 * 根据手机查询用户信息
	 * @param mobile
	 * @return
	 */
	@Select("select * from tn_users where AccountMobile=#{mobile}")
	public User getByMobile(String mobile);
	
}
