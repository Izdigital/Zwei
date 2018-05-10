package cn.izdigital.zwei.businesscomponent;

/**
 * Controller基础类
 * @author gz
 *
 */
public class ZweiController {

	/**
	 * controller名
	 */
	private String controllerName;
	
	/**
	 * 构造函数
	 */
	public ZweiController() {
		this.controllerName = this.getClass().getSimpleName().replaceAll("Controller", "");
	}
	
	/**
	 * 生成返回视图路径
	 * @param viewName
	 * @return
	 */
	public String View(String viewName) {
		return controllerName + "/" + viewName;
	}
	
}
