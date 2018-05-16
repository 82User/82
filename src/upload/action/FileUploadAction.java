package upload.action;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import upload.dao.FileUploadDAO;
import upload.interceptor.FileUploadDAOAware;
import upload.model.UserInfo;

public class FileUploadAction extends ActionSupport 
				implements Preparable, ModelDriven<UserInfo>, FileUploadDAOAware {
	
	private static final long serialVersionUID = 1L;
	//실제 파일이 저장될 디렉토리
	private final String UPLOAD_DIR = "C:\\Java\\upload";
	private Log log = LogFactory.getLog(FileUploadAction.class);
	// fileUpload 인터셉터가 설정하는 부분
	// setter가 만들어 져야 한다.
	// fileUpload 인터셉터가 임시디렉토리에 저장한 파일 객체
	File doc;
	// Content Type
	String docContentType;
	//원본 파일 이름
	String docFileName;
	//도메인 오브젝트
	UserInfo userInfo;
	//실제 upload 디렉토리에 보관된 파일 객체
	File savedFile;
	//FileUploadDAO 참조
	FileUploadDAO fileUploadDAO;
	public String execute() throws Exception{
		//fileUploadDAO의 insert 메소드 호출
		if(fileUploadDAO.inserUserInfo(userInfo)) {
			log.info(">>>>>fileUploadDAO.insertUserInfo 후...");
			//fileUpload 인터셉터가 임시디렉토리에 저장한 파일을 실제 UPLOAD
			//디렉토리로 복사
			//임시디렉토리의 파일은 Action 종료 후 fileUpload 인터셉터가 삭제한다.
			if(doc != null && doc.exists()) {
				log.info(">>>>> File Copy 전...");
				savedFile = new File(UPLOAD_DIR + docFileName);
				FileUtils.copyFile(doc, savedFile);
				log.info(">>>>> File Copy 후...");
			}
		}
		return SUCCESS;
	}
	//setter
	//임시디렉토리에 저장한 파일 객체
	public void setDoc(File doc) {
		this.doc = doc;
	}
	
	// ContentType
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	
	//원본 파일 이름
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	
	//FileUploadDAOInterceptor에서 FileUploadDAO를 주입한다.
	//(DI, Dependency Injection)
	
	public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
		this.fileUploadDAO = fileUploadDAO;
	}
	
	//getter
	//model 빈
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	//임시파일 객체
	public File getDoc() {
		return this.doc;
	}
	
	//실제 UPLOAD 디렉토리에 보관된 파일 객체
	public File getSavedFile() {
		return this.savedFile;
	}
	
	//Preparable 인터페이스의 prepare 메소드 구현
	
	public void prepare() throws Exception{
		userInfo = new UserInfo();
	}
	
	//ModelDriven 인터페이스의 getModel 메소드 구현
	public UserInfo getModel() {
		return userInfo;
	}
}
