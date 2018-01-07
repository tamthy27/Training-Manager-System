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
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.TopicService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;
import com.google.gson.Gson;

/**
 * The Class CategoryControllerAjax.
 * 
 * @author TINHNV Jun 11, 2017
 */
@RestController
@RequestMapping("/trainer")
public class TrainerControllerAjax {

	/** The service. */
	@Autowired
	private UsersService service;

	/** The service. */
	@Autowired
	private TopicService topicService;

	/**
	 * Adds the category.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 * 
	 *         controller use new create a category
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public String addTrainer(@RequestBody Users user) {
		user.setLog(LogUltil.newLog());
		
		return null;
	}

	/**
	 * Edits the.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 * 
	 *         controller user edit category
	 */
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String editTrainer(@RequestBody String str) {
		JSONObject jsonObject = new JSONObject(str);
		String username = jsonObject.getString("username");
		String firstName = jsonObject.getString("firstname");
		String lastName = jsonObject.getString("lastname");
		String birthday = jsonObject.getString("birthday");
		String phone = jsonObject.getString("phone");
		String edu = jsonObject.getString("education");
		String workingPlace = jsonObject.getString("workingplace");
		String email = jsonObject.getString("email");
		Users users = service.findByUsername(username);
		if (users != null) {
			for (Iterator<ProfileUser> it = users.getProfileUsers().iterator(); it.hasNext();) {
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
				if ("Workingplace".equals(f.getProfile().getName())) {
					f.setValue(workingPlace);
				}
				if ("Email".equals(f.getProfile().getName())) {
					f.setValue(email);
				}
			}
		}

		users.getLog().setLastModifiedBy(SessionUtil.getUserSession());
		users.getLog().setLastModifiedDate(new Date());
		return service.update(users).toString();
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @return true, if successful
	 */
	@RequestMapping(value = { "/delete-{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String deleteTrainer(@PathVariable String id) {
		Users user = service.delete(Integer.parseInt(id));
		return user.toString();
	}

	/**
	 * Gets the topic new by trainer id.
	 *
	 * @param id
	 *            the id
	 * @return the topic new by trainer id
	 */
	@RequestMapping(value = { "/list-topic-new/{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getTopicNewByTrainerId(@PathVariable("id") String id) {
		List<Topic> lstTopic = topicService.getTopicByTrainerId(id);
		List<String> temp = new ArrayList<>();
		for (Topic cat : lstTopic) {
			temp.add(cat.toString());
		}
		return new Gson().toJson(temp);
	}

	/**
	 * Gets the topic completed by trainer id.
	 *
	 * @param id
	 *            the id
	 * @return the topic completed by trainer id
	 */
	@RequestMapping(value = {
			"/list-topic-completed/{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getTopicCompletedByTrainerId(@PathVariable("id") String id) {

		List<Topic> lstTopic = topicService.getTopicCompletedByTrainerId(id);
		List<String> temp = new ArrayList<>();
		for (Topic cat : lstTopic) {
			temp.add(cat.toString());
		}
		return new Gson().toJson(temp);
	}
}
