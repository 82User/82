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
	//���� ������ ����� ���丮
	private final String UPLOAD_DIR = "C:\\Java\\upload";
	private Log log = LogFactory.getLog(FileUploadAction.class);
	// fileUpload ���ͼ��Ͱ� �����ϴ� �κ�
	// setter�� ����� ���� �Ѵ�.
	// fileUpload ���ͼ��Ͱ� �ӽõ��丮�� ������ ���� ��ü
	File doc;
	// Content Type
	String docContentType;
	//���� ���� �̸�
	String docFileName;
	//������ ������Ʈ
	UserInfo userInfo;
	//���� upload ���丮�� ������ ���� ��ü
	File savedFile;
	//FileUploadDAO ����
	FileUploadDAO fileUploadDAO;
	public String execute() throws Exception{
		//fileUploadDAO�� insert �޼ҵ� ȣ��
		if(fileUploadDAO.inserUserInfo(userInfo)) {
			log.info(">>>>>fileUploadDAO.insertUserInfo ��...");
			//fileUpload ���ͼ��Ͱ� �ӽõ��丮�� ������ ������ ���� UPLOAD
			//���丮�� ����
			//�ӽõ��丮�� ������ Action ���� �� fileUpload ���ͼ��Ͱ� �����Ѵ�.
			if(doc != null && doc.exists()) {
				log.info(">>>>> File Copy ��...");
				savedFile = new File(UPLOAD_DIR + docFileName);
				FileUtils.copyFile(doc, savedFile);
				log.info(">>>>> File Copy ��...");
			}
		}
		return SUCCESS;
	}
	//setter
	//�ӽõ��丮�� ������ ���� ��ü
	public void setDoc(File doc) {
		this.doc = doc;
	}
	
	// ContentType
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	
	//���� ���� �̸�
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	
	//FileUploadDAOInterceptor���� FileUploadDAO�� �����Ѵ�.
	//(DI, Dependency Injection)
	
	public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
		this.fileUploadDAO = fileUploadDAO;
	}
	
	//getter
	//model ��
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	//�ӽ����� ��ü
	public File getDoc() {
		return this.doc;
	}
	
	//���� UPLOAD ���丮�� ������ ���� ��ü
	public File getSavedFile() {
		return this.savedFile;
	}
	
	//Preparable �������̽��� prepare �޼ҵ� ����
	
	public void prepare() throws Exception{
		userInfo = new UserInfo();
	}
	
	//ModelDriven �������̽��� getModel �޼ҵ� ����
	public UserInfo getModel() {
		return userInfo;
	}
}
