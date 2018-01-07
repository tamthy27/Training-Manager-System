/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.reposity.implement;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.reposity.ProfileUserRepository;

/**
 * @author Thy Dinh Jun 11, 2017
 *
 */

@Repository("profileRepository")
@EnableTransactionManagement
public class ProfileUserRepositoryImpl  extends AbstractRepository<String, ProfileUser> implements ProfileUserRepository {

}
