/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.TraineeCourse;

// TODO: Auto-generated Javadoc
/**
 * The Interface TraineeCourseService.
 *
 * @author NVTT Jun 17, 2017
 */
public interface TraineeCourseService {

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
	 * Removes the.
	 *
	 * @param userId
	 *            the user id
	 * @param courseId
	 *            the course id
	 * @return the int
	 */
	int remove(int userId, String courseId);

	/**
	 * Insert trainee course.
	 *
	 * @param traineeCourse the trainee course
	 */
	void insertTraineeCourse(TraineeCourse traineeCourse);
}
