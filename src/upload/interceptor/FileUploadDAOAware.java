package upload.interceptor;

import upload.dao.FileUploadDAO;

//�� �������̽��� ������ �׼��� FileUploadDAO���� ���԰���
public interface FileUploadDAOAware {

	public void setFileUploadDAO(FileUploadDAO fileUploadDAO);
}
