/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.reposity.implement;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fsoft.gst.ptithcm.tms.model.Profile;
import com.fsoft.gst.ptithcm.tms.reposity.ProfileRepository;

/**
 * @author Thy Dinh Jun 11, 2017
 *
 */
@Repository()
@EnableTransactionManagement
public class ProfileRepositoryImpl  extends AbstractRepository<String, Profile> implements ProfileRepository {

}
