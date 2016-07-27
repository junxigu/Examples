package guerer.example.action;

import guerer.example.domain.UploadResult;
import guerer.example.service.UploadService;

import java.io.File;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// The uploaded file
	private File upload;

	private String uploadContentType;

	private String uploadFileName;

	private UploadService service;

	private UploadResult result;

	public UploadResult getResult() {
		return result;
	}

	public void setResult(UploadResult result) {
		this.result = result;
	}

	public void setService(UploadService service) {
		this.service = service;
	}
	
	// Db parameters
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return (this.uploadContentType);
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return (this.uploadFileName);
	}

	// Upload file
	public String upload() throws Exception {
		result = service.parseAndUploadExcel(getUpload());
		return SUCCESS;
	}

	public UploadAction() throws IOException, Exception {
		super();
		service = new UploadService();
	}

}