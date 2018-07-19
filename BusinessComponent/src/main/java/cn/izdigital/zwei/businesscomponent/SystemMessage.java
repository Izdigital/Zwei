package cn.izdigital.zwei.businesscomponent;

/**
 * 系统消息类型，用于对返回给view的数据进行格式化封装
 * @author gz
 *
 */
public class SystemMessage {
	
	public SystemMessage() {
		this.flag = true;
		this.message = "";
		this.result = null;
	}
	
	public SystemMessage(boolean flag) {
		this.flag = flag;
		this.message = "";
		this.result = null;
	}
	
	public SystemMessage(boolean flag, String message) {
		this.flag = flag;
		this.message = message;
		this.result = null;
	}
	
	public SystemMessage(boolean flag, String message, Object result) {
		this.flag = flag;
		this.message = message;
		this.result = result;
	}

	/**
	 * 状态
	 */
	private boolean flag;
	
	/**
	 * 消息
	 */
	private String message;
	
	/**
	 * 结果
	 */
	private Object result;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
	
}
