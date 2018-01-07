//package com.fsoft.gst.ptithcm.tms.commonUltil.view;
//
//import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.springframework.web.servlet.view.document.AbstractExcelView;
//import com.fsoft.gst.ptithcm.tms.model.Users;
//
//@SuppressWarnings("unchecked")
//public class UserListExcelReportView extends AbstractExcelView {
//
//	@Override
//	protected void buildExcelDocument(Map<String,Object> model, HSSFWorkbook workbook,
//		HttpServletRequest request, HttpServletResponse response)
//		throws Exception {
//	
//		
//		List<Users> userList = (List<Users>) model.get("userList");
//		
//		//create a wordsheet
//		HSSFSheet sheet = workbook.createSheet("User List");
//		
//		HSSFRow header = sheet.createRow(0);
//		header.createCell(0).setCellValue("USer ID");
//		header.createCell(1).setCellValue("Username");
//		header.createCell(2).setCellValue("Password");
////		header.createCell(3).setCellValue("Email N");
//		header.createCell(4).setCellValue("Role");
//		
//		int rowNum = 1;
//		for (Users	 user : userList) {
//			//create the row data
//			HSSFRow row = sheet.createRow(rowNum++);
//			row.createCell(0).setCellValue(user.getId());
//			row.createCell(1).setCellValue(user.getUsername());
//			row.createCell(2).setCellValue(user.getPassword());
//			row.createCell(3).setCellValue(user.getRole().getRoleName());
////			HSSFCell cell= row.createCell(4);
////			List<String> listUserType = new ArrayList<String>();
////			//Build user profile list
////			Hibernate.initialize(user);
////			Hibernate.initialize(user.getUserProfiles());
////			for (ProfileUser userProfile : user.getProfileUsers()) {
////				
////			}
////			//Join all user profile to a string with colon join character
////			String strUserProfileType = String.join(",", listUserType);
////			row.createCell(4).setCellValue(strUserProfileType);
//			
//		}
//	}
//	
//	
//	
//	
//}