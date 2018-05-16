package hello1.action;

public class HelloWorld {

	private String name;
	private String msg;
	
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
	
	public String execute() throws Exception{
		msg = "Hello, " + name;
		return "success";
	}
}
