package interceptor1.action;

import interceptor1.dao.SumDAO;
import interceptor1.model.NumberForAdd;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SumAction implements Action, Preparable, ModelDriven{
	//도메인 오브젝트
	NumberForAdd num;
	private int sum = 0;
	public String execute() throws Exception{
		SumDAO dao = new SumDAO();
		sum = dao.add(num);
		return SUCCESS;
	}
	
	//Preparable 인터페이스의 prepare 구현
	public void prepare() throws Exception{
		num = new NumberForAdd();
	}
	
	//ModelDriven 인터페이스의 getModel 구현
	public Object getModel() {
		return num;
	}
	
	//result.jsp 에서 sum 값을 참조시키기 위해
	public int getSum() {
		return sum;
	}
	

}
