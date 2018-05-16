package login.action;

import login.dao.UserDAO;
import login.model.UserInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserAction3 implements Action,Preparable, ModelDriven {

	UserInfo userInfo;
	Log log = LogFactory.getLog(UserAction.class);
	public String execute() throws Exception{
		log.info(">>>>>execute");
		
		//UserInfo ��ü ����
		//UserInfo userInfo = new UserInfo();
		
		log.info(">>>>>userInfo Object Create...");
		
		//��������� �Է����� DAO ȣ��
		UserDAO loginDao = new UserDAO();
		
		if(loginDao.save(userInfo)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	//UserInfo�� ���� getter, setter
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	//Preparable Interface�� prepare() ����
	public void prepare() throws Exception{
		userInfo = new UserInfo();
	}
	
	//ModelDriven�� getModel() ����
	public Object getModel() {
		return userInfo;
	}
}