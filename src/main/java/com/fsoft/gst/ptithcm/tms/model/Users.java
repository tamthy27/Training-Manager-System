package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The Class Users.
 *
 * @author NVTT May 13, 2017
 */
@Entity
@Table(name = "USERS", schema = "dbo", catalog = "TMS", uniqueConstraints = { @UniqueConstraint(columnNames = "Username"),
		@UniqueConstraint(columnNames = "LogID") })
public class Users implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private int id;

	/** The log. */
	private Log log;

	/** The role. */
	private Role role;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The profile users. */
	private Set<ProfileUser> profileUsers = new HashSet<ProfileUser>(0);

	/** The courses. */
	private Set<Course> courses = new HashSet<Course>(0);

	/** The topics. */
	private Set<Topic> topics = new HashSet<Topic>(0);

	/**
	 * Instantiates a new users.
	 */
	public Users() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Gets the role.
	 *
	 * @return the role
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Role", nullable = false)
	@JsonIgnore
	public Role getRole() {
		return this.role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role
	 *            the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Column(name = "Username", unique = true, nullable = false)
	public String getUsername() {
		return this.username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the courses.
	 *
	 * @return the courses
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TRAINEE_COURSE", catalog = "TMS", joinColumns = {
			@JoinColumn(name = "Trainee", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CourseID", nullable = false, updatable = false) })
	@JsonIgnore
	public Set<Course> getCourses() {
		return this.courses;
	}

	/**
	 * Sets the courses.
	 *
	 * @param courses
	 *            the new courses
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "users", cascade = CascadeType.ALL)
	public Set<ProfileUser> getProfileUsers() {
		return this.profileUsers;
	}

	/**
	 * Sets the profile users.
	 *
	 * @param profileUsers
	 *            the new profile users
	 */
	public void setProfileUsers(Set<ProfileUser> profileUsers) {
		this.profileUsers = profileUsers;
	}

	/**
	 * Gets the topics.
	 *
	 * @return the topics
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
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

}
