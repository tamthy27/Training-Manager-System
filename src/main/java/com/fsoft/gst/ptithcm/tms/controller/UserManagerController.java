package com.fsoft.gst.ptithcm.tms.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsoft.gst.ptithcm.tms.commonUltil.SessionUtil;
import com.fsoft.gst.ptithcm.tms.model.Log;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.UsersService;

/**
 * The Class UserManagerController.
 * 
 * @author NVTT May 13, 2017
 */
@Controller
@RequestMapping(value = { "/user" })
public class UserManagerController {

	/** The permission service. */
	@Autowired
	private UsersService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public String Category(ModelMap model) {
		return "Staff-Trainer";
	}

	@RequestMapping(value = { "/new-user" }, method = RequestMethod.GET)
	public String addUser(@Valid Users user, ModelMap model) {

		Users entity = userService.findById(2);

		String password = "123";
		password = passwordEncoder.encode(password);
		// userService.saveUser(user);
		Users admin = SessionUtil.getUserSession();
		Log log = new Log();
		log.setCreatedBy(admin);
		log.setLastModifiedBy(admin);
		log.setFlagDelete(false);
		Date date = new Date();
		log.setCreatedDate(date);
		log.setLastModifiedDate(date);

		Users users = new Users();
		users.setUsername("TrangNV");
		users.setPassword(passwordEncoder.encode("123"));
		users.setRole(entity.getRole());
		users.setLog(log);
		userService.saveUser(users);
		return "listUser";
	}

	@RequestMapping(value = { "/list-user" }, method = RequestMethod.GET)
	public String listUser(ModelMap model) {
		List<Users> listUser = userService.findAllUsers("AD");
		model.addAttribute("listUser", listUser);
		for (Users users : listUser) {
			for (Iterator<ProfileUser> it = users.getProfileUsers().iterator(); it.hasNext();) {
				ProfileUser f = it.next();
				System.out.println("found" + f.getProfile().getName() + " : " + f.getValue());
			}
		}
		return "admin";
	}
	/**
	 * Update user.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	public String updateUser(@Valid Users user, ModelMap model) {

		// CustomUserDetails myUserDetails = (CustomUserDetails)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//
		// Users user = myUserDetails.getUser();
		//
		// String firstname = user.getUsername();

		return "home";

	}

	@RequestMapping(value = { "/list-trainee" }, method = RequestMethod.GET)
	public String listTrainee(ModelMap model) {
		List<Users> listUser = userService.findAllTrainee(0, 13);
		model.addAttribute("listTrainee", listUser);
		return "admin";
	}

	

}