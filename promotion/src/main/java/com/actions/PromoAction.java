package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.data.DBUtils;
import com.data.PromoRwrdMapper;
import com.data.UserSelectedPromosMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PromoService;

public class PromoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int enrolledCustCnt;

	private int enrollingCustCnt;

	private int custOver3PointCnt;

	private int awardedCustCnt;

	private int viewedAwardCustCnt;

	private int enrollingCustLess3PointCnt;

	private InputStream inputStream;

	private String fileName;

	private long contentLength;
	
	private String report;

	private String periodStart;
	
	private int periodAwardCustCount;
	
	public int getPeriodAwardCustCount() {
		return periodAwardCustCount;
	}

	public void setPeriodAwardCustCount(int periodAwardCustCount) {
		this.periodAwardCustCount = periodAwardCustCount;
	}

	public String getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(String periodStart) {
		this.periodStart = periodStart;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public int getEnrollingCustLess3PointCnt() {
		return enrollingCustLess3PointCnt;
	}

	public void setEnrollingCustLess3PointCnt(int enrollingCustLess3PointCnt) {
		this.enrollingCustLess3PointCnt = enrollingCustLess3PointCnt;
	}

	public int getViewedAwardCustCnt() {
		return viewedAwardCustCnt;
	}

	public void setViewedAwardCustCnt(int viewedAwardCustCnt) {
		this.viewedAwardCustCnt = viewedAwardCustCnt;
	}

	public int getAwardedCustCnt() {
		return awardedCustCnt;
	}

	public void setAwardedCustCnt(int awardedCustCnt) {
		this.awardedCustCnt = awardedCustCnt;
	}

	public int getCustOver3PointCnt() {
		return custOver3PointCnt;
	}

	public void setCustOver3PointCnt(int custOver3PointCnt) {
		this.custOver3PointCnt = custOver3PointCnt;
	}

	public int getEnrollingCustCnt() {
		return enrollingCustCnt;
	}

	public void setEnrollingCustCnt(int enrollingCustCnt) {
		this.enrollingCustCnt = enrollingCustCnt;
	}

	public int getEnrolledCustCnt() {
		return enrolledCustCnt;
	}

	public void setEnrolledCustCnt(int enrolledCustCnt) {
		this.enrolledCustCnt = enrolledCustCnt;
	}

	public String download() throws IOException {
		String file = ServletActionContext.getServletContext().getRealPath(
				"/") + "/" + report + ".xls";
		new PromoService().exportExcel(file);
		
		File fileToDownload = new File(file);

		inputStream = new FileInputStream(fileToDownload);
		fileName = fileToDownload.getName();
		contentLength = fileToDownload.length();

		return SUCCESS;
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

	
	public String excute() throws Exception {
		SqlSession session = DBUtils.getSqlSessionFactory().openSession();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		if(periodStart == null){
			periodStart = dateFormat.format(new Date());
		}
		
		try {
			UserSelectedPromosMapper userSelectedPromosMapper = (UserSelectedPromosMapper) session
					.getMapper(UserSelectedPromosMapper.class);

			enrolledCustCnt = userSelectedPromosMapper.countEnrolledCust();

			enrollingCustCnt = userSelectedPromosMapper
					.countEnrollingCust();

			custOver3PointCnt = userSelectedPromosMapper.countCustOver3Point();

			enrollingCustLess3PointCnt = userSelectedPromosMapper
					.countEnrollingCustLess3Point();
			
			PromoRwrdMapper promoRwrdMapper = (PromoRwrdMapper) session
					.getMapper(PromoRwrdMapper.class);

			awardedCustCnt = promoRwrdMapper.countAwardedCust();

			viewedAwardCustCnt = promoRwrdMapper.countViewedAwardCust();

			int dayMil = 24*3600*1000;
			Date start =  dateFormat.parse(periodStart);
			periodAwardCustCount = promoRwrdMapper
					.countPeriodAwardCust(new Date(start.getTime() - dayMil), new Date(start.getTime() + dayMil));
		} finally {
			session.close();
		}

		return SUCCESS;
	}

}