/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsoft.gst.ptithcm.tms.model.Category;
import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.service.CategoryService;
import com.fsoft.gst.ptithcm.tms.service.CourseService;

/**
 * @author NVTT  Jun 25, 2017
 *
 */
@Controller
@RequestMapping(value={"/trainer-view"})
public class TrainerTopicController {
	
	private static final Logger LOGGER = Logger.getLogger(TrainerTopicController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value={"/list-topic",""}, method = RequestMethod.GET)
	public String getListTopic(Model model){
		LOGGER.info("Trainer view list topic");
		List<Category> listCategory = categoryService.findAllCategory();
		for (Category category : listCategory) {
			List<Course> courses = courseService.findAllCourseByCategory(category.getCategoryId(), false);
			Set<Course> listCourse = new HashSet<Course>(courses);
			category.setCourses(listCourse);
			LOGGER.info(category.getCourses().size());
		}
		model.addAttribute("listCategory", listCategory);
		return "trainer-topic";
	}

	@RequestMapping(value={"/calendar"}, method = RequestMethod.GET)
	public String viewCalender(Model model){
		return "trainer-calendar";
	}
	
}
