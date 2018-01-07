package com.fsoft.gst.ptithcm.tms.service;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.Users;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsersService.
 */
public interface UsersService {

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the users
	 */
	Users findById(int id);

	/**
	 * Save user.
	 *
	 * @param user
	 *            the user
	 */
	void saveUser(Users user);

	/**
	 * Update user.
	 *
	 * @param user
	 *            the user
	 */
	void updateUser(Users user);

	/**
	 * Delete user.
	 *
	 * @param users
	 *            the users
	 */
	void deleteUser(Users users);

	/**
	 * Search list by username.
	 *
	 * @param key
	 *            the key
	 * @return the list
	 */
	List<Users> searchListByUsername(String key);

	/**
	 * Save list user.
	 *
	 * @param users
	 *            the users
	 */
	void saveListUser(List<Users> users);

	/**
	 * Find all users.
	 *
	 * @param role the role
	 * @return the list
	 */
	List<Users> findAllUsers(String role);

	/**
	 * Find by username.
	 *
	 * @param username
	 *            the username
	 * @return the users
	 */
	Users findByUsername(String username);

	/**
	 * Find all trainee.
	 *
	 * @param rowStartIdxAndCount
	 *            the row start idx and count
	 * @return the list
	 */
	List<Users> findAllTrainee(Integer... rowStartIdxAndCount);

	/**
	 * Update.
	 *
	 * @param user the user
	 * @return the users
	 */
	Users update(Users user);

	/**
	 * Update trainer.
	 *
	 * @param userId the user id
	 * @param profileID the profile ID
	 * @param value the value
	 * @return the users
	 */
	Users updateTrainer(String userId, String profileID, String value);

	/**
	 * Delete.
	 *
	 * @param unique the unique
	 * @return the users
	 */
	Users delete(int unique);

	/**
	 * Find all user by role course.
	 *
	 * @param role the role
	 * @param course the course
	 * @return the list
	 */
	List<Users> findAllUserByRoleCourse(String role, Course course);

	/**
	 * Findlike.
	 *
	 * @param string the string
	 * @param key the key
	 * @param mode the mode
	 * @return the list
	 */
	List<Users> findlike(String string, String key, String mode);
	
	 ProfileUser save(ProfileUser profileuser);

	/**
	 * Find all course.
	 *
	 * @param username the username
	 * @param role the role
	 * @return the list
	 */
	List<Course> findAllCourse(String username, String role);
}
