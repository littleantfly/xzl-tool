package fun.xzl.tool.http.req;

import java.io.Serializable;

/**
 * @author 谢正龙
 * @date 2018年1月24日 上午11:46:01
 * @desc
 * @version V1.0
 * 
 */
public class BaseReqForm implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 请求时间戳
	 */
	private long timeStamp;

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
