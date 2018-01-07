package com.fsoft.gst.ptithcm.tms.reposity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;

// TODO: Auto-generated Javadoc
/**
 * The Interface GenericRepository.
 *
 * @param <PK>
 *            the generic type
 * @param <T>
 *            the generic type
 */
public interface GenericRepository<PK extends Serializable, T> {

	/**
	 * Gets the by key.
	 *
	 * @param key
	 *            the key
	 * @return the by key
	 */
	public T getByKey(PK key);

	/**
	 * Persist.
	 *
	 * @param entity
	 *            the entity
	 */
	public void persist(T entity);

	/**
	 * Delete.
	 *
	 * @param entity
	 *            the entity
	 */
	public void delete(T entity);

	/**
	 * Perform an initial save of a previously unsaved T entity. All subsequent
	 * persist actions of this entity should use the #update() method.
	 *
	 * @param entity
	 *            T entity to persist
	 * @return the t
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public T save(T entity);

	/**
	 * Persist a previously saved T entity and return it or a copy of it to the
	 * sender. A copy of the T entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity.
	 * 
	 * @param entity
	 *            T entity to update
	 * @return T the persisted T entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public T update(T entity);

	/**
	 * Delete a persistent T entity.
	 * 
	 * @param id
	 *            the ID of T entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PK id);

	/**
	 * Delete list of persitence entity.
	 *
	 * @param entities
	 *            the entities
	 * @return the integer
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public Integer deleteAll(List<T> entities);

	/**
	 * Delete list of persitence entity.
	 *
	 * @param ids
	 *            the list ID of T entities to delete
	 * @return the integer
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public Integer delete(PK[] ids);

	/**
	 * Find all T entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<T> all T entities
	 */
	public List<T> findPagination(int... rowStartIdxAndCount);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<T> findAll();

	/**
	 * Find like.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the list
	 */
	public List<T> findLike(String property, Object value);

	/**
	 * Find a persistence T entitiy with a field unique.
	 *
	 * @param property
	 *            the field unique of T entity to find.
	 * @param value
	 *            the value of field unique to find
	 * @return T found by query
	 */
	public T findEqualUnique(String property, Object value);

	/**
	 * Find a persistence T entitiy with a field unique.
	 *
	 * @param property
	 *            the field unique of T entity to find.
	 * @param value
	 *            the value of field unique to find
	 * @return T found by query
	 */
	public T findEqualUniqueCaseSensitive(String property, Object value);

	/**
	 * Find all T entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the T property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<T> found by query
	 */
	public List<T> findByPropertyPagination(String propertyName, Object value, int... rowStartIdxAndCount);

	/**
	 * Find by pdsroperty.
	 *
	 * @param propertyName the property name
	 * @param value the value
	 * @return the list
	 */
	public List<T> findByProperty(String propertyName, Object value);

	/**
	 * Search by properties.
	 *
	 * @param properties
	 *            the properties
	 * @param sortExpression
	 *            the sort expression
	 * @param sortDirection
	 *            the sort direction
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @param whereClause
	 *            the where clause
	 * @return the object[]
	 */
	public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer offset, Integer limit,
			String whereClause);

	/**
	 * Search by properties.
	 *
	 * @param properties
	 *            the properties
	 * @param sortExpression
	 *            the sort expression
	 * @param sortDirection
	 *            the sort direction
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the object[]
	 */
	public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer offset, Integer limit);

	/**
	 * Find by properties.
	 *
	 * @param properties
	 *            the properties
	 * @param sortExpression
	 *            the sort expression
	 * @param sortDirection
	 *            the sort direction
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the object
	 */
	public Object findByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer offset, Integer limit);

	/**
	 * Count all records in database.
	 *
	 * @param properties
	 *            the properties
	 * @return number of records
	 */
	public Long countByProperties(Map<String, Object> properties);

	/**
	 * Count total record.
	 *
	 * @return the long
	 */
	public Long countTotalRecord();

	/**
	 * Find property.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the list
	 */
	public List<T> findProperty(String property, Object value);

	/**
	 * Find properties.
	 *
	 * @param properties
	 *            the properties
	 * @return the list
	 */
	public List<T> findProperties(Map<String, Object> properties);

	/**
	 * Creates the entity criteria.
	 *
	 * @return the criteria
	 */
	public Criteria createEntityCriteria();
	
	/**
	 * Save list.
	 *
	 * @param entity the entity
	 */
	public void saveList(List<T> entity);

	public List<T> fintListUser(String property, Object value);
	
	public List<T> findStartWith(String property, Object value);	
	
	public List<T> searchByProperties(Map<String, String> properties,String mode) ;
	public List<T> findByProperty2(String propertyName, Object value);

}
