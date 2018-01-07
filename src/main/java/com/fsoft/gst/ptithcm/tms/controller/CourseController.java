/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsoft.gst.ptithcm.tms.model.Category;
import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.model.TraineeCourse;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.CategoryService;
import com.fsoft.gst.ptithcm.tms.service.CourseService;
import com.fsoft.gst.ptithcm.tms.service.TraineeCourseService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;

/**
 * The Class CourseController.
 *
 * @author NVTT Jun 13, 2017
 */
@Controller
@RequestMapping(value = { "/course" })
public class CourseController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

	/** The course service. */
	@Autowired
	private CourseService courseService;

	/** The category service. */
	@Autowired
	private CategoryService categoryService;

	/** The trainee course service. */
	@Autowired
	private TraineeCourseService traineeCourseService;

	/** The user service. */
	@Autowired
	private UsersService userService;

	/**
	 * List category.
	 *
	 * @param model the model
	 * @param categoryId the category id
	 * @return the string
	 */
	@RequestMapping(value = { "/list-course/{categoryId}" }, method = RequestMethod.GET)
	public String listCategory(ModelMap model, @PathVariable String categoryId) {
		LOGGER.info("Category");
		List<Course> listCoursePro = courseService.findCourseProcessingStatus(categoryId, false);
		List<Course> listCourseNew = courseService.findCourseNewStatus(categoryId, false);
		List<Course> listCourseCom = courseService.findCourseCompletedStatus(categoryId, false);
		model.addAttribute("listCoursePro", listCoursePro);
		model.addAttribute("listCourseNew", listCourseNew);
		model.addAttribute("listCourseCom", listCourseCom);
		Category category = categoryService.findByKey(categoryId);
		model.addAttribute("category", category);
		return "staff-course";
	}

	/**
	 * List trainee.
	 *
	 * @param model the model
	 * @param courseId the course id
	 * @return the string
	 */
	@RequestMapping(value = { "/course-view-list-trainee/{courseId}" }, method = RequestMethod.GET)
	public String listTrainee(ModelMap model, @PathVariable String courseId) {
		Course course = courseService.findById(courseId);
		List<TraineeCourse> traineeCourses = traineeCourseService.findTraineeByCourse(courseId, false);
		List<Users> listTraineeAdd = userService.findAllUserByRoleCourse("TRAINEE", course);
		model.addAttribute("course", course);
		model.addAttribute("listTrainee", traineeCourses);
		model.addAttribute("listTraineeAdd", listTraineeAdd);
		return "course-view-list-trainee";
	}
}
