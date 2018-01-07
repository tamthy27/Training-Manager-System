package com.fsoft.gst.ptithcm.tms.reposity.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.ProfileUserId;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.UsersRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UsersRepositoryImpl.
 * 
 * @author NVTT May 13, 2017.
 */
@Repository("usersRepository")
@Transactional
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class UsersRepositoryImpl extends AbstractRepository<Integer, Users> implements UsersRepository {

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.reposity.UsersRepository#findByUsername(java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.UsersRepository#findByUsername(java.
	 * lang.String)
	 */
	@Override
	public Users findByUsername(String username) {

		Users user = findEqualUnique("username", username);
		if (user != null) {

			Hibernate.initialize(user.getRole());
			Hibernate.initialize(user.getLog());
			Hibernate.initialize(user.getProfileUsers());
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#saveList(java.util.List)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#saveList(
	 * java.util.List)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#saveList(
	 * java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveList(List<Users> entity) {
		List<ProfileUser> profileUsers = new ArrayList<>();
		List<Users> users = new ArrayList<>();
		for (Users user : entity) {
			Users tempuser = new Users();
			tempuser.setRole(user.getRole());
			tempuser.setUsername(user.getUsername());
			tempuser.setPassword(user.getPassword());
			tempuser.setLog(user.getLog());
			users.add(tempuser);
			Set<ProfileUser> temp = user.getProfileUsers();
			for (ProfileUser profileUser : temp) {
				profileUsers.add(profileUser);
			}
		}
		for (Users t : users) {
			save(t);
		}
		List<Users> usersafterget = findAll();

		for (ProfileUser t : profileUsers) {
			for (Users urs : usersafterget) {
				if (t.getUsers().getUsername().equals(urs.getUsername())) {
					t.setUsers(urs);
					ProfileUserId profileUserId = new ProfileUserId();
					profileUserId.setProfileId(t.getProfile().getId());
					profileUserId.setUserId(t.getUsers().getId());
					t.setId(profileUserId);
					break;
				}
			}
		}
		for (ProfileUser t : profileUsers) {
			save(t);
		}

	}
	
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#save(java
	 * .lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Users save(Users entity) {
		getSession().persist(entity);
		return entity;
	}
	
	@Override
	
	/**
	 * Save.
	 *
	 * @param profileuser the profileuser
	 * @return the profile user
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public ProfileUser save(ProfileUser profileuser) {
		getSession().persist(profileuser);
		return profileuser;

	}
	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.reposity.UsersRepository#findAllUser(java.lang.String)
	 */
	@Override
	public List<Users> findAllUser(String role) {
		// where user.log.flagDelete = :delete or user.log = null
		String strQuery = "from Users user where user.role = '"+role+"' AND log.flagDelete = 'false' ";
		Query query = getSession().createQuery(strQuery);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.reposity.UsersRepository#
	 * findAllUserByRoleCourse(java.lang.String, com.fsoft.gst.ptithcm.tms.model.Course)
	 */
	@Override
	public List<Users> findAllUserByRoleCourse(String role, Course course) {
		String strQuery = "from Users user where user.role = '"+role+"' and user.log.flagDelete = 'false'"
						+ " and "
							+ "not exists ( from TraineeCourse as tr where tr.users.id = user.id "
								+ "	and tr.course.log.flagDelete = 'false' "
								+ " and ( ( :start <= tr.course.startDate and :end >= tr.course.startDate )"
									+ " or (:start <= tr.course.endDate and :end >= tr.course.endDate) "
								+ ") "
							+ ")";
											
		Query query = getSession().createQuery(strQuery);
		query.setParameter("start", course.getStartDate());
		query.setParameter("end", course.getEndDate());
		return query.list();
	} 
	
	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.reposity.UsersRepository#findAllCourse(java.lang.String)
	 */
	@Override
	public List<Course> findAllCourse(String username,String role) {
		String strQuery = "select user. from Users user where user.username = '" +username + "'"
											+ " and user.role = '"+role+"' and log.flagDelete = 'false' ";
		Query query = getSession().createQuery(strQuery);
		return query.list();
	}

}