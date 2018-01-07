package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * 
 *
 * @author NVTT May 13, 2017
 */
@Entity
@Table(name = "ROLE", schema = "dbo", catalog = "TMS")
public class Role implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role id. */
	private String roleId;

	/** The role name. */
	private String roleName;

	/** The decription. */
	private String decription;

	/** The role permisstions. */
	private Set<RolePermisstion> rolePermisstions = new HashSet<RolePermisstion>(0);

	/**
	 * Instantiates a new role.
	 */
	public Role() {
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	@Id
	@Column(name = "RoleID", unique = true, nullable = false)
	public String getRoleId() {
		return this.roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId
	 *            the new role id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	@Column(name = "RoleName", nullable = false)
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName
	 *            the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Gets the decription.
	 *
	 * @return the decription
	 */
	@Column(name = "Decription")
	public String getDecription() {
		return this.decription;
	}

	/**
	 * Sets the decription.
	 *
	 * @param decription
	 *            the new decription
	 */
	public void setDecription(String decription) {
		this.decription = decription;
	}

	/**
	 * Gets the role permisstions.
	 *
	 * @return the role permisstions
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RolePermisstion> getRolePermisstions() {
		return this.rolePermisstions;
	}

	/**
	 * Sets the role permisstions.
	 *
	 * @param rolePermisstions
	 *            the new role permisstions
	 */
	public void setRolePermisstions(Set<RolePermisstion> rolePermisstions) {
		this.rolePermisstions = rolePermisstions;
	}

}
