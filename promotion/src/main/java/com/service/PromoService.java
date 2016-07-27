package com.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.ibatis.session.SqlSession;

import com.data.DBUtils;
import com.data.PromoRwrdMapper;
import com.data.ReportMapper;
import com.data.UserSelectedPromosMapper;
import com.models.Report;

public class PromoService {

	public int getEnrolledCustCnt() throws IOException {
		int enrolledCustCnt = 0;
		SqlSession session = DBUtils.getSqlSessionFactory().openSession();
		try {
			UserSelectedPromosMapper userSelectedPromosMapper = session
					.getMapper(UserSelectedPromosMapper.class);

			enrolledCustCnt = userSelectedPromosMapper.countEnrolledCust();

		} finally {
			session.close();
		}
		return enrolledCustCnt;
	}

	public int getEnrollingCustCnt() throws IOException {
		int enrollingCustCnt = 0;
		SqlSession session = DBUtils.getSqlSessionFactory().openSession();

		try {
			UserSelectedPromosMapper userSelectedPromosMapper = session
					.getMapper(UserSelectedPromosMapper.class);

			enrollingCustCnt = userSelectedPromosMapper
					.countEnrollingCust();
		} finally {
			session.close();
		}
		return enrollingCustCnt;
	}

	public int getCustOver3PointCnt() throws IOException {
		int custOver3PointCnt = 0;
		SqlSession session = DBUtils.getSqlSessionFactory().openSession();

		try {
			UserSelectedPromosMapper userSelectedPromosMapper = session
					.getMapper(UserSelectedPromosMapper.class);

			custOver3PointCnt = userSelectedPromosMapper.countCustOver3Point();
		} finally {
			session.close();
		}
		return custOver3PointCnt;
	}

	public int getAwardedCustCnt() throws IOException {
		int awardedCustCnt = 0;
		SqlSession session = DBUtils.getSqlSessionFactory().openSession();

		try {
			PromoRwrdMapper promoRwrdMapper = session
					.getMapper(PromoRwrdMapper.class);

			awardedCustCnt = promoRwrdMapper.countAwardedCust();
		} finally {
			session.close();
		}
		return awardedCustCnt;
	}

	public int getViewedAwardCustCnt() throws IOException {
		int viewedAwardCustCnt = 0;
		SqlSession session = DBUtils.getSqlSessionFactory().openSession();

		try {
			PromoRwrdMapper promoRwrdMapper = session
					.getMapper(PromoRwrdMapper.class);

			viewedAwardCustCnt = promoRwrdMapper.countViewedAwardCust();
		} finally {
			session.close();
		}
		return viewedAwardCustCnt;
	}

	public int getEnrollingCustLess3PointCnt() throws IOException {
		int enrollingCustLess3PointCnt = 0;
		SqlSession session = DBUtils.getSqlSessionFactory().openSession();

		try {
			UserSelectedPromosMapper userSelectedPromosMapper = session
					.getMapper(UserSelectedPromosMapper.class);

			enrollingCustLess3PointCnt = userSelectedPromosMapper
					.countEnrollingCustLess3Point();
		} finally {
			session.close();
		}
		return enrollingCustLess3PointCnt;
	}

	
	public boolean exportExcel(String file) throws IOException {
		SqlSession session = DBUtils.getSqlSessionFactory().openSession();
		ArrayList<Report> list = null;
		boolean result = false;
		try {
			ReportMapper userDetailMapper = session
					.getMapper(ReportMapper.class);
			if(file.indexOf("enrolled_customers") > 0){
				list = userDetailMapper.getEnrolledCust();
			} else if(file.indexOf("enrolling_customers") > 0){
				list = userDetailMapper.getEnrollingCust();
			} else if(file.indexOf("eligible_customers") > 0){
				list = userDetailMapper.getEligibleCust();
			} else if(file.indexOf("redeemed_customers") > 0){
				list = userDetailMapper.getRedeemedCust();
			} else if(file.indexOf("ineligible_customers") > 0){
				list = userDetailMapper.getIneligibleCust();
			} else if(file.indexOf("today_awarded_customers") > 0){
				list = userDetailMapper.getTodayRedeemedCust();
			} else if(file.indexOf("awarded_customers") > 0){
				list = userDetailMapper.getAwardedCust();
			}
			result =  generateExcel(file, list);
		} finally {
			session.close();
		}
		return result;
	}
	
	public boolean generateExcel(String file, ArrayList<Report> list) {
		FileOutputStream os;
		String fileName = file.substring(file.lastIndexOf('/') + 1,
				file.lastIndexOf('.'));
		
		boolean needRwrdDt = list.size() > 0 && list.get(0).getRewardDate() != null;
		
		try {
			os = new FileOutputStream(file);

			// Create a excel file
			WritableWorkbook wbook = Workbook.createWorkbook(os);
			// Create a sheet name
			WritableSheet wsheet = wbook.createSheet(fileName, 0);

			// Set the font and color for titles
			WritableFont wfont = new jxl.write.WritableFont(WritableFont.ARIAL,
					14, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat wcfFC = new WritableCellFormat(wfont);
			wcfFC.setBackground(Colour.YELLOW);

			// Create the titles: label(col, len, title)
			wsheet.addCell(new Label(0, 0, "Email", wcfFC));
			wsheet.addCell(new Label(1, 0, "Start Date", wcfFC));
			wsheet.addCell(new Label(2, 0, "End Date", wcfFC));
			wsheet.addCell(new Label(3, 0, "Point", wcfFC));
			if(needRwrdDt){
				wsheet.addCell(new Label(4, 0, "Reward Date", wcfFC));
			}

			for (int i = 0; i < list.size(); i++) {
				wsheet.addCell(new Label(0, i + 1, list.get(i).getEmail()));
				wsheet.addCell(new Label(1, i + 1, "" + list.get(i).getStart()));
				wsheet.addCell(new Label(2, i + 1, "" + list.get(i).getEnd()));
				wsheet.addCell(new Label(3, i + 1, "" + list.get(i).getPoint()));
				if(needRwrdDt){
					wsheet.addCell(new Label(4, i + 1, "" + list.get(i).getRewardDate()));
				}
			}

			wbook.write();
			wbook.close();
			os.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
