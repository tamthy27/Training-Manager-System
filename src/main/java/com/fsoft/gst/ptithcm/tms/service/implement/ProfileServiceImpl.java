/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.model.Profile;
import com.fsoft.gst.ptithcm.tms.reposity.ProfileRepository;
import com.fsoft.gst.ptithcm.tms.service.ProfileService;

/**
 * @author Thy Dinh Jun 11, 2017
 *
 */
@Service()
@Transactional
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.ProfileService#saveProfile(com.fsoft.
	 * gst.ptithcm.tms.model.Profile)
	 */
	@Override
	public void saveProfile(Profile profile) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.ProfileService#deleteProfile(com.fsoft.
	 * gst.ptithcm.tms.model.Profile)
	 */
	@Override
	public void deleteProfile(Profile profile) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.ProfileService#updateProfile(com.fsoft.
	 * gst.ptithcm.tms.model.Profile)
	 */
	@Override
	public void updateProfile(Profile profile) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.ProfileService#findProfile(java.lang.
	 * String)
	 */
	@Override
	public Profile findProfile(String profile) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.service.ProfileService#findProfile(int[])
	 */
	@Override
	public List<Profile> findProfile(int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.service.ProfileService#getAllProfile()
	 */
	@Override
	public List<Profile> findAllProfile() {

		return profileRepository.findAll();
	}

	

}
