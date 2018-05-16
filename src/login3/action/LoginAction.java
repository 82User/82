package login3.action;

import login3.dao.LoginDAO;
import login3.interceptor.LoginDAOAware;
import login3.model.UserInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction implements Action, Preparable, ModelDriven, LoginDAOAware{

	//������ ������Ʈ
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
	
	//Preparable �������̽��� prepare ����
	public void prepare() throws Exception {
		userInfo = new UserInfo();
	}
	
	//ModelDriven �������̽��� getModel ����
	public Object getModel() {
		return userInfo;
	}
	//LoginDAUInterceptor���� LoginDAO�� �����Ѵ�.
	public void setLoginDAO(LoginDAO loginDAO) {
		this.dao = loginDAO;
	}
}
