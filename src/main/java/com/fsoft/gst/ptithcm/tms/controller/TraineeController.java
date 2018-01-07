package com.fsoft.gst.ptithcm.tms.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fsoft.gst.ptithcm.tms.commonUltil.LogUltil;
import com.fsoft.gst.ptithcm.tms.model.Profile;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.Role;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.RoleRepository;
import com.fsoft.gst.ptithcm.tms.service.ProfileService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;

@Controller
@RequestMapping(value = { "/trainee" })
public class TraineeController {

	@Autowired
	private UsersService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ProfileService profileService;

	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value = { "/list-traine","" }, method = RequestMethod.GET)
	public String listTrainer(ModelMap model) {
		List<Users> listUser = userService.findAllUsers("TRAINEE");
		model.addAttribute("listUser", listUser);
		return "staff-trainee";
	}
	
	@RequestMapping(value = { "/uploadExcelFile" }, method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(Model model, @RequestParam("file") MultipartFile file) throws IOException {
		Integer count = 0;
		try{
		List<Profile> profiles = profileService.findAllProfile();
		Role role = roleRepository.getByKey("TRAINEE");
		System.out.println(profiles.size());
		List<Users> Trainees = new ArrayList<>();
		InputStream in = file.getInputStream();
		System.out.println(file.getOriginalFilename());
		String excelFilePath = file.getOriginalFilename();
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(in);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(in);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println(numberOfSheets);
		Sheet aSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = aSheet.iterator();
		while (iterator.hasNext()) {
			count++;
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			if (count > 4) {
				Users aUser = new Users();
				HashSet<ProfileUser> profileUsers = new HashSet<>();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();					
						if (columnIndex != 0 ) {
								if(columnIndex != 1){
							ProfileUser profileUser = new ProfileUser();
							switch (columnIndex) {
							case 2: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("LastName".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 3: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("FirstName".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 4: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("Birthday".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 5: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("Location".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 6: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("Address".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 7: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("Phone".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 8: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("Email".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 9: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("Education".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 10: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("ProgrammingLanguage".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 11: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("TOIEC".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 12: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("Experience".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							case 13: {
								String temp = getCellValue(nextCell).toString();
								
								int num = 0;
								for (int i = 0; i < profiles.size(); i++) {
									if ("Department".equals(profiles.get(i).getName())) {
										num = i;
										break;
									}
								}
								Profile profile = profiles.get(num);
								profileUser.setProfile(profile);
								profileUser.setValue(temp);
								break;
							}
							}
							profileUser.setUsers(aUser);
							profileUsers.add(profileUser);
						} else {
							if (getCellValue(nextCell) != " ") {
								String temp = getCellValue(nextCell).toString();
								
								aUser.setUsername(temp);
								aUser.setPassword(passwordEncoder.encode(temp));
							} 
							}
						}
					}
				if(aUser.getPassword()!=null)
				{
				aUser.setProfileUsers(profileUsers);
				Trainees.add(aUser);
				}
			}
		}
		workbook.close();
		if (count > 1) {

			for (Users users : Trainees) {
				users.setLog(LogUltil.newLog());
				users.setRole(role);
			}
			System.out.println(Trainees.size());
			boolean check = false;
			for (Users users : Trainees) {
				Users temp = userService.findByUsername(users.getUsername());
				if(temp!=null)
				{
					model.addAttribute("errorimportexcel", "Username :" +temp.getUsername()+" is existed");
					check = true;
					break;
				}
			}
			if(!check)
			{
			userService.saveListUser(Trainees);
			}
		} else {
			if (count == 0) {

				model.addAttribute("errorimportexcel", " excel is empty");

			}
			if (count == 4) {
				model.addAttribute("errorimportexcel", " non trainee");

			}
		}
		in.close();
		
		return "/trainee";
		}
		catch(IOException e)
		{
			model.addAttribute("errorimportexcel", "imported excel fail try again later");
			return "/trainee"; 
		}
	}

	@SuppressWarnings("deprecation")
	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		case Cell.CELL_TYPE_BLANK:
			return " ";
		}

		return null;
	}

	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}

}
