package upload.interceptor;

import upload.dao.FileUploadDAO;

//이 인터페이스를 구현한 액션은 FileUploadDAO빈을 주입가능
public interface FileUploadDAOAware {

	public void setFileUploadDAO(FileUploadDAO fileUploadDAO);
}
