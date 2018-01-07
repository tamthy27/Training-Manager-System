package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class TraineeCourse.
 *
 * @author NVTT May 13, 2017
 */
@Entity
@Table(name = "TRAINEE_COURSE", schema = "dbo", catalog = "TMS")
public class TraineeCourse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private TraineeCourseId id;
	
	/** The course. */
	private Course course;
	
	/** The users. */
	private Users users;

	/**
	 * Instantiates a new trainee course.
	 */
	public TraineeCourse() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "trainee", column = @Column(name = "Trainee", nullable = false)),
			@AttributeOverride(name = "courseId", column = @Column(name = "CourseID", nullable = false)) })
	public TraineeCourseId getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(TraineeCourseId id) {
		this.id = id;
	}

	/**
	 * Gets the course.
	 *
	 * @return the course
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CourseID", nullable = false, insertable = false, updatable = false)
	public Course getCourse() {
		return this.course;
	}

	/**
	 * Sets the course.
	 *
	 * @param course the new course
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Trainee", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	/**
	 * Sets the users.
	 *
	 * @param users the new users
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

}
