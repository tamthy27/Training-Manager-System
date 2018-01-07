/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.reposity.implement;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.fsoft.gst.ptithcm.tms.model.TraineeCourse;
import com.fsoft.gst.ptithcm.tms.model.TraineeCourseId;
import com.fsoft.gst.ptithcm.tms.reposity.TraineeCourseRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TraineeCourseRepositoryImpl.
 *
 * @author NVTT Jun 17, 2017
 */
@Repository
@SuppressWarnings("unchecked")
public class TraineeCourseRepositoryImpl extends AbstractRepository<TraineeCourseId, TraineeCourse> implements TraineeCourseRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.TraineeCourseRepository#
	 * findTraineeByCourse(java.lang.String)
	 */

	@Override
	public List<TraineeCourse> findTraineeByCourse(String courseId, Boolean delete) {

		String strQuery = "from TraineeCourse traineeCourse where traineeCourse.course.courseId = :courseId"
				+ " and traineeCourse.users.log.flagDelete = :delete";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("courseId", courseId);
		query.setParameter("delete", delete);

		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.TraineeCourseRepository#
	 * findByUserCourse(java.lang.String, java.lang.String)
	 */
	@Override
	public int deleteByUserCourse(int userId, String courseId) {
		String strQuery = "delete TraineeCourse traineeCourse where traineeCourse.course.courseId = :courseId"
											+ " and traineeCourse.users.id = :userId";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("courseId", courseId);
		query.setParameter("userId", userId);

		return query.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.TraineeCourseRepository#
	 * insertTraineeCourse(com.fsoft.gst.ptithcm.tms.model.TraineeCourse)
	 */
	@Override
	public int insertTraineeCourse(int userId, String courseId) {
		String strQuery = "INSERT INTO TraineeCourse(users,course) VALUES ( "+userId+",'"+courseId+"') ";
		Query query = getSession().createQuery(strQuery);
		/*query.setParameter("user", traineeCourse.getUsers().getId());
		query.setParameter("course", traineeCourse.getCourse().getCourseId());*/
		return query.executeUpdate();
	}

}
