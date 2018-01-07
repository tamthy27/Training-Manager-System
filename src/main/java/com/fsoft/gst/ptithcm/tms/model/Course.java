package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.fsoft.gst.ptithcm.tms.commonUltil.Constants;
import com.fsoft.gst.ptithcm.tms.commonUltil.DateUtil;
import com.google.gson.JsonObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Course.
 *
 * @author NVTT May 13, 2017
 */
@Entity
@Table(name = "COURSE", schema = "dbo", catalog = "TMS",uniqueConstraints = @UniqueConstraint(columnNames = "LogID"))
public class Course implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The course id. */
	private String courseId;

	/** The category. */
	private Category category;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;
	
	/** The log. */
	private Log log;

	/** The name. */
	private String name;

	/** The description. */
	private String description;

	/** The topics. */
	private Set<Topic> topics = new HashSet<Topic>(0);

	/** The trainee courses. */
	private Set<TraineeCourse> traineeCourses = new HashSet<TraineeCourse>(0);

	/**
	 * Instantiates a new course.
	 */
	public Course() {
	}

	/**
	 * Gets the course id.
	 *
	 * @return the course id
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
	@GeneratedValue(generator = "generator")
	@Column(name = "CourseID", columnDefinition = "uniqueidentifier")
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

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CategoryID", nullable = false)
	@JsonIgnore
	public Category getCategory() {
		return this.category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category
	 *            the new category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "StartDate", nullable = false)
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Gets the start date string.
	 *
	 * @return the start date string
	 */
	@Transient
	public String getStartDateString(){
		String date = DateUtil.date2String(getStartDate(),Constants.DATE_FORMAT);
		return date;
	}
	
	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "EndDate", nullable = false)
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * Gets the end date string.
	 *
	 * @return the end date string
	 */
	@Transient
	public String getEndDateString(){
		String date = DateUtil.date2String(this.endDate,Constants.DATE_FORMAT);
		return date;
	}

/**
 * Sets the end date.
 *
 * @param endDate the new end date
 */
//	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the log.
	 *
	 * @return the log
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "LogID", unique = true)
	@JsonIgnore
	public Log getLog() {
		return this.log;
	}

	/**
	 * Sets the log.
	 *
	 * @param log
	 *            the new log
	 */
	public void setLog(Log log) {
		this.log = log;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Column(name = "Description",nullable=false)
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the topics.
	 *
	 * @return the topics
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	@JsonIgnore
	public Set<Topic> getTopics() {
		return this.topics;
	}

	/**
	 * Sets the topics.
	 *
	 * @param topics
	 *            the new topics
	 */
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	/**
	 * Gets the trainee courses.
	 *
	 * @return the trainee courses
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	@JsonIgnore
	public Set<TraineeCourse> getTraineeCourses() {
		return this.traineeCourses;
	}

	/**
	 * Sets the trainee courses.
	 *
	 * @param traineeCourses
	 *            the new trainee courses
	 */
	public void setTraineeCourses(Set<TraineeCourse> traineeCourses) {
		this.traineeCourses = traineeCourses;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("category",this.category.getCategoryId());
		jsonObject.addProperty("courseId",this.courseId);
		jsonObject.addProperty("name", this.name);
		jsonObject.addProperty("description",this.description);
		jsonObject.addProperty("startDate",DateUtil.date2String(this.startDate, Constants.DATE_FORMAT));
		jsonObject.addProperty("endDate",DateUtil.date2String(this.endDate, Constants.DATE_FORMAT));
		return jsonObject.toString();
	}
}
