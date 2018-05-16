package login2.action;

import login2.dao.LoginDAO;
import login2.model.UserInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction implements Action, Preparable, ModelDriven {
	//������ ������Ʈ
	UserInfo userInfo;
	public String execute() throws Exception{
		LoginDAO dao = new LoginDAO(); 
		if(dao.loginChk(userInfo)) {
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}
	
	//Preparable �������̽��� prepare ����
	public void prepare() throws Exception{
		userInfo = new UserInfo();
	}
	
	//ModelDriven �������̽��� getModel ����
	public Object getModel() {
		return userInfo;
	}

}
