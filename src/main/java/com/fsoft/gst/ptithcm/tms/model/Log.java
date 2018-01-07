package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The Class Log.
 *
 * @author NVTT May 13, 2017
 */
@Entity
@Table(name = "LOG", schema = "dbo", catalog = "TMS")
public class Log implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The log id. */
	private int logId;

	/** The created by. */
	private Users createdBy;

	/** The created date. */
	private Date createdDate;

	/** The last modified by. */
	private Users lastModifiedBy;

	/** The last modified date. */
	private Date lastModifiedDate;

	/** The flag delete. */
	private boolean flagDelete;

	/**
	 * Instantiates a new log.
	 */
	public Log() {
	}

	/**
	 * Gets the log id.
	 *
	 * @return the log id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LogID", unique = true, nullable = false)
	public int getLogId() {
		return this.logId;
	}

	/**
	 * Sets the log id.
	 *
	 * @param logId
	 *            the new log id
	 */
	public void setLogId(int logId) {
		this.logId = logId;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CreatedBy", nullable = false)
	// @Column(name = "CreatedBy", nullable = false)
	public Users getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy
	 *            the new created by
	 */
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CreatedDate", nullable = false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate
	 *            the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the last modified by.
	 *
	 * @return the last modified by
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LastModifiedBY", nullable = false)
	public Users getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	/**
	 * Sets the last modified by.
	 *
	 * @param lastModifiedBy
	 *            the new last modified by
	 */
	public void setLastModifiedBy(Users lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * Gets the last modified date.
	 *
	 * @return the last modified date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "LastModifiedDate", nullable = false)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	/**
	 * Sets the last modified date.
	 *
	 * @param lastModifiedDate
	 *            the new last modified date
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * Checks if is flag delete.
	 *
	 * @return true, if is flag delete
	 */
	@Column(name = "FlagDelete", nullable = false)
	public boolean isFlagDelete() {
		return this.flagDelete;
	}

	/**
	 * Sets the flag delete.
	 *
	 * @param flagDelete
	 *            the new flag delete
	 */
	public void setFlagDelete(boolean flagDelete) {
		this.flagDelete = flagDelete;
	}

}
