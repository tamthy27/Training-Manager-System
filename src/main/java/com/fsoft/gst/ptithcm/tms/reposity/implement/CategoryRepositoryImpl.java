package com.fsoft.gst.ptithcm.tms.reposity.implement;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fsoft.gst.ptithcm.tms.model.Category;
import com.fsoft.gst.ptithcm.tms.reposity.CategoryRepository;

@Repository("categoryRepository")
@EnableTransactionManagement
public class CategoryRepositoryImpl extends AbstractRepository<String, Category> implements CategoryRepository {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#
	 * findByProperty(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findByProperty(String propertyName, Object value) {
		String strQuery = "from Category category where  category.log.flagDelete = :delete";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("delete", value);

		return query.list();
	}
	
	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#findLike(java.lang.String, java.lang.Object)
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findLike(String property, Object value) {
		Criteria crit =  getSession().createCriteria(Category.class, "category");
		crit.add(Restrictions.eq(property,"%"+ value + "%"));
		return crit.list();
	}*/
	
	
	
	
	
}
