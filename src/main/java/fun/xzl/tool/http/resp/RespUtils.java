package fun.xzl.tool.http.resp;

public class RespUtils {

	private RespUtils() {
	}

	public static final RespForm SUCC() {
		RespForm resp = new RespForm();
		resp.setStatus(RespStatus.OK.getCode());
		return resp;
	}

	public static final RespForm SUCC(String message) {
		RespForm resp = RespUtils.SUCC();
		resp.setMessage(message);
		return resp;
	}

	public static final RespForm SUCC(String message, Object result) {
		RespForm resp = RespUtils.SUCC(message);
		resp.setData(result);
		return resp;
	}

	public static final RespForm FAIL(RespStatus status) {
		RespForm resp = new RespForm();
		resp.setStatus(status.getCode());
		resp.setMessage(status.getDesc());
		return resp;
	}

	public static final RespForm FAIL(RespStatus status, String message) {
		RespForm resp = RespUtils.FAIL(status);
		resp.setMessage(message);
		return resp;
	}

}
