package com.fsoft.gst.ptithcm.tms.reposity;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.Course;

/**
 * The Interface CourseRepository.
 */
public interface CourseRepository extends GenericRepository<String, Course> {

	/**
	 * Find course new status.
	 *
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findCourseNewStatus(Boolean delete);

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
	 * @param delete
	 *            the delete
	 * @return the list
	 */
	List<Course> findCourseCompletedStatus(Boolean delete);

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

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findByProperty(java.
	 * lang.String, java.lang.Object)
	 */
	List<Course> findByProperty(String propertyName, Object value);
	List<Course> findTopicByTraineeID(String id);
	
	List<Course> findAllTopicNew();
	
	List<Course> findAllTopicCompletedByTraineeID(String id);
	
	List<Course> findAllTopicProcessingByTraineeID(String id);
	

	
}
