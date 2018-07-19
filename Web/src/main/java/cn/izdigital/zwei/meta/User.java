package cn.izdigital.zwei.meta;

import java.util.Date;

/**
 * 用户实体模型
 * @author gz
 *
 */
public class User {

	/**
	 * 主键Id
	 */
	private long UserId;
	
	/**
	 * 用户名
	 */
	private String UserName;
	
	/**
	 * 密码
	 */
	private String Password;
	
	/**
	 * 密码强度
	 */
	private int PasswordStrength;
	
	/**
	 * 加密类型
	 */
	private int PasswordFormat;
	
	/**
	 * 绑定邮箱
	 */
	private String AccountEmail;
	
	/**
	 * 是否绑定邮箱
	 */
	private boolean IsEmailVerified;
	
	/**
	 * 绑定手机
	 */
	private String AccountMobile;
	
	/**
	 * 是否绑定手机
	 */
	private boolean IsMobileVerified;
	
	/**
	 * 昵称
	 */
	private String NickName;
	
	/**
	 * 创建时间
	 */
	private Date DateCreated;
	
	/**
	 * 创建IP
	 */
	private String IpCreated;
	
	/**
	 * 上次活动时间
	 */
	private Date LastActivityTime;
	
	/**
	 * 活动IP
	 */
	private String IpLastActivity;
	
	/**
	 * 是否封号
	 */
	private boolean IsBanned;
	
	/**
	 * 封号原因
	 */
	private String BanReason;
	
	/**
	 * 封号截至时间
	 */
	private Date BanDeadline;
	
	/**
	 * 头像
	 */
	private String Avatar;

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getPasswordStrength() {
		return PasswordStrength;
	}

	public void setPasswordStrength(int passwordStrength) {
		PasswordStrength = passwordStrength;
	}

	public int getPasswordFormat() {
		return PasswordFormat;
	}

	public void setPasswordFormat(int passwordFormat) {
		PasswordFormat = passwordFormat;
	}

	public String getAccountEmail() {
		return AccountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		AccountEmail = accountEmail;
	}

	public boolean isIsEmailVerified() {
		return IsEmailVerified;
	}

	public void setIsEmailVerified(boolean isEmailVerified) {
		IsEmailVerified = isEmailVerified;
	}

	public String getAccountMobile() {
		return AccountMobile;
	}

	public void setAccountMobile(String accountMobile) {
		AccountMobile = accountMobile;
	}

	public boolean isIsMobileVerified() {
		return IsMobileVerified;
	}

	public void setIsMobileVerified(boolean isMobileVerified) {
		IsMobileVerified = isMobileVerified;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public Date getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}

	public String getIpCreated() {
		return IpCreated;
	}

	public void setIpCreated(String ipCreated) {
		IpCreated = ipCreated;
	}

	public Date getLastActivityTime() {
		return LastActivityTime;
	}

	public void setLastActivityTime(Date lastActivityTime) {
		LastActivityTime = lastActivityTime;
	}

	public String getIpLastActivity() {
		return IpLastActivity;
	}

	public void setIpLastActivity(String ipLastActivity) {
		IpLastActivity = ipLastActivity;
	}

	public boolean isIsBanned() {
		return IsBanned;
	}

	public void setIsBanned(boolean isBanned) {
		IsBanned = isBanned;
	}

	public String getBanReason() {
		return BanReason;
	}

	public void setBanReason(String banReason) {
		BanReason = banReason;
	}

	public Date getBanDeadline() {
		return BanDeadline;
	}

	public void setBanDeadline(Date banDeadline) {
		BanDeadline = banDeadline;
	}

	public String getAvatar() {
		return Avatar;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	
}
