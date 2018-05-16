package login3.dao;

import login3.model.UserInfo;

public class LoginDAO {
	public boolean loginChk(UserInfo userInfo) {
		//DB연결 후 넘어오는 사용자 정보를 가지고 로그인 체크
		//본 예제는 id가 test이면 로그인 성공
		//UserInfo의 name에 "홍길동"으로 세팅 후 true를 리턴
		if("test".equals(userInfo.getId())) {
			userInfo.setName("홍길동");
			return true;
		} else {
			return false;
		}
	}
}
