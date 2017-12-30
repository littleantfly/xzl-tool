package fun.xzl.tool.time;

/**
 * 日期格式化类型
 * @author xzl
 *
 */
public enum TimeFormat {
	LONG_FULL("年-月-日 时:分:秒:毫秒", "yyyy-MM-dd HH:mm:ss:SSS"),
	LONG("年-月-日 时:分:秒", "yyyy-MM-dd HH:mm:ss"),
	LONG_MINUTE("年-月-日 时:分", "yyyy-MM-dd HH:mm"),
	LONG_HOUR("年-月-日 时:分", "yyyy-MM-dd HH"),
	LONG_DAY("年-月-日", "yyyy-MM-dd"),
	LONG_MONTH("年-月", "yyyy-MM"),
	LONG_YEAR("年", "yyyy"),
	SHORT("时:分:秒", "HH:mm:ss"),
	SHORT_MINUTE("时:分", "HH:mm"),
	SHORT_HOUR("时", "HH")
	;

	
	private TimeFormat(String name, String format) {
		this.name = name;
		this.format = format;
	}

	private String format;
	private String name;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
