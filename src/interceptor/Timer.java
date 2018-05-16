package interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Timer extends AbstractInterceptor{
	
	private static Log log = LogFactory.getLog(Timer.class);
	public String intercept(ActionInvocation invocation) throws Exception{
		//Action 전 처리
		long start = System.currentTimeMillis();
		//Interceptor Stack의 다음 인터셉트, 인터셉트가 없다면 Action 실행
		String result = invocation.invoke();
		//Action 후 처리
		long execTime = System.currentTimeMillis() - start;
		log.info("Action 수행 시간 >>>>> " + execTime + " ms");
		return result;
	}

}
