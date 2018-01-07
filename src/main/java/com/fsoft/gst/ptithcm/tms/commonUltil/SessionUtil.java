package com.fsoft.gst.ptithcm.tms.commonUltil;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fsoft.gst.ptithcm.tms.model.CustomUserDetails;
import com.fsoft.gst.ptithcm.tms.model.Users;

/**
 * The Class SessionUtil.
 */
public class SessionUtil {

	/**
	 * Gets the user session.
	 *
	 * @return the user session
	 */
	// get User from CustomUserDetails
	public static Users getUserSession() {
		CustomUserDetails myUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Users user = myUserDetails.getUser();

		return user;
	}
}
