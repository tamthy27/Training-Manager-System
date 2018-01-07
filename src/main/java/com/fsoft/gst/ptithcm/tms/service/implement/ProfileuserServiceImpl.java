/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.reposity.ProfileUserRepository;
import com.fsoft.gst.ptithcm.tms.service.ProfileuserService;

/**
 * @author Thy Dinh Jun 17, 2017
 *
 */


@Service()
@Transactional
public class ProfileuserServiceImpl implements ProfileuserService {

	@Autowired
	private ProfileUserRepository  profileuserRepository;
	
	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.ProfileService#findlike(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProfileUser> findlike(String key, String value,String mode) {
		if(mode.equals("1"))
		{
			return profileuserRepository.findLike(key, value);

	
		}
		else
		{
			if(mode.equals("2"))
			{
				return profileuserRepository.findStartWith(key, value);
			}
			else
			{
				return profileuserRepository.findByProperty2(key, value);
			}
		}
	}
}
