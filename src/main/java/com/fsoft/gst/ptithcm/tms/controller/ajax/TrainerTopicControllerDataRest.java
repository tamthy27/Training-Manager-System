/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.controller.ajax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.gst.ptithcm.tms.commonUltil.SessionUtil;
import com.fsoft.gst.ptithcm.tms.model.Category;
import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.TopicService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * @author NVTT  Jun 25, 2017
 *
 */
@RestController
@RequestMapping(value={"/trainer-view"})
public class TrainerTopicControllerDataRest {
	
	@Autowired
	private UsersService userService;
	
	@Autowired 
	private TopicService topicService;
	
	
	@RequestMapping(value = { "/list-topic/{courseId}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String listTopic(@PathVariable("courseId") String courseId) {
		List<Topic> listTopic = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		Users user = SessionUtil.getUserSession();
		if(user != null){
			listTopic = topicService.findAllTopic(courseId, user);
		}
		for (Topic topic : listTopic) {
			temp.add(topic.toString());
		}
		return new Gson().toJson(temp);
	}
	
	@RequestMapping(value={"/calendar/list-topic"}, method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String viewCalender(Model model){
		Users user = SessionUtil.getUserSession();
		List<Topic> listTopic = topicService.findAllTopicByTrainer(String.valueOf(user.getId()));
		List<String> temp = new ArrayList<>();
		for (Topic topic : listTopic) {
			JsonObject jsonObject  = new JsonObject();
			jsonObject.addProperty("category",topic.getCourse().getCategory().getName());
			jsonObject.addProperty("course", topic.getCourse().getName());
			jsonObject.addProperty("name", topic.getName());
			jsonObject.addProperty("topicId", topic.getTopicId());
			jsonObject.addProperty("time", topic.getTimeString());
			jsonObject.addProperty("description", topic.getDescription());
			jsonObject.addProperty("status", topic.getStatus());
			temp.add(jsonObject.toString());
		}
		
		return new Gson().toJson(temp);
	}
}
