/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.reposity.implement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fsoft.gst.ptithcm.tms.model.Role;
import com.fsoft.gst.ptithcm.tms.reposity.RoleRepository;

/**
 * @author Thy Dinh Jun 11, 2017
 *s
 */

@Repository()
@EnableTransactionManagement
public class RoleRepositoryImpl  extends AbstractRepository<String, Role> implements RoleRepository{

}
