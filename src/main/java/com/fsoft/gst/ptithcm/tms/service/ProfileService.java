/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.Profile;

/**
 * The Interface ProfileService.
 *
 * @author Thy Dinh Jun 11, 2017
 */
public interface ProfileService {

	/**
	 * Save profile.
	 *
	 * @param profile the profile
	 */
	void saveProfile(Profile profile);

	/**
	 * Delete profile.
	 *
	 * @param profile the profile
	 */
	void deleteProfile(Profile profile);

	/**
	 * Update profile.
	 *
	 * @param profile the profile
	 */
	void updateProfile(Profile profile);

	/**
	 * Find profile.
	 *
	 * @param profile the profile
	 * @return the profile
	 */
	Profile findProfile(String profile);

	/**
	 * Find profile.
	 *
	 * @param rowStartIdxAndCount the row start idx and count
	 * @return the list
	 */
	List<Profile> findProfile(int... rowStartIdxAndCount);

	/**
	 * Gets the all profile.
	 *
	 * @return the all profile
	 */
	List<Profile> findAllProfile();

}
