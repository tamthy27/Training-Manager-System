/**	
	
	@Override
	public List<Course> findlike(String key,String value,String mode) {
		if(mode=="1")
		{
			return reposity.findLike(key, value);
 * 
 */
package com.fsoft.gst.ptithcm.tms.service.implement;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.commonUltil.SessionUtil;
import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.reposity.CourseRepository;
import com.fsoft.gst.ptithcm.tms.service.CourseService;

/**
 * The Class CourseServiceImpl.
 *
 * @author NVTT Jun 11, 2017
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	/** The reposity. */
	@Autowired
	private CourseRepository reposity;

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#saveCourse(com.fsoft.gst.
	 * ptithcm.tms.model.Course)
	 */
	@Override
	public Course addNewCourse(Course course) {
		return reposity.save(course);
	}

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#findCourseNewStatus()
	 */
	@Override
	public List<Course> findCourseNewStatus(Boolean delete) {
		return reposity.findCourseNewStatus(delete);
	}

	/*
	 * @see com.fsoft.gst.ptithcm.tms.service.CourseService#
	 * findCourseProcessingStatus()
	 */
	@Override
	public List<Course> findCourseProcessingStatus(Boolean delete) {
		return reposity.findCourseProcessingStatus(delete);
	}

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#findCourseCompletedStatus
	 * ()
	 */
	@Override
	public List<Course> findCourseCompletedStatus(Boolean delete) {
		return reposity.findCourseCompletedStatus(delete);
	}

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#findCourseNewStatus(java.
	 * lang.String)
	 */
	@Override
	public List<Course> findCourseNewStatus(String categoryID, Boolean delete) {
		return reposity.findCourseNewStatus(categoryID, delete);
	}

	/*
	 * @see com.fsoft.gst.ptithcm.tms.service.CourseService#
	 * findCourseProcessingStatus(java.lang.String)
	 */
	@Override
	public List<Course> findCourseProcessingStatus(String categoryID, Boolean delete) {
		return reposity.findCourseProcessingStatus(categoryID, delete);
	}

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#findCourseCompletedStatus
	 * (java.lang.String)
	 */
	@Override
	public List<Course> findCourseCompletedStatus(String categoryID, Boolean delete) {
		return reposity.findCourseCompletedStatus(categoryID, delete);
	}

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#delete(java.lang.String)
	 */
	@Override
	public Course delete(String unique) {
		Course entity = reposity.getByKey(unique);
		if (entity != null) {

			Hibernate.initialize(entity.getTopics());

			if (checkExistCourse(entity)) {
				entity = null;
			} else {
				reposity.delete(entity);
			}
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#deleteLogic(java.lang.
	 * String)
	 */
	@Override
	public Course deleteLogic(String unique) {
		Course entity = reposity.getByKey(unique);
		if (entity != null) {
			Hibernate.initialize(entity.getTopics());
			if (checkExistCourse(entity)) {
				entity = null;
			} else {
				entity.getLog().setLastModifiedBy(SessionUtil.getUserSession());
				entity.getLog().setLastModifiedDate(new Date());
				entity.getLog().setFlagDelete(true);
				reposity.update(entity);
			}

		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#update(com.fsoft.gst.
	 * ptithcm.tms.model.Course)
	 */
	@Override
	public Course update(Course course) {
		Course entity = reposity.getByKey(course.getCourseId());
		if (entity != null) {
			entity.setName(course.getName());
			entity.setDescription(course.getDescription());
			entity.setCategory(course.getCategory());
			entity.setStartDate(course.getStartDate());
			entity.setEndDate(course.getEndDate());
			entity.getLog().setLastModifiedBy(SessionUtil.getUserSession());
			entity.getLog().setLastModifiedDate(new Date());
			reposity.update(entity);
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CourseService#findAllCourse(java.lang.
	 * Boolean)
	 */
	@Override
	public List<Course> findAllCourse(Boolean delete) {

		return null;
	}

	/*
	 * @see com.fsoft.gst.ptithcm.tms.service.CourseService#findById(int)
	 */
	@Override
	public Course findById(String id) {
		return reposity.getByKey(id);
	}

	/* 
	 * @see com.fsoft.gst.ptithcm.tms.service.CourseService#findAllCourseByCategory(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public List<Course> findAllCourseByCategory(String categoryId, Boolean delete) {
		return reposity.findByProperty(categoryId, delete);
	}

	/*
	 * @see com.fsoft.gst.ptithcm.tms.service.CourseService#findlike(java.lang.
	 * String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Course> findlike(String att, String value, String mode) {
		return null;
	}

	/**
	 * Check exist course.
	 *
	 * @param course the course
	 * @return the boolean
	 */
	private Boolean checkExistCourse(Course course) {
		if (course.getTopics().size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Course> getCourseByTraineeId(String id) {
		return reposity.findTopicByTraineeID(id);
	}

	@Override
	public List<Course> findAllCourseNew() {
		return reposity.findAllTopicNew();
	}

	@Override
	public List<Course> getCourseCompletedByTraineeId(String id) {
		return reposity.findAllTopicCompletedByTraineeID(id);
	}

	@Override
	public List<Course> getCourseProcessingByTraineeId(String id) {
		return reposity.findAllTopicProcessingByTraineeID(id);
	}
	
}
