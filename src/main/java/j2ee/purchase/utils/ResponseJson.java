package j2ee.purchase.utils;

public class ResponseJson {
	private Boolean status;
	private String msg;
	private Object data;

	public ResponseJson(Boolean status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public ResponseJson() {
		this.status = false;
		this.msg = "Response Error !!!";
		this.data = "";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
