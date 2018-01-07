package com.fsoft.gst.ptithcm.tms.controller.ajax;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.gst.ptithcm.tms.commonUltil.Constants;
import com.fsoft.gst.ptithcm.tms.commonUltil.DateUtil;
import com.fsoft.gst.ptithcm.tms.commonUltil.DeleteConstants;
import com.fsoft.gst.ptithcm.tms.commonUltil.LogUltil;
import com.fsoft.gst.ptithcm.tms.commonUltil.view.MailService;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.TopicService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * The Class CategoryControllerAjax.
 * 
 * @author NVTT Jun 11, 2017
 */
@RestController
@RequestMapping("/topic")
public class TopicControllerAjax {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(TopicControllerAjax.class);
	/** The service. */
	@Autowired
	private TopicService topicService;

	/** The user service. */
	@Autowired
	private UsersService userService;

	/**
	 * List topic.
	 *
	 * @param courseId
	 *            the course id
	 * @param state
	 *            the state
	 * @return the string
	 */
	@RequestMapping(value = { "/list-topic/{courseId}/{state}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String listTopic(@PathVariable("courseId") String courseId, @PathVariable("state") String state) {
		List<Topic> listTopic = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		if ("new".equals(state)) {
			listTopic = topicService.findAllTopicNew(courseId);
		} else if ("completed".equals(state)) {
			listTopic = topicService.findAllTopicCompleted(courseId);
		}
		for (Topic topic : listTopic) {
			temp.add(topic.toString());
		}
		return new Gson().toJson(temp);
	}

	/**
	 * Adds the category.
	 *
	 * @param topic
	 *            the topic
	 * @param time
	 *            the time
	 * @return the string controller use new create a category
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addCategory(@RequestBody Topic topic, @RequestParam("time") String time) {
		// set Log
		topic.setLog(LogUltil.newLog());
		try {
			topic.setTime(DateUtil.string2Date(time, Constants.DATE_FORMAT));
		} catch (ParseException e) {
			LOGGER.error(e);
		}
		Topic entity = topicService.saveTopic(topic);
		return entity.toString();
	}

	/**
	 * Edits the.
	 *
	 * @param topic
	 *            the topic
	 * @param time
	 *            the time
	 * @return the string
	 * 
	 *         controller user edit category
	 */
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String edit(@RequestBody Topic topic, @RequestParam("time") String time) {
		try {
			topic.setTime(DateUtil.string2Date(time, Constants.DATE_FORMAT));
		} catch (ParseException e) {
			LOGGER.error(e);
		}
		Topic topicUpdated = topicService.update(topic);
		return topicUpdated.toString();
	}

	/**
	 * Delete.
	 * 
	 * @param topicId
	 *            the topic id
	 * @param type
	 *            the type
	 * @return true, if successful
	 */
	@RequestMapping(value = { "/delete/{id}/{type}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int delete(@PathVariable("id") String topicId, @PathVariable("type") String type) {
		Topic topic = null;
		if (DeleteConstants.DELETE_HARD.equals(type)) {
			topic = topicService.delete(topicId);
		} else if (DeleteConstants.DELETE_SORT.equals(type)) {
			topic = topicService.deleteLogic(topicId);
		}
		return topic == null ? 0 : 1;
	}

	/**
	 * Gets the trainer.
	 * 
	 * @param topicId
	 *            the topic id
	 * @return the trainer
	 */
	@RequestMapping(value = { "/trainer/{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getTrainer(@PathVariable("id") String topicId) {
		Users trainer = topicService.getTrainer(topicId);
		JsonObject jsonObject = new JsonObject();
		if (trainer != null) {
			jsonObject.addProperty("userID", trainer.getId());
			jsonObject.addProperty("username", trainer.getUsername());
			for (ProfileUser profile : trainer.getProfileUsers()) {
				jsonObject.addProperty(profile.getProfile().getName(), profile.getValue());
			}
		}
		return jsonObject.toString();
	}

	/**
	 * Gets the user role.
	 *
	 * @param time the time
	 * @return the user role
	 */
	@RequestMapping(value = { "/list-user" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getuserRole(@RequestParam("time") String time) {
		Date timeDate = null;
		try {
			timeDate = DateUtil.string2Date(time, Constants.DATE_FORMAT);
		} catch (ParseException e) {
			LOGGER.error(e);
		}
		List<Users> users = topicService.findAllTrainer(timeDate);
		List<String> temp = new ArrayList<>();
		for (Users users2 : users) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("username", users2.getUsername());
			Set<ProfileUser> profileUser = users2.getProfileUsers();
			for (ProfileUser pro : profileUser) {
				switch (pro.getProfile().getName()) {
				case "FirstName":
					jsonObject.addProperty("FirstName", pro.getValue());
					break;
				case "LastName":
					jsonObject.addProperty("LastName", pro.getValue());
					break;
				case "Email":
					jsonObject.addProperty("Email", pro.getValue());
					break;
				default:
					break;
				}
			}
			temp.add(jsonObject.toString());
		}
		return new Gson().toJson(temp);
	}

	/**
	 * Assign trainer.
	 *
	 * @param topicId            the topic id
	 * @param username            the username
	 * @param email the email
	 * @return the string
	 */
	@RequestMapping(value = { "/assign-trainer/{id}/{username}/{email}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String assignTrainer(@PathVariable("id") String topicId, @PathVariable("username") String username, @PathVariable("email") String email) {
		Users user = userService.findByUsername(username);
		JsonObject jsonObject = new JsonObject();
		if (user != null) {
			Topic topic = topicService.findById(topicId);
			topic.setUsers(user);
			Users trainer = topicService.assignTrainer(topic);
			if("true".equals(email)){
				String emailAddress = null;
				for (ProfileUser pro : trainer.getProfileUsers()) {
					if("Email".equals(pro.getProfile().getName())){
						emailAddress = pro.getValue();
						break;
					}
				}
				if(emailAddress != null){
					try {
						String message = "";
						MailService mailService = new MailService(emailAddress, "Assign trainer to topic ", user.getUsername(), message);
						mailService.start();
					} catch (Exception e) {
						LOGGER.error(e);
					}
				}
			}
			if (trainer != null) {
				jsonObject.addProperty("userId", trainer.getId());
				jsonObject.addProperty("username", trainer.getUsername());
				for (ProfileUser profile : trainer.getProfileUsers()) {
					jsonObject.addProperty(profile.getProfile().getName(), profile.getValue());
				}
			}
		}
		return jsonObject.toString();
	}
}
