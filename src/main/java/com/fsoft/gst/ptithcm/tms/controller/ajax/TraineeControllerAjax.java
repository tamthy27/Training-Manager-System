package com.fsoft.gst.ptithcm.tms.controller.ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.gst.ptithcm.tms.commonUltil.LogUltil;
import com.fsoft.gst.ptithcm.tms.commonUltil.SessionUtil;
import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.CourseService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;
import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryControllerAjax.
 * 
 * @author TinhNV Jun 11, 2017
 */
@RestController
@RequestMapping("/trainee")
public class TraineeControllerAjax {

	/** The service. */
	@Autowired
	private UsersService service;

	/** The service. */
	@Autowired
	private CourseService courseService;


	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public String addTrainee(@RequestBody Users user) {

		// set Log
		user.setLog(LogUltil.newLog());

		// overwrite object to json type
		return null;
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String editTrainee(@RequestBody String str) {
		JSONObject jsonObject = new JSONObject(str);
		String id = jsonObject.getString("userId");
		String username = jsonObject.getString("username");
		String firstName = jsonObject.getString("firstname");
		String lastName =  jsonObject.getString("lastname");
		String birthday = jsonObject.getString("birthday");
		String phone = 	jsonObject.getString("phone");
		String edu = jsonObject.getString("education");
		String email =  jsonObject.getString("email");
		String programmingLanguage = jsonObject.getString("programminglanguage");
		String toiec = jsonObject.getString("toiec");
		String experience = jsonObject.getString("experience");
		String department = jsonObject.getString("department");
		Users users = service.findById(Integer.parseInt(id));
		if(users != null){
			users.setUsername(username);
			for (Iterator<ProfileUser> it = users.getProfileUsers().iterator(); it.hasNext(); ) {
		        ProfileUser f = it.next();
		        if ("FirstName".equals(f.getProfile().getName())) {
		        	f.setValue(firstName);
		        }
		        if ("LastName".equals(f.getProfile().getName())) {
		        	f.setValue(lastName);
		        }
		        if ("Birthday".equals(f.getProfile().getName())) {
		        	f.setValue(birthday);
		        }
		        if ("Phone".equals(f.getProfile().getName())) {
		        	f.setValue(phone);
		        }
		        if ("Education".equals(f.getProfile().getName())) {
		        	f.setValue(edu);
		        }
		        if ("ProgrammingLanguage".equals(f.getProfile().getName())) {
		        	f.setValue(programmingLanguage);
		        }
		        if ("TOIEC".equals(f.getProfile().getName())) {
		        	f.setValue(toiec);
		        }
		        if ("Experience".equals(f.getProfile().getName())) {
		        	f.setValue(experience);
		        }
		        if ("Department".equals(f.getProfile().getName())) {
		        	f.setValue(department);
		        }
		        if ("Email".equals(f.getProfile().getName())) {
		        	f.setValue(email);
		        }
		        
		       
		    }
		}
	
		users.getLog().setLastModifiedBy(SessionUtil.getUserSession());
		users.getLog().setLastModifiedDate(new Date());
		
		return service.update(users).toString();
		//return userUpdate.toString();
	}

	/**
	 * Delete.
	 *
	 * @param unique
	 *            the unique
	 * @return true, if successful
	 */
	@RequestMapping(value = { "/delete-{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String delete(@PathVariable String id) {
		Users user = service.delete(Integer.parseInt(id));
		return user.toString();
	}
	
	@RequestMapping(value = { "/list-course-new/{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getTopicNewByTrainerId(@PathVariable("id") String id) {	
	List<Course>lstCourse = courseService.getCourseByTraineeId(id);
	List<String> temp = new ArrayList<>();
	for (Course cat : lstCourse) {
		temp.add(cat.toString());
	}
	return new Gson().toJson(temp);
	}
	
	@RequestMapping(value = { "/list-course-completed/{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getTopicCompletedByTrainerId(@PathVariable("id") String id) {
	List<Course>	lstCourse = courseService.getCourseCompletedByTraineeId(id);
	List<String> temp = new ArrayList<>();
	for (Course cat : lstCourse) {
		temp.add(cat.toString());
	}
	return new Gson().toJson(temp);
	}	     
	
	@RequestMapping(value = { "/list-course-processing/{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getTopicProcessingByTrainerId(@PathVariable("id") String id) {
	List<Course>	lstCourse = courseService.getCourseProcessingByTraineeId(id);
	List<String> temp = new ArrayList<>();
	for (Course cat : lstCourse) {
		temp.add(cat.toString());
	}
	return new Gson().toJson(temp);
	}
}
