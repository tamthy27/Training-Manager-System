package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Profile.
 *
 * @author NVTT May 13, 2017
 */
@Entity
@Table(name = "PROFILE", schema = "dbo", catalog = "TMS")
public class Profile implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private int id;

	/** The name. */
	private String name;

	/** The description. */
	private String description;

	/**
	 * Instantiates a new profile.
	 */
	public Profile() {
	}

	/**
	 * Instantiates a new profile.
	 *
	 * @param propertyId
	 *            the property id
	 * @param name
	 *            the name
	 */
	public Profile(int propertyId, String name) {
		this.id = propertyId;
		this.name = name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false)
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
	@Column(name = "Description")
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
}
