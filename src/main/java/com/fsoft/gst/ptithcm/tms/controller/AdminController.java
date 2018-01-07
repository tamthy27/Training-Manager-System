package com.fsoft.gst.ptithcm.tms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.UsersService;

/**
 * The Class AdminController.
 */
@Controller
@RequestMapping(value = { "/admin" })
public class AdminController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(AdminController.class);

	/** The user service. */
	@Autowired
	private UsersService userService;

	/**
	 * List trainer.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = { "/list-trainer" }, method = RequestMethod.GET)
	public String listTrainer(ModelMap model) {
		LOGGER.info("List-Trainer");
		List<Users> listUser = userService.findAllUsers("TRAINER");
		model.addAttribute("listUser", listUser);
		return "Admin_Trainer";
	}

	/**
	 * List trainee.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = { "/list-staff" }, method = RequestMethod.GET)
	public String listTrainee(ModelMap model) {
		LOGGER.info("List-staff");
		List<Users> listUser = userService.findAllUsers("STAFF");
		model.addAttribute("listUser", listUser);
		return "Admin_Staff";
	}

	/**
	 * Profile.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public String profile(ModelMap model) {
		return "profile";
	}

}
