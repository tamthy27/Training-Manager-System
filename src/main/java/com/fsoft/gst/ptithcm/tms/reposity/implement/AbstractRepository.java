package com.fsoft.gst.ptithcm.tms.reposity.implement;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.GenericRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractDao.
 *
 * @param <PK>
 *            the generic type
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("unchecked")
@Transactional
@EnableTransactionManagement
public abstract class AbstractRepository<PK extends Serializable, T> implements GenericRepository<PK, T> {

	/** The persistent class. */
	private final Class<T> persistentClass;

	/**
	 * Instantiates a new abstract dao.
	 */

	public AbstractRepository() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass

		()).getActualTypeArguments()[1];
	}

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#createEntityCriteria
	 * ()
	 */
	@Override
	public Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#persist(java.lang.
	 * Object)
	 */
	@Override
	public void persist(T entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#delete(java.io.
	 * Serializable)
	 */
	@Override
	public void delete(PK id) {

	}

	/**
	 * Gets the by key.
	 *
	 * @param key
	 *            the key
	 * @return the by key
	 */

	@Override
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#save(java.lang.
	 * Object)
	 */
	@Override
	public T save(T entity) {
		T t = (T) getSession().merge(entity);
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#update(java.lang.
	 * Object)
	 */
	@Override
	public T update(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#delete(java.lang.
	 * Object)
	 */
	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#deleteAll(java.util.
	 * List)
	 */
	@Override
	public Integer deleteAll(List<T> entities) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#delete(java.io.
	 * Serializable[])
	 */
	@Override
	public Integer delete(PK[] ids) {
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findPagination(int[]
	 * )
	 */
	// find pagination
	@Override
	public List<T> findPagination(final int... rowStartIdxAndCount) {
		try {
			Criteria criteria = createEntityCriteria();
			// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					criteria.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						criteria.setMaxResults(rowCount);
					}
				}
			}

			List<T> list = criteria.list();
			// Hibernate.initialize(list);
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findAll()
	 */
	@Override
	public List<T> findAll() {
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findLike(java.lang.
	 * String, java.lang.Object)
	 */
	@Override
	public List<T> findLike(String property, Object value) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.like(property, "%" + value + "%"));
		return crit.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findEqualUnique(java
	 * .lang.String, java.lang.Object)
	 */
	@Override
	public T findEqualUnique(String property, Object value) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq(property, value));
		T user = (T) crit.uniqueResult();
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#
	 * findEqualUniqueCaseSensitive(java.lang.String, java.lang.Object)
	 */
	@Override
	public T findEqualUniqueCaseSensitive(String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findByProperty(java.
	 * lang.String, java.lang.Object, int[])
	 */
	@Override
	public List<T> findByPropertyPagination(String propertyName, Object value, int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		try {
			Criteria crit = createEntityCriteria();
			crit.add(Restrictions.eq(propertyName, value));
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					crit.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						crit.setMaxResults(rowCount);
					}
				}
			}
			List<T> list = crit.list();
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findByPdsroperty(
	 * java.lang.String, java.lang.Object)
	 */
	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq(propertyName, value));

		return crit.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#
	 * searchByProperties(java.util.Map, java.lang.String, java.lang.String,
	 * java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection,
			Integer offset, Integer limit, String whereClause) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#
	 * searchByProperties(java.util.Map, java.lang.String, java.lang.String,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection,
			Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#
	 * findByProperties(java.util.Map, java.lang.String, java.lang.String,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Object findByProperties(Map<String, Object> properties, String sortExpression, String sortDirection,
			Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#countByProperties(
	 * java.util.Map)
	 */
	@Override
	public Long countByProperties(Map<String, Object> properties) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#countTotalRecord()
	 */
	@Override
	public Long countTotalRecord() {
		Criteria crit = createEntityCriteria();
		crit.setProjection(Projections.rowCount());
		return (Long) crit.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findProperty(java.
	 * lang.String, java.lang.Object)
	 */
	@Override
	public List<T> findProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#findProperties(java.
	 * util.Map)
	 */
	@Override
	public List<T> findProperties(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#saveList(java.util.
	 * List)
	 */
	@Override
	public void saveList(List<T> entity) {
		try {
			// getSession().getTransaction().begin();
			for (T t : entity) {
				getSession().persist(t);
			}
			// getSession().getTransaction().commit();
		} catch (RuntimeException re) {
			// getSession().getTransaction().rollback();
		}

	}

	@Override
	public List<T> fintListUser(String property, Object value) {

		Criteria critUser = getSession().createCriteria(Users.class, "users");
		critUser.createAlias("users.log", "log");
		critUser.add(Restrictions.eq("log.flagDelete", false));
		critUser.add(Restrictions.eq(property, value));
		List<T> users = critUser.list();
		return users;

	}

	@Override
	public List<T> findStartWith(String property, Object value) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.like(property, value + "%"));
		return crit.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.GenericRepository#searchByProperties(
	 * java.util.Map)
	 */
	@Override
	public List<T> searchByProperties(Map<String, String> properties, String mode) {
		List<T> t = new ArrayList<>();
		for (Map.Entry<String, String> entry : properties.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (mode == "1") {

			}
			Criteria crit = createEntityCriteria();
			crit.add(Restrictions.like(key, value + "%"));
			t.addAll(crit.list());
		}

		return t;
	}

	public List<T> findByProperty2(String propertyName, Object value) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.like(propertyName, value));
		return crit.list();
	}

}