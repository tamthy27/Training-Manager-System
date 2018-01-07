/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class MainController.
 *
 * @author NVTT May 28, 2017
 */

@Controller
public class MainController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(MainController.class);

	/**
	 * Home.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "home";
	}

	/**
	 * Not acces page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/403" }, method = RequestMethod.GET)
	public String notAccesPage(ModelMap model) {
		return "403";

	}

	/**
	 * Up file.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/upfile" }, method = RequestMethod.GET)
	public String upFile(ModelMap model) {
		return "file";

	}

	/**
	 * Login.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model) {
		LOGGER.info("Login: ");
		return "login";
	}

	/**
	 * Logout.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the string
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "login";
	}

}
