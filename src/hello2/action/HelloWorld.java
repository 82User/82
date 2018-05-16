package hello2.action;

import com.opensymphony.xwork2.Action;

public class HelloWorld implements Action {

	private String name;
	private String msg;
	private String retMsg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	
	public String execute() throws Exception {
		//validation check
		if(name == null || "".equals(name)) {
			retMsg = "이름 좀 넣어 이넘아";
			return INPUT;
		}
		msg = "Hello, " + name;
		return SUCCESS;
	}
	
}
