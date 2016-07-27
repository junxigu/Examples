package guerer.example.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class PromoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private InputStream inputStream;

	private String fileName;

	private long contentLength;

	private String report;

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public long getContentLength() {
		return contentLength;
	}

	public String getFileName() {
		return fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String download() throws Exception {
		String file = ServletActionContext.getServletContext().getRealPath("/");
		// Can not get the context path since run as a war file, so get the war
		// path by getResource
		if (file == null) {
			// Get the current class path
			file = this.getClass().getResource("").getPath();
			// Get the war file path
			file = file.substring(file.indexOf("file:") == 0 ? 5 : 0,
					file.indexOf("WEB-INF") - 1);
			file = file.substring(0, file.lastIndexOf("/"));
		}
		file += "/" + report + ".xls";

		File fileToDownload = new File(file);

		inputStream = new FileInputStream(fileToDownload);
		fileName = fileToDownload.getName();
		contentLength = fileToDownload.length();

		return SUCCESS;
	}

}