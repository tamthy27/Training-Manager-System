/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.model.TraineeCourse;
import com.fsoft.gst.ptithcm.tms.reposity.TraineeCourseRepository;
import com.fsoft.gst.ptithcm.tms.service.TraineeCourseService;

// TODO: Auto-generated Javadoc
/**
 * The Class TraineeCourseServiceImpl.
 *
 * @author NVTT Jun 17, 2017
 */
@Service()
@Transactional
public class TraineeCourseServiceImpl implements TraineeCourseService {

	/** The repository. */
	@Autowired
	private TraineeCourseRepository repository;

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TraineeCourseService#findTraineeByCourse(java.lang.String, java.lang.Boolean)
	 */
	/*
	 * @see com.fsoft.gst.ptithcm.tms.service.TraineeCourseService#
	 * findTraineeByCourse(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public List<TraineeCourse> findTraineeByCourse(String courseId, Boolean delete) {
		return repository.findTraineeByCourse(courseId, delete);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TraineeCourseService#remove(int, java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TraineeCourseService#remove(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public int remove(int userId, String courseId) {

		return repository.deleteByUserCourse(userId, courseId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.service.TraineeCourseService#
	 * insertTraineeCourse(com.fsoft.gst.ptithcm.tms.model.TraineeCourse)
	 */
	@Override
	public void insertTraineeCourse(TraineeCourse traineeCourse) {
		
		repository.save(traineeCourse);
	}

}
