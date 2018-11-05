package fun.xzl.tool.http.resp;

/**
 * HTTP 响应状态码
 * @Author jim
 */
public enum RespStatus {

	OK("200", "正确"),
	PARAM_MISSING("401", "缺少必选参数错误"),
	PARAM_INVALID("402", "非法参数"),
	//登录返回定义
	NO_LOGIN_ERROR("501", "用户未登录"),
	TOKEN_RESOLVE_ERROR("502", "登录信息解析失败"),
	TOKEN_EXPIRED("503", "登录过期"),
	AUTH_ERROR("504", "权限不够"),
	LOGIN_ERROR("505", "登录失败"),
	LOGIN_USERNAME_NOT_FOUND("515", "登录用户名不存在"),
	LOGIN_PLATFORM_NOT_SUPPORT("525", "登录用户平台不支持"),
	LOGIN_OPENID_NOT_FOUND("535", "该帐号未绑定平台帐户"),
	LOGIN_PWD_ERROR("545", "登录密码错误"),
	//业务处理异常
	SERVER_ERROR("506", "业务处理失败"),
	FEIGN_ERROR("508", "微服务调用失败"),
	STATION_NOT_FOUND("507", "站点不存在")

	;

	private RespStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private String code;
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
