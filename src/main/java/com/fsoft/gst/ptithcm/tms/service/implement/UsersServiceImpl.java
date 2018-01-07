package com.fsoft.gst.ptithcm.tms.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.commonUltil.RoleUtil;
import com.fsoft.gst.ptithcm.tms.commonUltil.SessionUtil;
import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.Role;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.UsersRepository;
import com.fsoft.gst.ptithcm.tms.service.UsersService;

/**
 * The Class UsersServiceImpl.
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {

	/** The repository. */
	@Autowired
	private UsersRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#saveUser(com.fsoft.gst.
	 * ptithcm.tms.model.Users)
	 */
	public void saveUser(Users user) {
		repository.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#deleteUser(com.fsoft.gst.
	 * ptithcm.tms.model.Users)
	 */
	@Override
	public void deleteUser(Users users) {
		repository.delete(users);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.service.UsersService#findById(int)
	 */
	@Override
	public Users findById(int id) {
		return repository.getByKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#updateUser(com.fsoft.gst.
	 * ptithcm.tms.model.Users)
	 */
	@Override
	public void updateUser(Users user) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#findAllUsers(java.lang.
	 * Integer[])
	 */
	@Override
	public List<Users> findAllUsers(String role) {
		return repository.findAllUser(role);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#findByUsername(java.lang.
	 * String)
	 */
	@Override
	public Users findByUsername(String username) {

		return repository.findByUsername(username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#searchListBuUsername(java.
	 * lang.String)
	 */
	@Override
	public List<Users> searchListByUsername(String key) {

		return repository.findLike("username", key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#saveListUser(java.util.
	 * List)
	 */
	@Override
	public void saveListUser(List<Users> users) {

		repository.saveList(users);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#findAllTrainee(java.lang.
	 * Integer[])
	 */
	@Override
	public List<Users> findAllTrainee(Integer... rowStartIdxAndCount) {
		Role role = new Role();
		role.setRoleId(RoleUtil.ROLE_TRAINEE.getRoleUtil());
		role.setRoleName(RoleUtil.ROLE_TRAINEE.getRoleUtil());

		return repository.findByPropertyPagination("role", role, rowStartIdxAndCount[0], rowStartIdxAndCount[1]);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.UsersService#update(com.fsoft.gst.ptithcm.tms.model.Users)
	 */
	@Override
	public Users update(Users user) {

		return repository.update(user);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.UsersService#updateTrainer(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Users updateTrainer(String userId, String profileID, String value) {

		return null;
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.UsersService#delete(int)
	 */
	@Override
	public Users delete(int unique) {
		Users entity = repository.getByKey(unique);
		if (entity != null) {
			entity.getLog().setLastModifiedBy(SessionUtil.getUserSession());
			entity.getLog().setLastModifiedDate(new Date());
			entity.getLog().setFlagDelete(true);

			repository.update(entity);
		}
		return entity;
	}

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#findlike(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Users> findlike(String att, String value, String mode) {

		List<Users> users = repository.findLike(att, value);
		return users;
	}

	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.UsersService#findAllUserByRoleCourse(
	 * java.lang.String, com.fsoft.gst.ptithcm.tms.model.Course)
	 */
	@Override
	public List<Users> findAllUserByRoleCourse(String role, Course course) {

		return repository.findAllUserByRoleCourse(role, course);
	}

	/* 
	 * @see com.fsoft.gst.ptithcm.tms.service.UsersService#findAllCourse(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Course> findAllCourse(String username, String role) {
		return repository.findAllCourse(username, role);
	}

	@Override
	public ProfileUser save(ProfileUser profileuser) {
		// TODO Auto-generated method stub
		return repository.save(profileuser);
	}
}