package com.fsoft.gst.ptithcm.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsoft.gst.ptithcm.tms.commonUltil.RoleUtil;
import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.TopicService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;

/**
 * The Class TrainerController.
 */
@Controller
@RequestMapping(value = { "/trainer" })
public class TrainerController {

	/** The user service. */
	@Autowired
	private UsersService userService;

	/** The topic service. */
	@Autowired
	private TopicService topicService;

	/**
	 * List trainer.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = { "/list-trainer", "" }, method = RequestMethod.GET)
	public String listTrainer(ModelMap model) {
		List<Users> listUser = userService.findAllUsers(RoleUtil.ROLE_TRAINER.getRoleUtil());
		List<Topic> listTopic = topicService.findAllTopicNew();
		model.addAttribute("listUser", listUser);
		model.addAttribute("listTopic", listTopic);
		return "staff-trainer";
	}
}
