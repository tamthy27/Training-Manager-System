package com.fsoft.gst.ptithcm.tms.service.implement;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.commonUltil.SessionUtil;
import com.fsoft.gst.ptithcm.tms.model.Category;
import com.fsoft.gst.ptithcm.tms.reposity.CategoryRepository;
import com.fsoft.gst.ptithcm.tms.service.CategoryService;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryServiceImpl.
 */
@Service("catelogyService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	/** The category repository. */
	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Save category.
	 *
	 * @param category
	 *            the category
	 * @return the category
	 */
	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	/**
	 * Delete.
	 *
	 * @param unique
	 *            the unique
	 * @return the category delete category is update this flag delete
	 */
	@Override
	public Category delete(String unique) {

		Category entity = categoryRepository.getByKey(unique);
		if (entity != null) {
			Hibernate.initialize(entity.getCourses());
			// if category have course not allow delte category
			if (checkExistCourse(entity)) {
				entity = null;
			} else {
				categoryRepository.delete(entity);
			}
		}
		return entity;
	}

	/*
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CategoryService#deleteLogic(java.lang.
	 * String)
	 */
	@Override
	public Category deleteLogic(String unique) {
		Category entity = categoryRepository.getByKey(unique);
		if (entity != null) {
			Hibernate.initialize(entity.getCourses());
			if (checkExistCourse(entity)) {
				entity = null;
			} else {
				entity.getLog().setLastModifiedBy(SessionUtil.getUserSession());
				entity.getLog().setLastModifiedDate(new Date());
				entity.getLog().setFlagDelete(true);
				categoryRepository.update(entity);
			}
		}

		return entity;
	}

	/**
	 * Update.
	 *
	 * @param category
	 *            the category
	 * @return the category
	 */
	@Override
	public Category update(Category category) {

		// get category from date base with category id
		Category entity = categoryRepository.getByKey(category.getCategoryId());
		if (entity != null) {
			entity.setName(category.getName());
			entity.setDescription(category.getDescription());
			entity.getLog().setLastModifiedBy(SessionUtil.getUserSession());
			entity.getLog().setLastModifiedDate(new Date());

			categoryRepository.update(entity);
		}
		return entity;

	}

	/**
	 * Find category.
	 *
	 * @return the list
	 */
	@Override
	public List<Category> findAllCategory() {
		return categoryRepository.findByProperty("log.flagDelete", false);
	}

	/**
	 * Count total record.
	 * 
	 * @return the long
	 */
	@Override
	public Long countTotalRecord() {
		return categoryRepository.countTotalRecord();
	}

	/**
	 * Check exist course.
	 *
	 * @param category
	 *            the category
	 * @return the boolean
	 */
	private Boolean checkExistCourse(Category category) {
		final int count = 0;
		if (category.getCourses().size() > count) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CategoryService#findlike(java.lang.
	 * String)
	 */
	@Override
	public List<Category> findlike(String att, String value, String mode) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.CategoryService#findByKey(java.lang.
	 * String)
	 */
	@Override
	public Category findByKey(String categoryId) {

		return categoryRepository.getByKey(categoryId);
	}
}
