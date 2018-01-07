/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.ProfileUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfileuserService.
 *
 * @author Thy Dinh Jun 17, 2017
 */
public interface ProfileuserService {

	/**
	 * Findlike.
	 *
	 * @param att
	 *            the att
	 * @param value
	 *            the value
	 * @param mode
	 *            the mode
	 * @return the list
	 */
	List<ProfileUser> findlike(String att, String value, String mode);

}
