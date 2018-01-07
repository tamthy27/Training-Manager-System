/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.controller.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.UsersService;

/**
 * @author NVTT Jun 6, 2017
 *
 */
@RestController
@RequestMapping("/user")
public class UsersControllerAjax {

	@Autowired
	private UsersService service;

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String editUsers(@RequestParam("username") String username) {

		return null;
	}
	
	
	@RequestMapping(value = { "/search" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<Users> search(@RequestParam("username") String username) {

		List<Users> listUsers = service.searchListByUsername(username);

		return listUsers;
	}

}
