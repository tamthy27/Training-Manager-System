package com.fsoft.gst.ptithcm.tms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsoft.gst.ptithcm.tms.model.Category;
import com.fsoft.gst.ptithcm.tms.service.CategoryService;

/**
 * The Class CategoryController.
 * @author NVTT Jun 13, 2017
 */
@Controller
@RequestMapping(value = { "/category" })
public class CategoryController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

	/** The category service. */
	@Autowired
	private CategoryService categoryService;

	/**
	 * List category.
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/list-category", "" }, method = RequestMethod.GET)
	public String listCategory(ModelMap model) {
		LOGGER.info("Category");

		List<Category> listCategory = categoryService.findAllCategory();
		model.addAttribute("listcategory", listCategory);
		return "staff-category";
	}

	/**
	 * Creates the category.
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/create-category" }, method = RequestMethod.GET)
	public String createCategory(ModelMap model) {
		LOGGER.info("crate category");
		List<Category> listCategory = categoryService.findAllCategory();
		model.addAttribute("listcategory", listCategory);
		return "staff-category";
	}

}
