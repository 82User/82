package interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Timer extends AbstractInterceptor{
	
	private static Log log = LogFactory.getLog(Timer.class);
	public String intercept(ActionInvocation invocation) throws Exception{
		//Action �� ó��
		long start = System.currentTimeMillis();
		//Interceptor Stack�� ���� ���ͼ�Ʈ, ���ͼ�Ʈ�� ���ٸ� Action ����
		String result = invocation.invoke();
		//Action �� ó��
		long execTime = System.currentTimeMillis() - start;
		log.info("Action ���� �ð� >>>>> " + execTime + " ms");
		return result;
	}

}
