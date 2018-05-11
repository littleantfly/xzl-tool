package fun.xzl.tool.http.req;

import fun.xzl.tool.bean.BeanUtils;
import fun.xzl.tool.map.MapUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 谢正龙
 * @date 2018年1月24日 下午1:03:16
 * @desc
 * @version V1.0
 * 
 */
public class ReqPageForm<T> extends BaseReqForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private int currPage = 0;
	private int pageSize = 10;

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
     * 将参数转化为Map
	 * @return
     */
	public Map<String, Object> getMapParam() {
		Map<String, Object> param = MapUtils.newHashMap();
		try {
			param = BeanUtils.toMap(this.data);
		} catch (Exception e) {
		}
		return param;
	}

}
