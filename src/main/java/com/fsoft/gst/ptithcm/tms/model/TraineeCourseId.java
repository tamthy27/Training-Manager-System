package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class TraineeCourseId.
 *
 * @author NVTT May 13, 2017
 */
@Embeddable
public class TraineeCourseId implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trainee. */
	private int trainee;

	/** The course id. */
	private String courseId;

	/**
	 * Instantiates a new trainee course id.
	 */
	public TraineeCourseId() {
	}

	/**
	 * Instantiates a new trainee course id.
	 *
	 * @param trainee
	 *            the trainee
	 * @param courseId
	 *            the course id
	 */
	public TraineeCourseId(int trainee, String courseId) {
		this.trainee = trainee;
		this.courseId = courseId;
	}

	/**
	 * Gets the trainee.
	 *
	 * @return the trainee
	 */
	@Column(name = "Trainee", nullable = false)
	public int getTrainee() {
		return this.trainee;
	}

	/**
	 * Sets the trainee.
	 *
	 * @param trainee
	 *            the new trainee
	 */
	public void setTrainee(int trainee) {
		this.trainee = trainee;
	}

	/**
	 * Gets the course id.
	 *
	 * @return the course id
	 */
	@Column(name = "CourseID", nullable = false, insertable = false, updatable = false)
	public String getCourseId() {
		return this.courseId;
	}

	/**
	 * Sets the course id.
	 *
	 * @param courseId
	 *            the new course id
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/*
	 * public boolean equals(Object other) { if ((this == other)) return true;
	 * if ((other == null)) return false; if (!(other instanceof
	 * TraineeCourseId)) return false; TraineeCourseId castOther =
	 * (TraineeCourseId) other;
	 * 
	 * return ((this.getTrainee() == castOther.getTrainee()) &&
	 * ((this.getCourseId() == castOther.getCourseId())));
	 * 
	 * }
	 * 
	 * public int hashCode() { int result = 17;
	 * 
	 * result = 37 * result + this.getTrainee(); result = 37 * result +
	 * (getCourseId() == null ? 0 : Arrays.hashCode(this.getCourseId())); return
	 * result; }
	 */

}
