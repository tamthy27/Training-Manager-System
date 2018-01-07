package com.fsoft.gst.ptithcm.tms.reposity.implement;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.reposity.CourseRepository;

/**
 * The Class CourseRepositoryImpl.
 */
@Repository()
@Transactional
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class CourseRepositoryImpl extends AbstractRepository<String, Course> implements CourseRepository {

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.CourseRepository#findCourseNewStatus()
	 */
	@Override
	public List<Course> findCourseNewStatus(Boolean delete) {
		String strQuery = "from Course course where " + " course.log.flagDelete =  :delete " + "	and :date < course.startDate ";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		query.setParameter("delete", delete);

		return query.list();
	}

	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.CourseRepository#
	 * findCourseProcessingStatus()
	 */
	@Override
	public List<Course> findCourseProcessingStatus(Boolean delete) {

		String strQuery = "from Course course where " + " course.log.flagDelete = :delete" 
												+ " and :date >= course.startDate " 
														+ " and :date <= course.endDate";

		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		query.setParameter("delete", delete);

		return query.list();
	}

	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.CourseRepository#
	 * findCourseCompletedStatus()
	 */
	@Override
	public List<Course> findCourseCompletedStatus(Boolean delete) {
		String strQuery = "from Course course where " + " course.log.flagDelete = :delete" + " and course.endDate < :date";

		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		query.setParameter("delete", delete);

		return query.list();
	}

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.CourseRepository#findCourseNewStatus(
	 * java.lang.String)
	 */
	@Override
	public List<Course> findCourseNewStatus(String categoryID, Boolean delete) {

		String strQuery = "from Course course where " + " course.category.categoryId = :categoryID " + " and course.log.flagDelete = :delete "
				+ " and :date < course.startDate ";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		query.setParameter("categoryID", categoryID);
		query.setParameter("delete", delete);

		return query.list();
	}

	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.CourseRepository#
	 * findCourseProcessingStatus(java.lang.String)
	 */
	@Override
	public List<Course> findCourseProcessingStatus(String categoryID, Boolean delete) {
		String strQuery = "from Course course where " + "course.category.categoryId = :categoryID " + " and course.log.flagDelete = :delete "
				+ " and :date >= course.startDate " + " and :date <= course.endDate";

		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		query.setParameter("categoryID", categoryID);
		query.setParameter("delete", delete);

		return query.list();
	}

	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.CourseRepository#
	 * findCourseCompletedStatus(java.lang.String)
	 */
	@Override
	public List<Course> findCourseCompletedStatus(String categoryID, Boolean delete) {
		String strQuery = "from Course course where " + " course.category.categoryId = :categoryID " + " and course.log.flagDelete = :delete"
				+ " and course.endDate < :date";

		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		query.setParameter("categoryID", categoryID);
		query.setParameter("delete", delete);

		return query.list();
	}


	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#
	 * findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<Course> findByProperty(String propertyName, Object value) {
		String strQuery = "from Course course where " 
													+ " course.category.categoryId = :categoryID " 
													+ " and course.log.flagDelete = :delete";

		Query query = getSession().createQuery(strQuery);
		query.setParameter("categoryID", propertyName);
		query.setParameter("delete", value);
		return query.list();
	}
	
	@Override
	public List<Course> findTopicByTraineeID(String id) {
		String strQuery = "select traineeCourse.course from TraineeCourse traineeCourse where traineeCourse.users = '" + id + "' " + " and :date < traineeCourse.course.startDate" + " and traineeCourse.course.log.flagDelete = false";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();
	}

	@Override
	public List<Course> findAllTopicNew() {
		String strQuery = "select traineeCourse.course from TraineeCourse traineeCourse where " + " traineeCourse.course.log.flagDelete =  false " + "	and :date < traineeCourse.course.startDate";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();
	}

	@Override
	public List<Course> findAllTopicCompletedByTraineeID(String id) {
		String strQuery = "select traineeCourse.course from TraineeCourse traineeCourse where traineeCourse.users = '" + id + "' " + " and :date >= traineeCourse.course.endDate" + " and traineeCourse.course.log.flagDelete = false";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();
	}

	@Override
	public List<Course> findAllTopicProcessingByTraineeID(String id) {
		String strQuery = "select traineeCourse.course from TraineeCourse traineeCourse where traineeCourse.users = '" + id + "' " + " and :date <= traineeCourse.course.endDate and :date >= traineeCourse.course.startDate " + " and traineeCourse.course.log.flagDelete = false";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();
	}
}
