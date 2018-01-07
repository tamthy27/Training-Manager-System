/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.Course;

// TODO: Auto-generated Javadoc
/**
 * The Interface CourseService.
 *
 * @author NVTT Jun 11, 2017
 */
public interface CourseService {

	/**
	 * Adds the new course.
	 *
	 * @param course
	 *            the course
	 * @return the course
	 */
	Course addNewCourse(Course course);

	/**
	 * Delete.
	 *
	 * @param unique
	 *            the unique
	 * @return the course
	 */
	Course delete(String unique);

	/**
	 * Update.
	 *
	 * @param course
	 *            the course
	 * @return the course
	 */
	Course update(Course course);

	/**
	 * Find all course.
	 *
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findAllCourse(Boolean delete);

	/**
	 * Find all course by category.
	 *
	 * @param categoryId
	 *            the category id
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findAllCourseByCategory(String categoryId, Boolean delete);

	/**
	 * Find course new status.
	 *
	 * @param categoryID
	 *            the category ID
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findCourseNewStatus(String categoryID, Boolean delete);

	/**
	 * Find course processing status.
	 *
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findCourseProcessingStatus(Boolean delete);

	/**
	 * Find course processing status.
	 *
	 * @param categoryID
	 *            the category ID
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findCourseProcessingStatus(String categoryID, Boolean delete);

	/**
	 * Find course completed status.
	 *
	 * @param categoryID
	 *            the category ID
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findCourseCompletedStatus(String categoryID, Boolean delete);

	/**
	 * Find course completed status.
	 *
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findCourseCompletedStatus(Boolean delete);

	/**
	 * Find course new status.
	 *
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findCourseNewStatus(Boolean delete);

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the course
	 */
	Course findById(String id);

	/**
	 * Findlike.
	 *
	 * @param att the att
	 * @param value the value
	 * @param mode the mode
	 * @return the list
	 */
	List<Course> findlike(String att, String value, String mode);

	/**
	 * Delete logic.
	 *
	 * @param unique the unique
	 * @return the course
	 */
	Course deleteLogic(String unique);
	
	List<Course> getCourseByTraineeId(String id);
	
	List<Course> findAllCourseNew();
	
	List<Course>  getCourseCompletedByTraineeId(String id);
	
	List<Course>  getCourseProcessingByTraineeId(String id);
	
}
