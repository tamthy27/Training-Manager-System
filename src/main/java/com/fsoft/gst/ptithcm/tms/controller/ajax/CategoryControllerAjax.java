package com.fsoft.gst.ptithcm.tms.controller.ajax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.gst.ptithcm.tms.commonUltil.DeleteConstants;
import com.fsoft.gst.ptithcm.tms.commonUltil.LogUltil;
import com.fsoft.gst.ptithcm.tms.model.Category;
import com.fsoft.gst.ptithcm.tms.service.CategoryService;
import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryControllerAjax.
 * @author NVTT Jun 11, 2017
 */
@RestController
@RequestMapping("/category")
public class CategoryControllerAjax {

	/** The service. */
	@Autowired
	private CategoryService service;

	/**
	 * List course new.
	 *
	 * @return the string
	 */
	@RequestMapping(value = { "/list-category" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String listCourseNew() {
		List<Category> categories = service.findAllCategory();
		List<String> temp = new ArrayList<>();
		for (Category cat : categories) {
			temp.add(cat.toString());
		}
		return new Gson().toJson(temp);
	}

	/**
	 * Adds the category.
	 * 
	 * @param category
	 *            the category
	 * @return the string controller use new create a category
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addCategory(@RequestBody Category category) {
		category.setLog(LogUltil.newLog());
		// overwrite object to json type
		return service.saveCategory(category).toString();
	}

	/**
	 * Edits the.
	 * 
	 * @param category
	 *            the category
	 * @return the string controller user edit category
	 */
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String edit(@RequestBody Category category) {
		Category categoryUpdated = service.update(category);
		return categoryUpdated.toString();
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @param type the type
	 * @return true, if successful
	 */
	@RequestMapping(value = { "/delete/{id}/{type}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String delete(@PathVariable("id") String id, @PathVariable("type") String type) {
		Category category = null;
		if (DeleteConstants.DELETE_HARD.equals(type)) {
			category = service.delete(id);
		} else if (DeleteConstants.DELETE_SORT.equals(type)) {
			category = service.deleteLogic(id);
		}
		String result = "";
		try {
			result = category.toString();
		} catch (Exception e) {

		}

		return result;
	}

}
