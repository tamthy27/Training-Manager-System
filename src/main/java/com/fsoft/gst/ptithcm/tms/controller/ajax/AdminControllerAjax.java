package com.fsoft.gst.ptithcm.tms.controller.ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.gst.ptithcm.tms.commonUltil.SessionUtil;
import com.fsoft.gst.ptithcm.tms.model.Log;
import com.fsoft.gst.ptithcm.tms.model.Profile;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.ProfileUserId;
import com.fsoft.gst.ptithcm.tms.model.Role;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.RoleRepository;
import com.fsoft.gst.ptithcm.tms.service.ProfileService;
import com.fsoft.gst.ptithcm.tms.service.ProfileuserService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;
import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryControllerAjax.
 * 
 * @author TINHNV Jun 11, 2017
 */
@RestController
@RequestMapping("/admin")
public class AdminControllerAjax {

	/** The service. */
	@Autowired
	private UsersService service;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private ProfileuserService profileuserService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Edits the.
	 *
	 * @param category
	 *            the category
	 * @return the string
	 * 
	 *         controller user edit category
	 */
	@RequestMapping(value = { "/edit/user" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String editTrainer(@RequestBody String str) {

		// Users userUpdate = service.update(user);

		JSONObject jsonObject = new JSONObject(str);

		System.out.println(jsonObject.get("userid"));

		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		String id = jsonObject.getString("userid");

		Users users = service.findById(Integer.parseInt(id));

		if (users != null) {
			users.setUsername(username);
			users.setPassword(passwordEncoder.encode(password));
		}
		users.getLog().setLastModifiedBy(SessionUtil.getUserSession());
		users.getLog().setLastModifiedDate(new Date());

		return service.update(users).toString();
		// return userUpdate.toString();
	}

	@RequestMapping(value = { "/edit/profile" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String editProfileTrainer(@RequestBody String str) {

		// Users userUpdate = service.update(user);

		JSONObject jsonObject = new JSONObject(str);

		System.out.println(jsonObject.get("userId"));

		String id = jsonObject.getString("userId");
		String firstName = jsonObject.getString("firstname");
		String lastName = jsonObject.getString("lastname");
		String birthday = jsonObject.getString("birthday");
		String phone = jsonObject.getString("phone");
		String edu = jsonObject.getString("education");
		String workingPlace = jsonObject.getString("workingplace");
		String email = jsonObject.getString("email");

		
		Users users = service.findById(Integer.parseInt(id));
		
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

				System.out.println("found" + f.getProfile().getName() + " : " + f.getValue());
			}
		}

		users.getLog().setLastModifiedBy(SessionUtil.getUserSession());
		users.getLog().setLastModifiedDate(new Date());
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+service.update(users).toString());
		return service.update(users).toString();
		// return userUpdate.toString();
	}
	@RequestMapping(value = { "/staff/edit" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String editStaff(@RequestBody String str) {

		// Users userUpdate = service.update(user);

		JSONObject jsonObject = new JSONObject(str);

		System.out.println(jsonObject.get("userId"));

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

				System.out.println("found" + f.getProfile().getName() + " : " + f.getValue());
			}
		}

		users.getLog().setLastModifiedBy(SessionUtil.getUserSession());
		users.getLog().setLastModifiedDate(new Date());

		return service.update(users).toString();
		// return userUpdate.toString();
	}

	/**
	 * Delete.
	 *
	 * @param unique
	 *            the unique
	 * @return true, if successful
	 */
	@RequestMapping(value = { "user/delete-{id}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String delete(@PathVariable String id) {
		Users user = service.delete(Integer.parseInt(id));
		return user.toString();
	}

	@RequestMapping(value = { "/add/user" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addTrainer(@RequestBody String str) {

		// Users userUpdate = service.update(user);

		JSONObject jsonObject = new JSONObject(str);

		System.out.println(jsonObject.get("userid"));

		String username = jsonObject.getString("username");

		Users user = service.findByUsername(username);
		if (user != null) {
			return "exist";
		} else {
			
			String password = jsonObject.getString("password");
			String role = jsonObject.getString("role");
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
			users.setUsername(username);
			users.setPassword(passwordEncoder.encode(password));

			Role roleUser = roleRepository.getByKey(role);

			users.setRole(roleUser);
			users.setLog(log);
			
			service.saveUser(users);
			
			users = service.findByUsername(username);
			
			List<Profile> profiles = profileService.findAllProfile();
		
		
			for (int i = 0; i < profiles.size(); i++) {
				
				if ("LastName".equals(profiles.get(i).getName())) {
					ProfileUser profileUser = new ProfileUser();
					Profile profile = profiles.get(i);
					profileUser.setProfile(profile);
					profileUser.setValue(" ");					 
					profileUser.setUsers(users);
					ProfileUserId profileUserId = new ProfileUserId();
					profileUserId.setProfileId(profiles.get(i).getId());
					profileUserId.setUserId(users.getId());
					profileUser.setId(profileUserId);
					service.save(profileUser);
		
				}
				if ("FirstName".equals(profiles.get(i).getName())) {
					ProfileUser profileUser = new ProfileUser();
					Profile profile = profiles.get(i);
					profileUser.setProfile(profile);
					profileUser.setValue(" ");
					profileUser.setUsers(users);
					ProfileUserId profileUserId = new ProfileUserId();
					profileUserId.setProfileId(profiles.get(i).getId());
					profileUserId.setUserId(users.getId());
					profileUser.setId(profileUserId);
					service.save(profileUser);
				}
				if ("Birthday".equals(profiles.get(i).getName())) {
					ProfileUser profileUser = new ProfileUser();
					Profile profile = profiles.get(i);
					profileUser.setProfile(profile);
					profileUser.setValue(" ");
					profileUser.setUsers(users);
					ProfileUserId profileUserId = new ProfileUserId();
					profileUserId.setProfileId(profiles.get(i).getId());
					profileUserId.setUserId(users.getId());
					profileUser.setId(profileUserId);
					service.save(profileUser);
				}

				if ("Phone".equals(profiles.get(i).getName())) {
					ProfileUser profileUser = new ProfileUser();
					Profile profile = profiles.get(i);
					profileUser.setProfile(profile);
					profileUser.setValue(" ");
					profileUser.setUsers(users);
					ProfileUserId profileUserId = new ProfileUserId();
					profileUserId.setProfileId(profiles.get(i).getId());
					profileUserId.setUserId(users.getId());
					profileUser.setId(profileUserId);
					service.save(profileUser);
				}

				if ("Email".equals(profiles.get(i).getName())) {
					ProfileUser profileUser = new ProfileUser();
					Profile profile = profiles.get(i);
					profileUser.setProfile(profile);
					profileUser.setValue(" ");
					profileUser.setUsers(users);
					ProfileUserId profileUserId = new ProfileUserId();
					profileUserId.setProfileId(profiles.get(i).getId());
					profileUserId.setUserId(users.getId());
					profileUser.setId(profileUserId);
					service.save(profileUser);
				}
				
				if ("Education".equals(profiles.get(i).getName())) {
					ProfileUser profileUser = new ProfileUser();
					Profile profile = profiles.get(i);
					profileUser.setProfile(profile);
					profileUser.setValue(" ");
					profileUser.setUsers(users);
					ProfileUserId profileUserId = new ProfileUserId();
					profileUserId.setProfileId(profiles.get(i).getId());
					profileUserId.setUserId(users.getId());
					profileUser.setId(profileUserId);
					service.save(profileUser);
				}

				if ("WorkingPlace".equals(profiles.get(i).getName())) {
					ProfileUser profileUser = new ProfileUser();
					Profile profile = profiles.get(i);
					profileUser.setProfile(profile);
					profileUser.setValue(" ");
					profileUser.setUsers(users);
					ProfileUserId profileUserId = new ProfileUserId();
					profileUserId.setProfileId(profiles.get(i).getId());
					profileUserId.setUserId(users.getId());
					profileUser.setId(profileUserId);
					service.save(profileUser);
				}
			}
		
			return ""+users.getId();
		}

	}

	@RequestMapping(value = { "/quicksearch-{key}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String QuickSearch(@PathVariable String key) {
		List<Users> users = service.findlike("username", key, "1");
		List<ProfileUser> profileUsers = profileuserService.findlike("value", key, "1");
		for (ProfileUser profileUser : profileUsers) {
			Users user = service.findById(profileUser.getUsers().getId());
			users.add(user);
		}
		List<String> temp = new ArrayList<>();
		for (Users user : users) {
			temp.add(user.toString());
		}
		System.out.println("bsearch" + new Gson().toJson(temp));
		return new Gson().toJson(temp);
	}
}
