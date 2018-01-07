package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class Permission.
 *
 * @author NVTT May 13, 2017
 */
@Entity
@Table(name = "PERMISSION", schema = "dbo", catalog = "TMS")
public class Permission implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private String id;	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
//	/** The role permisstions. */
//	private Set<RolePermisstion> rolePermisstions = new HashSet<RolePermisstion>(0);

	/**
	 * Instantiates a new permission.
	 */
	public Permission() {
	}

	
	

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
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
	 * @param name the new name
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
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

//	/**
//	 * Gets the role permisstions.
//	 *
//	 * @return the role permisstions
//	 */
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permission")
//	public Set<RolePermisstion> getRolePermisstions() {
//		return this.rolePermisstions;
//	}

//	/**
//	 * Sets the role permisstions.
//	 *
//	 * @param rolePermisstions the new role permisstions
//	 */
//	public void setRolePermisstions(Set<RolePermisstion> rolePermisstions) {
//		this.rolePermisstions = rolePermisstions;
//	}

}
