package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.fsoft.gst.ptithcm.tms.commonUltil.Constants;
import com.fsoft.gst.ptithcm.tms.commonUltil.DateUtil;
import com.google.gson.JsonObject;

/**
 * The Class Topic.
 *
 * @author NVTT May 13, 2017
 */
@Entity
@Table(name = "TOPIC", schema = "dbo", catalog = "TMS", uniqueConstraints = @UniqueConstraint(columnNames = "LogID"))
public class Topic implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The topic id. */
	private String topicId;

	/** The course. */
	private Course course;

	/** The log. */
	private Log log;

	/** The users. */
	private Users users;

	/** The name. */
	private String name;

	/** The description. */
	private String description;

	/** The time. */
	private Date time;

	/**
	 * Instantiates a new topic.
	 */
	public Topic() {
	}

	/**
	 * Gets the topic id.
	 *
	 * @return the topic id
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
	@GeneratedValue(generator = "generator")
	@Column(name = "TopicID", columnDefinition = "uniqueidentifier")
	public String getTopicId() {
		return this.topicId;
	}

	/**
	 * Sets the topic id.
	 *
	 * @param topicId
	 *            the new topic id
	 */
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	/**
	 * Gets the course.
	 *
	 * @return the course
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CourseID", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	/**
	 * Sets the course.
	 *
	 * @param course
	 *            the new course
	 */
	public void setCourse(Course course) {
		this.course = course;
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
	 * Gets the users.
	 *
	 * @return the users
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TrainerID")
	public Users getUsers() {
		return this.users;
	}

	/**
	 * Sets the users.
	 *
	 * @param users
	 *            the new users
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(name = "Name", unique = true, nullable = false)
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
	@Column(name = "Description", nullable = false)
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
	 * Gets the time string.
	 *
	 * @return the time string
	 */
	@Transient
	public String getTimeString() {
		String date = DateUtil.date2String(this.time, Constants.DATE_FORMAT);
		return date;
	}
	
	@Transient
	public String getStatus() {
		Date now = new Date();
		if(this.time.after(now)){
			return "new";
		}{
			return "completed";
		}
	}
	
	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	@Column(name = "Time", nullable = false)
	public Date getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time
	 *            the new time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("topicId", this.topicId);
		jsonObject.addProperty("course", this.course.getCourseId());
		jsonObject.addProperty("name", this.name);
		jsonObject.addProperty("description", this.description);
		jsonObject.addProperty("time", DateUtil.date2String(this.time, Constants.DATE_FORMAT));
		jsonObject.addProperty("status",getStatus());
		return jsonObject.toString();
	}

}
