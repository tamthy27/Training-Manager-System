package com.fsoft.gst.ptithcm.tms.model;
// Generated May 13, 2017 5:20:16 PM by Hibernate Tools 4.3.1.Final

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class RolePermisstionId.
 *
 * @author NVTT May 13, 2017
 */
@Embeddable
public class RolePermisstionId implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role id. */
	private byte[] roleId;

	/** The permission id. */
	private byte[] permissionId;

	/**
	 * Instantiates a new role permisstion id.
	 */
	public RolePermisstionId() {
	}

	/**
	 * Instantiates a new role permisstion id.
	 *
	 * @param roleId
	 *            the role id
	 * @param permissionId
	 *            the permission id
	 */
	public RolePermisstionId(byte[] roleId, byte[] permissionId) {
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	@Column(name = "RoleID", nullable = false)
	public byte[] getRoleId() {
		return this.roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId
	 *            the new role id
	 */
	public void setRoleId(byte[] roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the permission id.
	 *
	 * @return the permission id
	 */
	@Column(name = "PermissionID", nullable = false)
	public byte[] getPermissionId() {
		return this.permissionId;
	}

	/**
	 * Sets the permission id.
	 *
	 * @param permissionId
	 *            the new permission id
	 */
	public void setPermissionId(byte[] permissionId) {
		this.permissionId = permissionId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RolePermisstionId))
			return false;
		RolePermisstionId castOther = (RolePermisstionId) other;

		return ((this.getRoleId() == castOther.getRoleId())
				|| (this.getRoleId() != null && castOther.getRoleId() != null && Arrays.equals(this.getRoleId(), castOther.getRoleId())))
				&& ((this.getPermissionId() == castOther.getPermissionId()) || (this.getPermissionId() != null && castOther.getPermissionId() != null
						&& Arrays.equals(this.getPermissionId(), castOther.getPermissionId())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRoleId() == null ? 0 : Arrays.hashCode(this.getRoleId()));
		result = 37 * result + (getPermissionId() == null ? 0 : Arrays.hashCode(this.getPermissionId()));
		return result;
	}

}
