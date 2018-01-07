package com.fsoft.gst.ptithcm.tms.service;

import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.Category;

// TODO: Auto-generated Javadoc
/**
 * The Interface CategoryService.
 * 
 * @author NVTT May 13, 2017
 */
public interface CategoryService {

	/**
	 * Save category.
	 *
	 * @param category            the category
	 * @return the category
	 */
	Category saveCategory(Category category);

	/**
	 * Delete.
	 *
	 * @param unique the unique
	 * @return the category
	 */
	Category delete(String unique);

	/**
	 * Delete logic.
	 *
	 * @param unique the unique
	 * @return the category
	 */
	Category deleteLogic(String unique);

	/**
	 * Update.
	 *
	 * @param category            the category
	 * @return the category
	 */
	Category update(Category category);

	/**
	 * Find category.
	 *
	 * @return the list
	 */
	List<Category> findAllCategory();
	
	/**
	 * Find by key.
	 *
	 * @param categoryId the category id
	 * @return the category
	 */
	Category findByKey(String categoryId);

	/**
	 * Count total record.
	 *
	 * @return the long
	 */
	Long countTotalRecord();

	/**
	 * Findlike.
	 *
	 * @param att the att
	 * @param value the value
	 * @param mode the mode
	 * @return the list
	 */
	List<Category> findlike(String att, String value, String mode);
}
