/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.commonUltil;

/**
 * The Enum RoleUtil.
 * @author NVTT Jun 24, 2017
 */
public enum RoleUtil {

	/** The role admin. */
	ROLE_ADMIN("AD"), /** The role user. */
	ROLE_USER("STAFF"), /** The role trainer. */
	ROLE_TRAINER("TRAINER"), /** The role trainee. */
	ROLE_TRAINEE("TRAINEE");

	/** The role ultil. */
	private String roleUltil;

	/**
	 * Instantiates a new role util.
	 * @param roleUltil the role ultil
	 */
	private RoleUtil(String roleUltil) {
		this.roleUltil = roleUltil;
	}

	/**
	 * Gets the role util.
	 * @return the role util
	 */
	public String getRoleUtil() {
		return this.roleUltil;
	}
}
