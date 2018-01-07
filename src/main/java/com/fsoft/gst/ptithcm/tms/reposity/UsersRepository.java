package com.fsoft.gst.ptithcm.tms.reposity;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.Users;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsersRepository.
 */
public interface UsersRepository extends GenericRepository<Integer, Users> {

	/**
	 * Find by username.
	 *
	 * @param username
	 *            the username
	 * @return the users
	 */
	Users findByUsername(String username);

	/**
	 * Find all user.
	 *
	 * @param role
	 *            the role
	 * @return the list
	 */
	List<Users> findAllUser(String role);

	/**
	 * Find all user by role course.
	 *
	 * @param role
	 *            the role
	 * @param course
	 *            the course
	 * @return the list
	 */
	List<Users> findAllUserByRoleCourse(String role, Course course);

	/**
	 * @param username
	 * @param role
	 * @return
	 */
	List<Course> findAllCourse(String username, String role);

	public ProfileUser save(ProfileUser profileuser);
}
