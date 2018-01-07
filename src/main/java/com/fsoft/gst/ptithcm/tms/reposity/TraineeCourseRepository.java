/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.reposity;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.TraineeCourse;
import com.fsoft.gst.ptithcm.tms.model.TraineeCourseId;

// TODO: Auto-generated Javadoc
/**
 * The Interface TraineeCourseRepository.
 *
 * @author NVTT Jun 17, 2017
 */

public interface TraineeCourseRepository extends GenericRepository<TraineeCourseId, TraineeCourse> {

	/**
	 * Find trainee by course.
	 *
	 * @param courseId
	 *            the course id
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<TraineeCourse> findTraineeByCourse(String courseId, Boolean delete);

	/**
	 * Find by user course.
	 *
	 * @param userId
	 *            the user id
	 * @param courseId
	 *            the course id
	 * @return the int
	 */
	int deleteByUserCourse(int userId, String courseId);

	/**
	 * Insert trainee course.
	 *
	 * @param traineeCourse the trainee course
	 * @return the int
	 */
	int insertTraineeCourse(int userId, String courseId);
}
