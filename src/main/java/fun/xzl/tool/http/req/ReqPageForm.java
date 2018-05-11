package fun.xzl.tool.http.req;

/**
 * @author 谢正龙
 * @date 2018年1月24日 下午1:03:16
 * @desc
 * @version V1.0
 * 
 */
public class ReqPageForm<T> extends ReqForm<T> {

	private int currPage = 0;
	private int pageSize = 10;

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



}
