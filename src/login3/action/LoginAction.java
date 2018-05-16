package login3.action;

import login3.dao.LoginDAO;
import login3.interceptor.LoginDAOAware;
import login3.model.UserInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction implements Action, Preparable, ModelDriven, LoginDAOAware{

	//도메인 오브젝트
	UserInfo userInfo;
	LoginDAO dao;
	
	public String execute() throws Exception{
		//LoginDAO dao = new LoginDAO();
		if(dao.loginChk(userInfo)) {
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}
	
	//Preparable 인터페이스의 prepare 구현
	public void prepare() throws Exception {
		userInfo = new UserInfo();
	}
	
	//ModelDriven 인터페이스의 getModel 구현
	public Object getModel() {
		return userInfo;
	}
	//LoginDAUInterceptor에서 LoginDAO를 주입한다.
	public void setLoginDAO(LoginDAO loginDAO) {
		this.dao = loginDAO;
	}
}
